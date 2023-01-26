package com.masai.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.*;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Collage {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer collageId ;
	private String collageName ;
	private String collageAddress ;
	
	@OneToMany(cascade = CascadeType.ALL ,mappedBy = "collage")
	List<Student> studentList  = new ArrayList<>() ;
}
