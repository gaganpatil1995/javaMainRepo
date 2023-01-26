package com.masai.Usecases;

import java.util.List;

import javax.persistence.EntityManager;

import com.masai.EMUtil.EMUtil;
import com.masai.bean.Collage;
import com.masai.bean.Student;

public class GetAllStudentByCollageId {

	public static void main(String[] args) {
		EntityManager em  = EMUtil.provideEntityManger() ;
		Collage college = em.find(Collage.class, 1) ;
		
	List<Student> studentList =	college.getStudentList() ;
	
	for(Student st:studentList) {
		System.out.println(st) ;
	}
		
		
		
	}
}
