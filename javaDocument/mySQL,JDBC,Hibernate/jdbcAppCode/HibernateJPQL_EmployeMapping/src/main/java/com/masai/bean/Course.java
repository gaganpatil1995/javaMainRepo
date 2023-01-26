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
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Course {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer courseId ;
	private String courseName ;
	private String duration ;
	private Integer fee ;
	
	@ManyToMany(cascade = CascadeType.ALL)
	List<Student> students  = new ArrayList<>() ;
	
	@ManyToOne(cascade = CascadeType.ALL)
	Teacher teacher  ;
}
