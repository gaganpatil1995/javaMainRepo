package com.masai.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.masai.EMUtil.EMUtil;
import com.masai.Exception.EmployeException;
import com.masai.bean.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public boolean saveEmployee(Employee emp) {
		EntityManager em = EMUtil.provide() ;
	  boolean ans = false ;
	  
	  em.getTransaction().begin();
	  em.persist(emp);
	  ans = true ;
	  em.getTransaction().commit();
		em.close();
		return ans;
	}

	@Override
	public List getAllEmployee() {
		EntityManager em = EMUtil.provide() ;
		
		String jpql = "from Employee" ;
		Query q = em.createQuery(jpql) ;
		List<Employee> emp = q.getResultList() ;
		
		return emp;
	}

	@Override
	public Employee getEmployeeById(int empId) throws EmployeException {
		EntityManager em = EMUtil.provide() ;
		Employee emp = em.find(Employee.class, empId) ;
		
		if(emp ==null) {
			throw new EmployeException("Employee Not Found");
		}
		
		return emp;
	}

	@Override
	public String deleteEmployeeById(int empId) throws EmployeException {
		EntityManager em = EMUtil.provide() ;
		Employee emp = em.find(Employee.class, empId) ;
		
		if(emp == null) {
			throw new EmployeException("Employee is Not Found");
		}
		
		em.getTransaction().begin();
		  em.remove(emp);
		  
		  em.getTransaction().commit();
			em.close();
			return "Employee Deleted Successfully";
	}

}
