package com.kindson.social.post;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends CrudRepository<Post, String> {

	public List<Post> findByUserId(String userId);
	
	@Query("SELECT p.details FROM Post p where p.id = :id")
	public Optional<String>  findPostDetailsByPostId(@Param("id")String id);
}
