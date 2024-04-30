package com.gd.rating.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gd.rating.entities.Rating;

@Service
public interface RatingService {

	// create
	Rating create(Rating rating);
	
	// get all ratings
	List<Rating> getAllRatings();
	
	// get all by UserId
	List<Rating> getRatingByUserId(int userId);
	
	// get all by hotelId
	List<Rating> getRatingByHotelId(String HotelId);
	
}
