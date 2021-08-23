package com.kindson.social.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<Users> getAllUsers() {
		List<Users> users = new ArrayList<>();

		userRepository.findAll().forEach(users::add);

		return users;
	}

	public List<Users> getUsersByLocation(String id) {
		List<Users> users = new ArrayList<>();

		userRepository.findByLocationId(id).forEach(users::add);

		return users;
	}

	public Optional<Users> getUser(String id) {
		return userRepository.findById(id);
	}

	public void addUser(Users user) {
		userRepository.save(user);
	}

	public void updateUser(String id, Users user) {
		userRepository.save(user);
	}

	public void deleteUser(String id) {
		userRepository.deleteById(id);
	}
}