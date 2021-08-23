package com.kindson.social.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.kindson.social.location.Location;

@Entity
public class Users {

	@Id
	private String id;
	private String name;

	@ManyToOne
	private Location location;

	private String email;

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(String id, String name, Location location, String email) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}