package com.example.HotelService.controller;

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

import com.example.HotelService.entities.Hotel;
import com.example.HotelService.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	@Autowired
	private HotelService hotelService;
	
	
	@PostMapping
	
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.createHotel(hotel));
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<Hotel> getHotel(@PathVariable String id){
		
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.getHotel(id));
	}
	
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels(){
    	return ResponseEntity.ok(hotelService.getAllHotels());
    }
}
