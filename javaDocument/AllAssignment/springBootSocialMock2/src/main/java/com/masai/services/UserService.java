package com.masai.services;

import org.springframework.stereotype.Service;

import com.masai.model.Post;
import com.masai.model.User;

@Service
public interface UserService {

	
	public User registerNewUser(User user) ;
	
	public User updateUser(User user , String key) ;
	
	public User delectUser(Integer userId , String key) ;
	
	public Post addPostByUser(Post post , String key) ;
	
	public Post deletePostByUser(Integer postId , String key) ;
}
