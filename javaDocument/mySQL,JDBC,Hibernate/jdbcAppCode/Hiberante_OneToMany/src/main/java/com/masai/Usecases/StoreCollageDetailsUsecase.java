package com.masai.Usecases;

import javax.persistence.EntityManager;

import com.masai.EMUtil.EMUtil;
import com.masai.bean.Collage;
import com.masai.bean.Student;

public class StoreCollageDetailsUsecase {

	public static void main(String[] args) {
		EntityManager em = EMUtil.provideEntityManger() ;
		
		Student st1 = new Student() ;
		st1.setStudentName("Yas") ;
		st1.setMobileNumber("70977");
		st1.setEmail("yash@199");
		
		Student st2 = new Student() ;
		st2.setStudentName("sholu") ;
		st2.setMobileNumber("235252");
		st2.setEmail("gag@1455");
		
		Student st3 = new Student() ;
		st3.setStudentName("baablu") ;
		st3.setMobileNumber("12233");
		st3.setEmail("bablu@199");
		
		Student st4 = new Student() ;
		st4.setStudentName("papu") ;
		st4.setMobileNumber("733447");
		st4.setEmail("papau@199");
		
		Collage clg1 = new Collage() ;
		clg1.setCollageAddress("Parsevni");
		clg1.setCollageName("panduranga");
		clg1.getStudentList().add(st1);
		clg1.getStudentList().add(st2);
		clg1.getStudentList().add(st3);
		clg1.getStudentList().add(st4);
		
		st1.setCollage(clg1);
		st2.setCollage(clg1);
		st3.setCollage(clg1);
		st4.setCollage(clg1);
		
		Student st21 = new Student() ;
		st21.setStudentName("Yashwant") ;
		st21.setMobileNumber("70977");
		st21.setEmail("Yashwan@199");
		
		Student st22 = new Student() ;
		st22.setStudentName("shabnam") ;
		st22.setMobileNumber("235252");
		st22.setEmail("shabnam@1455");
		
		Student st23 = new Student() ;
		st23.setStudentName("rammu") ;
		st23.setMobileNumber("12233");
		st23.setEmail("rammu@199");
		
		Student st24 = new Student() ;
		st24.setStudentName("laxman") ;
		st24.setMobileNumber("733447");
		st24.setEmail("laxman@199");
		
		Collage clg21 = new Collage() ;
		clg21.setCollageAddress("Nagpur");
		clg21.setCollageName("drBabasahedAmbedkar");
		clg21.getStudentList().add(st21);
		clg21.getStudentList().add(st22);
		clg21.getStudentList().add(st23);
		clg21.getStudentList().add(st24);
		
		st21.setCollage(clg21);
		st22.setCollage(clg21);
		st23.setCollage(clg21);
		st24.setCollage(clg21);
		
		em.getTransaction().begin(); 
		em.persist(clg1);
		em.persist(clg21);
		em.getTransaction().commit();
		em.close();
		System.out.println("Done");
	}

	
	

	
}
