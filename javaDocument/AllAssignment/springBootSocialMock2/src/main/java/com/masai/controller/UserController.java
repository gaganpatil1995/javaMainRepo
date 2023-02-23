package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Post;
import com.masai.model.User;
import com.masai.services.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userSer ;
	
	@PostMapping("/user")
	public ResponseEntity<User> registerUserController( @RequestBody User user){
		
		User user1= userSer.registerNewUser(user) ;
		
		return new ResponseEntity<User>(user1 ,HttpStatus.ACCEPTED) ;
	}
	
	@PutMapping("/user/{key}")
	public ResponseEntity<User> UpdateUserController( @RequestBody User user, @PathVariable String key){
		
		User user1= userSer.updateUser(user, key);
		
		return new ResponseEntity<User>(user1 ,HttpStatus.ACCEPTED) ;
	}
	
	@DeleteMapping("/user/{userId}/{key}")
	public ResponseEntity<User> UpdateUserController( @PathVariable Integer userId, @PathVariable String key){
		
		User user1= userSer.delectUser(userId, key);
		
		return new ResponseEntity<User>(user1 ,HttpStatus.ACCEPTED) ;
	}
	
	@PostMapping("/userpost/{key}")
	public ResponseEntity<Post> addPostUserController( @RequestBody Post post , @PathVariable String key){
		
		Post post1= userSer.addPostByUser(post, key) ;
		
		return new ResponseEntity<Post>(post1 ,HttpStatus.ACCEPTED) ;
	}
	
	@DeleteMapping("/user/{postId}/{key}")
	public ResponseEntity<Post> deletePostUserController( @PathVariable Integer postId, @PathVariable String key){
		
		Post post = userSer.deletePostByUser(postId, key) ;
		
		return new ResponseEntity<Post>(post ,HttpStatus.ACCEPTED) ;
	}
}
