package com.masai.model;

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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId ;
	
	private String name ;
	private String age ;
	private String dateOfBirth ;
	private String occupation ;
	
	private String mobile ;
	
	private String password ;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<UserTrackDTO> following = new ArrayList<>();
//	
    @OneToMany(cascade = CascadeType.ALL)
	private List<UserTrackDTO> followers ;
//	
    @OneToMany(cascade = CascadeType.ALL)
	private List<UserTrackDTO> bockList ;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Post> posts = new ArrayList<>() ;
	
	
}
