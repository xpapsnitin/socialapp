package com.kindson.social.user;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kindson.social.location.Location;

//@RestController
@Controller
public class UserController {

	private List<Users> prepareUsers() {
		Users user1 = new Users("u1", "Jany1 Lawrence", new Location("l1", "Lagos"), "Jany@gmail.com");

		Users user2 = new Users("u2", "Jadon1 Mills", new Location("l2", "Asaba"), "Jadon@gmail.com");

		return Arrays.asList(user1, user2);

	}

	@Autowired
	private UserService userService;
	
	/*
	 * @RequestMapping(value = "/users") public List<User> getAllUsers() { // return
	 * prepareUsers(); return userService.getAllUsers(); }
	 */
	
	@RequestMapping(value = "/users")
	public String getAllUsers(Model model) {

		model.addAttribute("users", userService.getAllUsers());
		return "users";
	}

	@RequestMapping(value = "/users/{id}")
	public Optional<Users> getUser(@PathVariable String id) {
		return userService.getUser(id);
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public void addUser(@RequestBody Users user) {
		userService.addUser(user);
	}
	
	 @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	 public void deleteUser(@PathVariable String id) {
	      userService.deleteUser(id);
	 }
	 
	 
}
