package com.example.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.model.user.User;
import com.example.api.model.user.UserRepository;

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
		return "Transaction failed";
	}

	public String login(User u) {
		List<User> user = userRepo.findByEmailAndPassword(u.getEmail(), u.getPassword());
		if(!user.isEmpty()) {
			return user.get(0).toString();
		} 
		return "Login failed";
	}

	public String getAUser(String email) {
		List<User> uList = userRepo.findByEmail(email);
		System.out.println(uList.isEmpty());
		if(!uList.isEmpty()) {
			return uList.get(0).toString();
		}
		return "User not found";
	} 

	public String updateUserType(String email, String status) {
		List<User> uList = userRepo.findByEmail(email);
		System.out.println(uList.isEmpty());
		if(!uList.isEmpty()) {
			User user = uList.get(0);
			user.setUser_type(status);
			userRepo.save(user);
			return user.toString();
		}
		return "User not found";
	}

	public String updateUser(User user) {
		User u = userRepo.findById(user.getUid()).get();
		if(u!=null) {
			u.setEmail(user.getEmail());
			u.setFirstname(user.getFirstname());
			u.setLastname(user.getLastname());
			u.setPassword(user.getPassword());
			userRepo.save(u);
			return u.toString();
		}
		return "No record found";
	}

}
