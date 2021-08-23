package com.kindson.social.user;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, String>{
	
	 public List<Users> findByLocationId(String locationId); 

}
