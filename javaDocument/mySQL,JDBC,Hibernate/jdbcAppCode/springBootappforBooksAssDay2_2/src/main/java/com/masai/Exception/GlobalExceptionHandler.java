package com.masai.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

     @ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<MyErrorDetails> BooknotfoundExceptionHandler(BookNotFoundException be,WebRequest req){
		MyErrorDetails er = new MyErrorDetails() ;
		er.setDate(LocalDateTime.now());
		er.setMessage(be.getMessage());
		er.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(er,HttpStatus.BAD_REQUEST) ;
		
	}
}
