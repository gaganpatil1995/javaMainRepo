package com.masai.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empId ;
	@NotNull
	@Size(min=3 ,max= 15 , message = "Minimum length shoud be 3 and maximium length should be  15")
	private String empName ;
	@Min(value =2000 , message = "Minimum Salary should be 2000")
	@NotNull( message = "Salary should not be null")
	private Integer salary ;
	@Size(min= 10 , max= 30 , message = "Minimum length shoud be 10 and maximium length should be  30")
	private String address ;
	
	@Email(message = "Email is not valid")
	private String email ;
//	@Pattern(regexp="[0-9]")
	private String mobile ;
	
}
