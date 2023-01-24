package com.example.RatingService.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("rating")//name is different from collection name in mongodb, but will be created
public class Rating {
    
	private String userId;
	private String feedback;
	 @Id
	private String ratingId;
	private String hotelId;
	private int rating;
}
