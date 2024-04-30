package com.gd.hotel.services;

import java.util.List;

import com.gd.hotel.entities.Hotel;

public interface HotelService {

	// create
	Hotel create(Hotel hotel);
	
	// get all hotels
	List<Hotel> getAllHotel();
	
	// get hotel by id
	Hotel getHotelById(String id);
}
