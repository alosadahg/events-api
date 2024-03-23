package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.model.UserRepository;

@Service
public class UserService {

	@Autowired
    private UserRepository userRepo;
	
	public List<User> getAllUsers() {
		List<User> users = userRepo.findAll(); 
		return users;
	}

	public String add(User u) {
		if(u!=null) {
			if(userRepo.findByEmail(u.getEmail()).isEmpty()) {
				userRepo.save(u);
				return "User added successfully.";
			} else {
				return "User already exists.";
			}
		}
		return "Incomplete user data.";
	}

}
