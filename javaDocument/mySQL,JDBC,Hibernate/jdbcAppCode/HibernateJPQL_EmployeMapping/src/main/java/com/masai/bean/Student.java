package com.masai.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private Integer roll ;
	private String name ;
	private String email ;
	private String mobile ;
	
	@ManyToMany(cascade = CascadeType.ALL)
	List<Course> courseList = new ArrayList<>() ;

	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", email=" + email + ", mobile=" + mobile + "]";
	}
	
	
}
