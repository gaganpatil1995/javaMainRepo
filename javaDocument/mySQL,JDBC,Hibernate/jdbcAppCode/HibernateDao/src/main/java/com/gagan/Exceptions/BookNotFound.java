package com.gagan.Exceptions;

public class BookNotFound extends RuntimeException {

	public BookNotFound(String message){
		super(message);
	}
}
