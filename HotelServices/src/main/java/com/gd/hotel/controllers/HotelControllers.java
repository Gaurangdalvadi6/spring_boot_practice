package com.gd.hotel.controllers;

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

import com.gd.hotel.entities.Hotel;
import com.gd.hotel.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelControllers {

	@Autowired
	HotelService hotelService;
	
	// create
	@PostMapping({"","/"})
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
	}
	
	// get all hotels
	@GetMapping({"","/"})
	public ResponseEntity<List<Hotel>> getAllHotel(){
		return ResponseEntity.of(Optional.of(hotelService.getAllHotel()));
	}
	
	// get single hotel
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getHotel(@PathVariable("hotelId") String hotelId){
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.getHotelById(hotelId));
	}
}
