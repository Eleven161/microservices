package com.example.HotelService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HotelService.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}
