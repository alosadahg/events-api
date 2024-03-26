package com.example.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.model.user.User;
import com.example.api.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping(path = "/user")
@CrossOrigin
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/view-all")
	public List<User> getUsers() {
		return userService.getAllUsers();
	}

    @PostMapping("/add")
    public String addUser(User newuser) {
        return userService.add(newuser);
    }

    @PostMapping("/login")
    public String loginUser(User user) {
        return userService.login(user);
    }

    @PostMapping("/view") 
    public String getUser(String email) {
        return userService.getAUser(email);
    }

    @PostMapping("/view-by-id") 
    public String getUser(int userid) {
        return userService.getAUserById(userid);
    }

    @PutMapping("/update-status")
    public String updateUserType(String email, String status) {
        return userService.updateUserType(email, status);
    }

    @PutMapping("/update-user-info")
    public int updateUserInfo(User user) {
        return userService.updateUser(user);
    }
}
