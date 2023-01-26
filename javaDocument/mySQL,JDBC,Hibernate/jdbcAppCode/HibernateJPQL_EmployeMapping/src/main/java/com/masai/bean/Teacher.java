package com.masai.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer teacherId ;
	private String teacherName ;
	private Integer noYearOfExperience ;
	private String email ;
	@OneToMany(cascade = CascadeType.ALL)
	List<Course> courses = new ArrayList<>() ;
}
