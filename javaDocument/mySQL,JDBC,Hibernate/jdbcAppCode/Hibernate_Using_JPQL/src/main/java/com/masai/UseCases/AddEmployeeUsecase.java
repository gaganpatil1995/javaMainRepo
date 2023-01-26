package com.masai.UseCases;

import javax.persistence.EntityManager;

import com.masai.Dao.EmployeeDaoImpl;
import com.masai.EMUtil.EMUtil;
import com.masai.bean.Employee;

public class AddEmployeeUsecase {

	public static void main(String[] args) {
		EmployeeDaoImpl empDao = new EmployeeDaoImpl() ;
		
		Employee emp1 = new Employee() ;
		emp1.setName("roshni");
		emp1.setAddress("matamander");
		emp1.setSalary(23000);
		Employee emp2 = new Employee() ;
		emp2.setName("sadna");
		emp2.setAddress("gujarkhedi");
		emp2.setSalary(23000);
		Employee emp3 = new Employee() ;
		emp3.setName("neeliam");
		emp3.setAddress("baunakhedi");
		emp3.setSalary(24000);
		Employee emp4 = new Employee() ;
		emp4.setName("sushila");
		emp4.setAddress("saliwada");
		emp4.setSalary(25000);
		
	EntityManager em =	EMUtil.provideEntityManger() ;
	em.getTransaction().begin();
	em.persist(emp1);
	em.persist(emp2);
	em.persist(emp3);
	em.persist(emp4);
	em.getTransaction().commit();
	em.close() ;
	System.out.println("Done") ;
	}
}
