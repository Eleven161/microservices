package com.example.UserService.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.UserService.entities.User;
import com.example.UserService.services.UserServices;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserServices userServices;
//	@Autowired
//	private Logger logger=org.slf4j.LoggerFactory.getLogger(UserController.class);
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		User savedUser=userServices.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
	}
	
	int retryCount=1;
	@GetMapping("/{userId}")
	//@CircuitBreaker(name="ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
	//@Retry(name="ratingHotelService",fallbackMethod = "ratingHotelFallback")
	@RateLimiter(name="useRateLimiter",fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<User> getUser(@PathVariable String userId){
		User user=userServices.getUser(userId);
		retryCount++;
		return ResponseEntity.ok(user);
		
	}
	
	public ResponseEntity<User> ratingHotelFallback(String userId,Exception ex){
		//creating fall back method for circuit breaker
		//logger.info("Fallback method is executed because service is down",ex.getMessage());
		User user=User.builder()
		.email("dummy@gmail.com")
		.name("Dummy")
		.about("this user is created dummy because some service is down")
		.userId(userId).build();
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<List<User>> getAllusers(){
		List<User> users=userServices.getAllUser();
		return ResponseEntity.ok(users);
	}

}
