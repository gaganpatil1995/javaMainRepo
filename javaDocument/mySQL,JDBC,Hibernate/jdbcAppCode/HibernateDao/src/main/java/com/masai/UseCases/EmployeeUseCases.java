package com.masai.UseCases;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.masai.EntityClass.Employee;
import com.masai.Util.EM_Util;

public class EmployeeUseCases {

	public static void main(String[] args) {
//		Scanner input = new Scanner(System.in) ;
//		System.out.println("Please enter employe ID"); ;
//		int emId = input.nextInt() ;
//		
//		EmployeeDaoImpl emDao = new EmployeeDaoImpl() ;
//		String address = emDao.getAddressOfEmploye(emId) ;
//		System.out.println(address);
		EntityManager em = EM_Util.provideEntityManager();
		String jpql = "from employee" ;
		Query q = em.createQuery(jpql) ;
		List<Employee> list = q.getResultList();
		
		for(Employee e : list) {
			System.out.println(e);
		}
	}
}
