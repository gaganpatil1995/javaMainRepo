package com.masai.EMUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMUtil {

	static EntityManagerFactory emf ;
	
	static {
		emf = Persistence.createEntityManagerFactory("EmployeeUnit");
	}
	
	public static EntityManager provide() {
		return emf.createEntityManager() ;
	}
}
