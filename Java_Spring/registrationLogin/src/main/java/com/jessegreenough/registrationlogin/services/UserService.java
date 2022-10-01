package com.jessegreenough.registrationlogin.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jessegreenough.registrationlogin.models.User;
import com.jessegreenough.registrationlogin.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	public User getUserInfo(Long id) {
		Optional<User> thisUser = userRepo.findById(id);
		if (thisUser.isPresent()) {
			return thisUser.get();
		}
		return null;
	}
	public User getUserByEmail(String email) {
		Optional<User> thisUser = userRepo.findByEmail(email);
		if (thisUser.isPresent()) {
			return thisUser.get();
		}
		return null;
	}
	
	public User save(User u) {
		return userRepo.save(u);
	}
	
	public void deleteUser(Long id) {
		userRepo.deleteById(id);
	}

}
