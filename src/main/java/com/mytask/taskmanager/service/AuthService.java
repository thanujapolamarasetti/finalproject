package com.mytask.taskmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mytask.taskmanager.model.User;
import com.mytask.taskmanager.repository.UserRepository;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;

	public User login(String username, String password) {
		System.out.println("USERNAME: " + username);
		System.out.println("PASSWORD: " + password);

		User user = userRepository.findByUsernameAndPassword(username, password);

		System.out.println("USER FROM DB: " + user);
		return user;
	}

	public User registerFarmer(String username, String password, String phoneNumber, String location) {

		System.out.println("Register attempt: " + username);

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setRole("FARMER");
		user.setPhoneNumber(phoneNumber);
		user.setLocation(location);

		User saved = userRepository.save(user);

		System.out.println("Saved ID: " + saved.getUserId());

		return saved;
	}

	public User getUserById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
	}

}
