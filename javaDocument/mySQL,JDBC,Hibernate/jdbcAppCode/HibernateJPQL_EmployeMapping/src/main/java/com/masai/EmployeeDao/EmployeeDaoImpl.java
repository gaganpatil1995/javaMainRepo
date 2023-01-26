package com.masai.EmployeeDao;

import javax.persistence.EntityManager;

import com.masai.EMUtil.EMUtil;
import com.masai.bean.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public void addEmployeeWithAddress(Employee emp) {
		EntityManager em = EMUtil.provideEntityManager() ;
		
		em.getTransaction().begin(); 
		em.persist(emp);
		em.getTransaction().commit();
		em.close();
	}

	
}
