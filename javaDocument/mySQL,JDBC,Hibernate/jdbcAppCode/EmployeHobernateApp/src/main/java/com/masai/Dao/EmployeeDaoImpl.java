package com.masai.Dao;

import javax.persistence.EntityManager;

import com.masai.Exception.EmployeeException;
import com.masai.Util.EMUtil;
import com.masai.bean.Employee;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public Employee registerEmployee(Employee employee) throws EmployeeException {
		EntityManager em = EMUtil.provideEntityManager() ;
		
//		Employee empl  =  em.find(Employee.class, employee.getEmpId()) ;
		if(employee.getEmpId() !=null) {
			throw new EmployeeException("This Employeee is already Exist") ;
		}
		em.getTransaction().begin() ;
		em.persist(employee);
		em.getTransaction().commit();
		em.close();
		return employee;
	}

	@Override
	public Employee getEmployeeById(Integer empId) throws EmployeeException {
	   EntityManager em = EMUtil.provideEntityManager() ;
	   Employee emp = em.find(Employee.class, empId) ;
	   if(emp ==null) {
		   throw new EmployeeException("Employee Not Found") ;
	   }
	  
	   
		return emp;
	}

	@Override
	public Employee deleteEmployeeById(Integer empId) throws EmployeeException {
		 EntityManager em = EMUtil.provideEntityManager() ;
		   Employee emp = em.find(Employee.class, empId) ;
		   if(emp == null) {
			   throw new EmployeeException("Employee Not Found") ;
		   }
		   em.getTransaction().begin() ;
		   em.remove(emp);
		   em.getTransaction().commit();
		  em.close();
		   
			return emp;
	}

	@Override
	public Employee updateEmployee(Employee employee) throws EmployeeException {
		 EntityManager em = EMUtil.provideEntityManager() ;
		   Employee emp = em.find(Employee.class, employee.getEmpId()) ;
		   if(emp == null) {
			   throw new EmployeeException("Employee Not Found") ;
		   }
		   em.getTransaction().begin() ;
		   em.merge(employee);
		   em.getTransaction().commit();
		  em.close();
		   
			return emp;
	}

}
