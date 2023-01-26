package com.masai.UseCases;

import com.masai.Dao.EmployeeDaoImpl;

public class getSalaryFromEmpId {

	public static void main(String[] args) {
		EmployeeDaoImpl empDao = new EmployeeDaoImpl() ;
		
		int salary = empDao.getEmployeeSalaryById(3) ;
		System.out.println(salary) ;
	}
}
