package com.masai.UseCase;

import javax.persistence.EntityManager;

import com.masai.EMUtil.EMUtil;
import com.masai.EmployeeDao.EmployeeDaoImpl;
import com.masai.bean.Address;
import com.masai.bean.Employee;

public class AddEmployeeUseCase {
    static EmployeeDaoImpl empDao = new EmployeeDaoImpl() ;
	
	public static void main(String[] args) {
		EntityManager em = EMUtil.provideEntityManager() ;
		
		Employee emp = new Employee() ;
		
		emp.setName("pawan");
		emp.setSalary(30000);
		
		
	   emp.getAddress().add(new Address("Maharastra","Nagpur","441107")) ;
	   emp.getAddress().add(new Address("Madhya pradesh","Chindwara","221109")) ;
	
	em.getTransaction().begin();
	em.persist(emp);
	em.getTransaction().commit();
//	   empDao.addEmployeeWithAddress(emp);
	em.close();
	}
}
