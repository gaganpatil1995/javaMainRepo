package com.masai.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	private String name ;
	private String address ;
	private Integer salary ;
	
	
	
}
