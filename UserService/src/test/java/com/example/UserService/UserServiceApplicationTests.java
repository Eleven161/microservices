package com.example.UserService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.UserService.entities.Hotel;
import com.example.UserService.entities.Rating;
import com.example.UserService.external.service.HotelService;
import com.example.UserService.external.service.RatingService;

@SpringBootTest
@Service
@RestController
@RequestMapping("/test")
class UserServiceApplicationTests {
    @Autowired
    private HotelService hotelService;
	@Test
	void contextLoads() {
		Hotel hotel=Hotel.builder().about("hotel created using feign").id("").location("bokaro").name("raj").build();
		Hotel savedhotel=hotelService.createHotel(hotel);
		System.out.println("hotel details"+savedhotel);
	}
	
//	@Autowired
//	private RatingService ratingService;
//	@Test
//    void createRating() {
//    	//Rating rating=Rating.builder().rating(10).userId("").hotelId("").feedback("this is created using feign").build();
//    ratingService.deleteRating("63ca1b15ec24aa35847d4d00");
//    	System.out.println(" rating deleted");
//    }
}
