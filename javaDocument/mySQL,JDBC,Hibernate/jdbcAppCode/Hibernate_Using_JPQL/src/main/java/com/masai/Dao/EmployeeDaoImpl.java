package com.masai.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.masai.EMUtil.EMUtil;
import com.masai.bean.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	public List<Employee> getAllEmployee() {
	 EntityManager em =	EMUtil.provideEntityManger() ;
	 
	String jpql = "from Employee" ;
	Query q =em.createQuery(jpql) ;
	
	List<Employee> list = q.getResultList() ;
	
		return list;
	}

	public List<Employee> getEmployeeByAddress(String address) {
		EntityManager em = EMUtil.provideEntityManger() ;
		String jpql = "from Employee where address=:add" ;
		Query q = em.createQuery(jpql) ;
		q.setParameter("add", address) ;
		
		List<Employee> listEmployee = q.getResultList() ;
		
		return listEmployee;
	}

	public List<Employee> getAllEmployeeWithRangeSalary(int startSalary, int endSalary) {
		EntityManager em = EMUtil.provideEntityManger();
		String jpql = "from Employee where salary>=:start AND salary<=:end" ;
		Query q = em.createQuery(jpql) ;
	    q.setParameter("start", startSalary) ;
	    q.setParameter("end", endSalary) ;
		
		return q.getResultList();
	}

	public Object[] getEmployeeNameAndSalary(int empId) {
		EntityManager em = EMUtil.provideEntityManger() ;
		String jpql = "select name, salary from Employee where empId = : empid" ;
		TypedQuery<Object[]> tq = em.createQuery(jpql, Object[].class ) ;
		tq.setParameter("empid", empId) ;
		Object[] obj = tq.getSingleResult() ;
		
//		System.out.println(obj[0] );
//		System.out.println(obj[1]) ;
		
		return obj;
	}

	public int getEmployeeSalaryById(int empId) {
		EntityManager em = EMUtil.provideEntityManger() ;
		String jpql = "select salary from Employee where empId=:empid" ;
		Query q = em.createQuery(jpql) ;
		q.setParameter("empid", empId) ;
		 Integer salary =(Integer) q.getSingleResult() ;
		return salary;
	}

}
