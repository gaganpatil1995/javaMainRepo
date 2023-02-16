package com.app.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(PatientException.class)
	public ResponseEntity<MyErrorDetail> patientExceptionHandler(PatientException pExp , WebRequest req){
		
		MyErrorDetail err = new MyErrorDetail(LocalDateTime.now() ,pExp.getMessage(),req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(err , HttpStatus.NOT_FOUND);
	
	}
	
	@ExceptionHandler(DoctorException.class)
	public ResponseEntity<MyErrorDetail> doctorExceptionHandler(DoctorException dexp , WebRequest req){
		MyErrorDetail err = new MyErrorDetail(LocalDateTime.now() , dexp.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(err , HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetail> validationExceptionHandler(MethodArgumentNotValidException me ){
		MyErrorDetail err = new MyErrorDetail(LocalDateTime.now() ,"Validation Error" , me.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<>(err , HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetail> mainExceptionHandler(Exception exp , WebRequest req){
		
		MyErrorDetail err = new MyErrorDetail(LocalDateTime.now() , exp.getMessage() , req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(err , HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetail> myNotFoundHandler(NoHandlerFoundException ne , WebRequest req){
		
		MyErrorDetail err = new MyErrorDetail(LocalDateTime.now() ,ne.getMessage() , req.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.BAD_GATEWAY);
	}
	
	

}
