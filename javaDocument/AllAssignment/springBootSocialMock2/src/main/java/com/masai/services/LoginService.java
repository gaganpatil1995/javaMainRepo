package com.masai.services;

import org.springframework.stereotype.Service;

import com.masai.model.UserDTO;
import com.masai.model.UserLoginSession;

@Service
public interface LoginService {

	public UserLoginSession userLogin(UserDTO userDto) ;
	
	public String userLogout(String key);
 }
