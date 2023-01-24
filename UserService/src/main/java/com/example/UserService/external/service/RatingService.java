package com.example.UserService.external.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.UserService.entities.Rating;

@FeignClient(name="RATING-SERVICE")
public interface RatingService {
	
	//Get
	
	//create
	@PostMapping("/ratings")
	Rating createRating(Rating values);
	//update-Put
	@PutMapping("/ratings/{ratingId}")
	Rating updateRating(@PathVariable String ratingId,Rating rating);
	@DeleteMapping("/ratings/{ratingId}")
	void deleteRating(@PathVariable String ratingId);
	

}
