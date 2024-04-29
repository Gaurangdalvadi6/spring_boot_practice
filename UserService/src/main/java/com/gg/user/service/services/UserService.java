package com.gg.user.service.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gg.user.service.entity.User;

@Service
public interface UserService {

	// create
	User SaveUser(User user);

	// get all User
	List<User> getAllUser();

	// get user by id
	User getUser(int id);

//	// update user
//	void updateUser(int id);
//
//	// delete user
//	void deleteByUser(int id);
}
