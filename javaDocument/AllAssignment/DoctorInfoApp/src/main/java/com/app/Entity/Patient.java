package com.app.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Patient {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
	 private Integer patientId ;
     
     @Size(min=3)
	 private String patientName ;
     
     @Size(max=20)
	 private String city ;
	 
	 @Email
	 private String email ;
	  
	 @Size(min=10,max=11)
	 private String phoneNumber ;
	 
	 private String sympton ;
	 
}
