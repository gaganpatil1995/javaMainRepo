package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.UserDTO;
import com.masai.model.UserLoginSession;
import com.masai.services.LoginService;

@RestController
public class LoginController {

	@Autowired
	LoginService loginSer ;
	
	@PostMapping("/login")
	public ResponseEntity<UserLoginSession> userLogincontroller(@RequestBody UserDTO userDto){
		
		UserLoginSession userLogin = loginSer.userLogin(userDto) ;
		
		return new ResponseEntity<UserLoginSession>(userLogin , HttpStatus.CREATED) ;
	}
	
	@DeleteMapping("/login/{key}")
	public ResponseEntity<String> userLogoutController( @PathVariable String key){
		String string = loginSer.userLogout(key) ;
		
		return new ResponseEntity<String>(string ,HttpStatus.GONE);
	}
	
}
