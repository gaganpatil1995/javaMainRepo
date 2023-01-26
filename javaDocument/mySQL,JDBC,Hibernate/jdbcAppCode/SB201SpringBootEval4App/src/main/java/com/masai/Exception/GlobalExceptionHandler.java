package com.masai.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import java.time.LocalDateTime ;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(AccountException.class)
	public ResponseEntity<MyErrorDetails> accountExceptionHandler(AccountException ee,WebRequest wr) {
		MyErrorDetails er = new MyErrorDetails() ;
		er.setDate(LocalDateTime.now() );
		er.setMessage(ee.getMessage());
		er.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(er,HttpStatus.NOT_FOUND) ;
	}

	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<MyErrorDetails> EmployeeExceptionHandler(EmployeeException ee,WebRequest wr) {
		MyErrorDetails er = new MyErrorDetails() ;
		er.setDate(LocalDateTime.now() );
		er.setMessage(ee.getMessage());
		er.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(er,HttpStatus.NOT_FOUND) ;
	}
	
	
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> exceptionHandler(Exception e,WebRequest wr){
		MyErrorDetails er = new MyErrorDetails() ;
		er.setDate(LocalDateTime.now() );
		er.setMessage(e.getMessage());
		er.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(er,HttpStatus.NOT_FOUND) ;
	}
}
