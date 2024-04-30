package com.gd.rating.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gd.rating.entities.Rating;
import com.gd.rating.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {

	@Autowired
	private RatingService ratingService;

	// create
	@PostMapping()
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
	}

	// get all ratings
	@GetMapping()
	public ResponseEntity<List<Rating>> getRating() {
		return ResponseEntity.ok(ratingService.getAllRatings());
	}

	// get rating by userId
	@GetMapping("/users/{UserId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable int UserId) {
		return ResponseEntity.of(Optional.of(ratingService.getRatingByUserId(UserId)));
	}

	// get rating by hotelId
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId) {
		return ResponseEntity.of(Optional.of(ratingService.getRatingByHotelId(hotelId)));
	}
}
