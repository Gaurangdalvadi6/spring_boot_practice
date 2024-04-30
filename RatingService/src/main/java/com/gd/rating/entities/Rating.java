package com.gd.rating.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@NoArgsConstructor@AllArgsConstructor@Entity
public class Rating {

	@Id
	private String ratingId;
	private int userId;
	private String hotelId;
	private int rating;
	private String feedback;
}
