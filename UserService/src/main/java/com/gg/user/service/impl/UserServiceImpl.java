package com.gg.user.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gg.user.service.entity.Hotel;
import com.gg.user.service.entity.Rating;
import com.gg.user.service.entity.User;
import com.gg.user.service.exception.ResourceNotFoundException;
import com.gg.user.service.external.service.HotelService;
import com.gg.user.service.repository.UserRepository;
import com.gg.user.service.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User SaveUser(User user) {
//		String stringId = UUID.randomUUID().toString();
//		int int1 = Integer.parseInt(stringId);
//		user.setUserId(int1);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUser(int userId) {
		// get user from database with the help of user repository
		User user = userRepository.findById(userId).orElseThrow(
				() -> new ResourceNotFoundException("User with given id is not found on server !! : " + userId));
		// fetch rating of the above user from RATING SERVICE
		// localhost:8083/rating/users/3

//		ArrayList<Rating> forObject = restTemplate.getForObject("http://192.168.10.186:8083/rating/users/20", ArrayList.class);
		Rating[] ratingsOfUser = restTemplate
				.getForObject("http://RATINGSERVICE/rating/users/" + user.getUserId(), Rating[].class);
		//logger.info("{} ", ratingsOfUser);

		List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
		List<Rating> ratingList = ratings.stream().map(rating -> {
			// api call to hotel service to get the hotel
			// localhost:8082/hotels/9b98690a-7fc9-46c1-ae5d-76c09cab9f7d
			// calling using restTemplate
//			ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTELSERVICES/hotels/" + rating.getHotelId(),
//					Hotel.class);
//			Hotel hotel = forEntity.getBody();
//			logger.info("response status code : {} ", forEntity.getStatusCode());
			
			// calling using FeignClient
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
			

			// set the hotel to rating
			rating.setHotel(hotel);
			
			// return the rating
			return rating;
		}).collect(Collectors.toList());

		user.setRatings(ratingList);

		return user;
	}

}
