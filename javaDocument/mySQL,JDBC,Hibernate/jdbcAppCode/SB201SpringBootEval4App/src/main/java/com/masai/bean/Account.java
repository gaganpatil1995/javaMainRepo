package com.masai.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer accountNo ;
	@NotNull
	@Size(min=3 ,max= 15 , message = "Minimum length shoud be 3 and maximium length should be  15")
	private String accountHolderName ;
	
	@Size(min= 10 , max= 30 , message = "Minimum length shoud be 10 and maximium length should be  30")
	private String address ;
	@Email(message =  "Please Enter Valid Email Address")
	@NotNull
	private String email ;
	@NotNull
	private Integer balance ;
	private String mobile ;
}
