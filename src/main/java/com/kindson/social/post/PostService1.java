package com.kindson.social.post;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kindson.social.location.Location;
import com.kindson.social.user.Users;

@Service
public class PostService1 {

	Users user1 = new Users("u1", "Jany Lawrence", new Location("l1", "Lagos"), "Jany@gmail.com");

	Users user2 = new Users("u2", "Jadon Mills", new Location("l2", "Asaba"), "Jadon@gmail.com");

	Post post1 = new Post("p1", "01-Jan-19", user1, "Its good to love and be loved");

	Post post2 = new Post("p2", "02-Jan-19", user2, "We all need someone");

	// List<Post> posts = Arrays.asList(post1, post2);

	List<Post> posts = new ArrayList<>(Arrays.asList(post1, post2));

	public List<Post> getAllPosts() {

		return posts;
	}

	public Post getPost(String id) {
		Post post = posts.stream().filter(t -> id.equals(t.getId())).findFirst().orElse(null);

		return post;
	}

	public void addPost(Post post) {
		posts.add(post);

	}

	public void deletePost(String id) {
		posts.removeIf(p -> p.getId().equals(id));

	}

	public void updatePost(String id, Post post) {
		for (int i = 0; i < posts.size(); i++) {

			Post p = posts.get(i);

			if (p.equals(post)) {

				posts.set(i, post);
			}
		}

	}

}
