package com.masai.UseCases;

import com.masai.Dao.EmployeeDaoImpl;

public class GetEmployeeNameSalary {

	public static void main(String[] args) {
		EmployeeDaoImpl empDao = new EmployeeDaoImpl() ;
		
		Object[] ob = empDao.getEmployeeNameAndSalary(5);
		
		System.out.println("Employe name is "+ ob[0]) ;
		System.out.println("Employee Salary is" + ob[1]) ;
	}
}
