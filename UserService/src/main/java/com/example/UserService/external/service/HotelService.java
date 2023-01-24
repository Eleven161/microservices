package com.example.UserService.external.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.UserService.entities.Hotel;
import com.example.UserService.entities.Rating;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {
	
	@GetMapping("/hotels/{id}")
	Hotel getHotel(@PathVariable String id);
	@GetMapping
	String greet();
	@PostMapping("/hotels")
	Hotel createHotel(Hotel values);

}
