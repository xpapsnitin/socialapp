package com.kindson.social.post;

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
import com.kindson.social.user.Users;

//@RestController
@Controller
public class PostController {

	private List<Post> preparePosts() {

		Users user1 = new Users("u1", "Jany Lawrence", new Location("l1", "Lagos"), "Jany@gmail.com");

		Users user2 = new Users("u2", "Jadon Mills", new Location("l2", "Asaba"), "Jadon@gmail.com");

		Post post1 = new Post("p1", "01-Jan-19", user1, "Its good to love and be loved");

		Post post2 = new Post("p2", "02-Jan-19", user2, "We all need someone");

		return Arrays.asList(post1, post2);

	}

	@Autowired
	private PostService postService;

	/*
	 * @RequestMapping(value = "/posts") public List<Post> getAllPosts() {
	 * 
	 * // return preparePosts();
	 * 
	 * return postService.getAllPosts(); }
	 */

	@RequestMapping(value = "/posts")
	public String getAllPosts(Model model) {
		//return postService.getAllPosts();
		model.addAttribute("posts",postService.getAllPosts());
		return "posts";
	}

	@RequestMapping(value = "/posts/{id}")
	public Optional<Post> getPost(@PathVariable String id) {
		return postService.getPost(id);
	}

	@RequestMapping(value = "/posts", method = RequestMethod.POST)
	public void addPost(@RequestBody Post post) {
		postService.addPost(post);
	}

	@RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
	public void deletePost(@PathVariable String id) {
		postService.deletePost(id);
	}

	@RequestMapping(value = "/posts/{id}", method = RequestMethod.PUT)
	public void updatePost(@PathVariable String id, @RequestBody Post post) {

		postService.updatePost(id, post);

	}

	// get post details by post id:http://localhost:8080/posts/name/100
	@RequestMapping(value = "/posts/name/{id}")
	public Optional<String> getPostDetailsById(@PathVariable String id) {
		return postService.getPostDetailsById(id);
	}
}
