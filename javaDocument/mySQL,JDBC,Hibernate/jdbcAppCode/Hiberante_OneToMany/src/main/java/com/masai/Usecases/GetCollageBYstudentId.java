package com.masai.Usecases;

import javax.persistence.EntityManager;

import com.masai.EMUtil.EMUtil;
import com.masai.bean.Student;

public class GetCollageBYstudentId {

	public static void main(String[] args) {
		EntityManager em = EMUtil.provideEntityManger() ;
		
		Student s1 = em.find(Student.class, 2) ;
		
		System.out.println(s1.getCollage()) ;
	}
}
