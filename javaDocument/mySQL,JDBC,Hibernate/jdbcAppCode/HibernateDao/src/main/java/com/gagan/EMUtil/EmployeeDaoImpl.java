package com.gagan.EMUtil;

import javax.persistence.EntityManager;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public void save(Employee emp) {
		EntityManager em = EMUtil.provideEntityManager();
		
		em.getTransaction().begin();
		em.persist(emp);
		em.getTransaction().commit();
		
		em.close();
		
		
	}

	@Override
	public String getAddressOfEmployee(Integer empId) {
		EntityManager em = EMUtil.provideEntityManager() ;
		Employee emp = em.find(Employee.class, empId) ;
		if(emp==null) {
			return "Employee not found" ;
		}
		em.close();
		return emp.getAddress() ;
		
	}

	@Override
	public String giveBonusToEmployee(Integer empId, Integer bonus) {
		EntityManager em = EMUtil.provideEntityManager() ;
		Employee emp = em.find(Employee.class, empId) ;
		if(emp==null) {
			return "Employee not found" ;
		}
		em.getTransaction().begin();
		emp.setSalary(emp.getSalary()+bonus);
		em.getTransaction().commit();
		em.close() ;
		return "Bonus given to Employee" ;
	}

	@Override
	public boolean deleteEmployee(Integer empId) {
		EntityManager em = EMUtil.provideEntityManager() ;
		Employee emp = em.find(Employee.class , empId) ;
		if(emp==null ) {
			return false ;
			
		}
		em.getTransaction().begin() ;
		em.remove(emp);
		em.getTransaction().commit();
		em.close() ;
		return true;
	}

}
