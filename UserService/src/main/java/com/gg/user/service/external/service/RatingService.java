package com.gg.user.service.external.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.gg.user.service.entity.Rating;

@FeignClient(name = "RATINGSERVICE")
public interface RatingService {

	// get
	
	// post
	@PostMapping("/rating")
	ResponseEntity<Rating> createRating(Rating values);
	// put
	@PutMapping("/rating/{ratingId}")
	ResponseEntity<Rating> updateRating(@PathVariable("ratingId") String ratingId,Rating values);
	
	// delete
	@DeleteMapping("/rating/{ratingId}")
	void deleteRating(@PathVariable String ratingId);
}
