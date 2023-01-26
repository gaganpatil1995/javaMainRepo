package com.gagan.EMUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMUtil {

	static private EntityManagerFactory emf ;
	static {
		emf = Persistence.createEntityManagerFactory("AccountUnit");
		
	}
	public static EntityManager provideEntityManager() {
		
		EntityManager em = emf.createEntityManager();
		return em ;
	}
}
