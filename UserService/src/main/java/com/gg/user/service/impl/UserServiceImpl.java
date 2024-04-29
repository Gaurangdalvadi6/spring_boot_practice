package com.gg.user.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gg.user.service.entity.User;
import com.gg.user.service.exception.ResourceNotFoundException;
import com.gg.user.service.repository.UserRepository;
import com.gg.user.service.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userRepository;

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
		return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server !! : "+userId));
	}

}
