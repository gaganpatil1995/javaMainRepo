package com.masai.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Dao.UserDao;
import com.masai.Dao.UserLoginSessionDao;
import com.masai.model.User;
import com.masai.model.UserDTO;
import com.masai.model.UserLoginSession;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	UserLoginSessionDao usersession ;
	
	@Autowired
	UserDao userDao ;
	
	@Override
	public UserLoginSession userLogin(UserDTO userDto) {
		
		Optional<User> opt = userDao.findByMobile(userDto.getMobile()) ;
		
		if(opt.isEmpty()) {
			throw new RuntimeException(" user is not registerd") ;
		}
		
		User user = opt.get() ;
		
		if(userDto.getPassword().equals(user.getPassword())) {
			
			UserLoginSession userlogin1 = new UserLoginSession() ;
			
			userlogin1.setUserId(user.getUserId());
			
			userlogin1.setLocalDateTime(LocalDateTime.now());
			String key = RandomString.make(6);
			userlogin1.setUuid(key);
			
			return usersession.save(userlogin1) ;
			
			
		}
		else {
			throw new RuntimeException(" Please Enter Correct password") ;
			
		}
		
		
	}

	@Override
	public String userLogout(String key) {
		
		Optional<UserLoginSession> opt = usersession.findByUuid(key) ;
		
		if(opt.isEmpty()) {
			throw new RuntimeException("User Need to login first") ;
		}
		
		UserLoginSession userLoginSession = opt.get() ;
		
		usersession.delete(userLoginSession);
		
		return "User LogOut Successfully";
	}

	
}
