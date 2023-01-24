package com.example.RatingService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RatingService.Service.RatingService;
import com.example.RatingService.entities.Rating;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	@Autowired
	private RatingService ratingService;
	@PostMapping
	public ResponseEntity<Rating> create(@RequestBody Rating rating){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));
	}
	@GetMapping
	
	public ResponseEntity<List<Rating>> getRatings(){
		return ResponseEntity.ok((ratingService.getRatings()));
	}
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingsByUser(@PathVariable String userId){
	
		return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
	}
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingsByHotel(@PathVariable String hotelId){
	
		return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
	}

}
