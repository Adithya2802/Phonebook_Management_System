package com.phone.book.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phone.book.entity.User;
import com.phone.book.payload.LoginDto;
import com.phone.book.payload.SignUpDto;
import com.phone.book.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public String login(@RequestBody LoginDto loginDto){
    	Optional<User> user = userRepository.findByUsernameAndPassword(loginDto.getUsernameOrEmail()
    			,loginDto.getPassword());
    	if (user.isPresent()) {
    		return "User logged in successfully";
		} else {
			return "User login failed";
		}
    	
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody SignUpDto signUpDto){

        // create user object
        User user = new User();
        user.setName(signUpDto.getName());
        user.setUsername(signUpDto.getUsername());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(signUpDto.getPassword());

        userRepository.save(user);

        return "User registered successfully";

    }
}
