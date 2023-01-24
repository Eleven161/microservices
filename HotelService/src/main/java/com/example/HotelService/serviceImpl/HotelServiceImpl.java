package com.example.HotelService.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HotelService.entities.Hotel;
import com.example.HotelService.exception.ResourceNotFoundException;
import com.example.HotelService.repositories.HotelRepository;
import com.example.HotelService.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService{
	@Autowired
	private HotelRepository hotelRepo;

	@Override
	public Hotel createHotel(Hotel hotel) {
		String hotelId=UUID.randomUUID().toString();
		hotel.setId(hotelId);
		return hotelRepo.save(hotel);
		
	}

	@Override
	public List<Hotel> getAllHotels() {
		return hotelRepo.findAll();
	}

	@Override
	public Hotel getHotel(String hotelId) {
		return hotelRepo.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("this hotel with id "+hotelId+" not found"));
	}

}
