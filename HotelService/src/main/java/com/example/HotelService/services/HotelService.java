package com.example.HotelService.services;

import java.util.List;

import com.example.HotelService.entities.Hotel;

public interface HotelService {
	
	Hotel createHotel(Hotel hotel);
	List<Hotel> getAllHotels();
	Hotel getHotel(String hotelId);

}
