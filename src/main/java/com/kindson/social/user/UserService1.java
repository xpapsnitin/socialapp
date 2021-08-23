package com.kindson.social.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kindson.social.location.Location;

@Service
public class UserService1 {

	Users user1 = new Users("u1", "Jany Lawrence", new Location("l1", "Lagos"), "Jany@gmail.com");

	Users user2 = new Users("u2", "Jadon Mills", new Location("l2", "Asaba"), "Jadon@gmail.com");

	// private List<User> users = Arrays.asList(user1, user2);

	private List<Users> users = new ArrayList<>(Arrays.asList(user1, user2));

	public List<Users> getAllUsers() {
		return users;
	}

	public Users getUser(String id) {
		Users user = users.stream().filter(t -> id.equals(t.getId())).findFirst().orElse(null);

		return user;
	}

	public void addUser(Users user) {
		users.add(user);
	}

	public void deleteUser(String id) {
		users.removeIf(u -> u.getId().equals(id));

	}

	public void updateUser(String id, Users user) {

		for (int i = 0; i < users.size(); i++) {

			Users u = users.get(i);

			if (u.getId().equals(id)) {

				users.set(i, user);

				return;
			}
		}

	}
}
