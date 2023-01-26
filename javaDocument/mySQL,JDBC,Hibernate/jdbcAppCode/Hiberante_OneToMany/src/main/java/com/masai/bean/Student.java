package com.masai.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Student {
     
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer studentRoll ;
	private String studentName ;
	private String mobileNumber ;
	private String email ;
	

	@ManyToOne(cascade = CascadeType.ALL)
	private Collage collage ;


	@Override
	public String toString() {
		return "Student [studentRoll=" + studentRoll + ", studentName=" + studentName + ", mobileNumber=" + mobileNumber
				+ ", email=" + email + "]";
	}
	
}
