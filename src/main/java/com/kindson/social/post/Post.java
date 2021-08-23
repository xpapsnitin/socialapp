package com.kindson.social.post;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.kindson.social.user.Users;


@Entity
public class Post {
	@Id
	private String id;
	private String postdate;

	@ManyToOne
	private Users user;
	private String details;

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(String id, String postdate, Users user, String details) {
		super();
		this.id = id;
		this.postdate = postdate;
		this.user = user;
		this.details = details;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPostdate() {
		return postdate;
	}

	public void setPostdate(String postdate) {
		this.postdate = postdate;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}