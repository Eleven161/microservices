package com.example.UserService.services;

import java.util.List;

import com.example.UserService.entities.User;

public interface UserServices {
	
	User saveUser(User user);
	List<User> getAllUser();
	User getUser(String userId);
	

}
