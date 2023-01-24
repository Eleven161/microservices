package com.example.UserService.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {

	private String userId;
	private String feedback;
	private String ratingId;
	private String hotelId;
	private int rating;
	private Hotel hotel;
}
