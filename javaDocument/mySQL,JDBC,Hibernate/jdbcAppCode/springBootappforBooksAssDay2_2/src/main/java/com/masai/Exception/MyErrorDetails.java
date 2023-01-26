package com.masai.Exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@AllArgsConstructor
@ToString
public class MyErrorDetails {

	private LocalDateTime date ;
	private String message ;
	private String details ;
	
	 
}
