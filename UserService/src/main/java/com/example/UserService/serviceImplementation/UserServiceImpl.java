package com.example.UserService.serviceImplementation;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.UserService.entities.Hotel;
import com.example.UserService.entities.Rating;
import com.example.UserService.entities.User;
import com.example.UserService.exceptions.ResourceNotFoundException;
import com.example.UserService.external.service.HotelService;
import com.example.UserService.repositories.UserRepository;
import com.example.UserService.services.UserServices;

@Service
public class UserServiceImpl implements UserServices {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private HotelService hotelService;
    private Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);
	@Override
	public User saveUser(User user) {
		String randomUserId=UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		List<User> users=userRepo.findAll();
		//implement rating service using rest template and set all these users ratings, so rating wouldn't be empty
		for(User user:users) {
			Rating[] r=restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
			user.setRatings(Arrays.asList(r));
		}
		
		return users;
	}

	@Override
	public User getUser(String userId) {
		User user= userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user not found with ID"+userId));
		//fetching rating of the above mention user from rating service
		//logger.info("response status code:{}",forEntity.getStatusCode());
		//logger.info("{}",ratingList);
		Rating[] ratings=restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
		List<Rating> ratingOfUser=Arrays.asList(ratings);
		List<Rating> ratingList= 
				ratingOfUser.stream().map(r->{ 
					//ResponseEntity<Hotel> forEntity=restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+r.getHotelId(), Hotel.class);
					//Hotel hotel=forEntity.getBody();
			        Hotel hotel=hotelService.getHotel(r.getHotelId());
					//logger.info("response status code:{}",forEntity.getStatusCode());
			r.setHotel(hotel);
			return r;
		}).collect(Collectors.toList());
		
		user.setRatings(ratingList);
		return user;
	}

}
