package com.masai.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Dao.UserDao;
import com.masai.Dao.UserLoginSessionDao;
import com.masai.model.Post;
import com.masai.model.User;
import com.masai.model.UserLoginSession;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao ;
	
	@Autowired
	UserLoginSessionDao userLogin ;
	
	@Override
	public User registerNewUser(User user) {
		if(user.getUserId()!=null) {
			throw new RuntimeException("User Id should Not be present") ;
		}
		return userDao.save(user) ;
		
	}

	@Override
	public User updateUser(User user, String key) {
		Optional<UserLoginSession> opt = userLogin.findByUuid(key) ;
		
		if(opt.isEmpty()) {
			throw new RuntimeException("User need to Login first") ;
		}
		
		Optional<User> userOpt = userDao.findById(user.getUserId()) ;
		
		if(userOpt.isEmpty()) {
			throw new RuntimeException("No User is register with given id") ;
		}
		
		return userDao.save(user) ;
		
		
	}

	@Override
	public User delectUser(Integer userId, String key) {
     Optional<UserLoginSession> opt = userLogin.findByUuid(key) ;
		
		if(opt.isEmpty()) {
			throw new RuntimeException("User need to Login first") ;
		}
		
		Optional<User> userOpt = userDao.findById(userId) ;
		
		if(userOpt.isEmpty()) {
			throw new RuntimeException("No User is register with given id") ;
		}
		
		 userDao.delete(userOpt.get()) ;
		 User user2 = userOpt.get() ;
		 return user2 ;
	}

	@Override
	public Post addPostByUser(Post post, String key) {
    
		Optional<UserLoginSession> opt = userLogin.findByUuid(key) ;
		
		if(opt.isEmpty()) {
			throw new RuntimeException("User need to Login first") ;
		}
		UserLoginSession userSession1 = opt.get() ;
		
		Optional<User> userOpt = userDao.findById(userSession1.getUserId()) ;
		
		User user = userOpt.get() ;
		
		List<Post> posts = user.getPosts() ;
		
		posts.add(post) ;
		userDao.save(user) ;
		 
		 return post ;
	}

	@Override
	public Post deletePostByUser(Integer postId, String key) {
Optional<UserLoginSession> opt = userLogin.findByUuid(key) ;
		
		if(opt.isEmpty()) {
			throw new RuntimeException("User need to Login first") ;
		}
		UserLoginSession userSession1 = opt.get() ;
		
		Optional<User> userOpt = userDao.findById(userSession1.getUserId()) ;
		
		User user = userOpt.get() ;
		
	
		List<Post> posts = user.getPosts() ;
		int n = - 1 ;
		Post p = null;
		for(int i = 0 ;i< posts.size() ;i++) {
			if(posts.get(i).getPostId() == postId) {
				n = i ;
				p = posts.get(i) ;
			}
		}
		if(n==-1) {
			throw new RuntimeException("No post available for this post Id") ;
		}
		 
		 posts.remove(n) ;
		 user.setPosts(posts);
		 
		 return p ;
	}

	
}
