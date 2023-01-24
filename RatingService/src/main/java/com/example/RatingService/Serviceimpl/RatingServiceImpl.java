package com.example.RatingService.Serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RatingService.Service.RatingService;
import com.example.RatingService.entities.Rating;
import com.example.RatingService.repository.RatingRepository;
@Service
public class RatingServiceImpl implements RatingService{
@Autowired
private RatingRepository ratingRepo;

@Override
public Rating createRating(Rating rating) {
	return ratingRepo.save(rating);
}

@Override
public List<Rating> getRatings() {
	return ratingRepo.findAll();
}

@Override
public List<Rating> getRatingByUserId(String userId) {
	return ratingRepo.findByUserId(userId);
}

@Override
public List<Rating> getRatingByHotelId(String hotelId) {
	return ratingRepo.findByHotelId(hotelId);
}

}
