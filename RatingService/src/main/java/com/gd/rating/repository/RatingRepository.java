package com.gd.rating.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gd.rating.entities.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, String>{

	List<Rating> findByHotelId(String hotelId);
	
	List<Rating> findByUserId(int userId);
}
