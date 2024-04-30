package com.gd.rating.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.rating.entities.Rating;
import com.gd.rating.repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService{

	@Autowired
	RatingRepository repository;
	
	@Override
	public Rating create(Rating rating) {
		String rId = UUID.randomUUID().toString();
		rating.setRatingId(rId);
		return repository.save(rating);
	}

	@Override
	public List<Rating> getAllRatings() {
		return repository.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(int userId) {
		return repository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		return repository.findByHotelId(hotelId);
	}

}
