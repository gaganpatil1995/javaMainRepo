package com.masai.Usecases;

import com.masai.Dao.EmployeeDaoImpl;
import com.masai.Exception.EmployeeException;
import com.masai.bean.Employee;

public class RegisterEmployeeUseCase {

	public static void main(String[] args) {
		EmployeeDaoImpl empDao = new EmployeeDaoImpl() ;
		
		Employee emp = new Employee() ;
		emp.setAddress("mumbai");
		emp.setName("nana");
		emp.setSalary(35000);
		
		try {
			empDao.registerEmployee(emp) ;
		}catch(EmployeeException e) {
			System.out.println(e.getMessage()) ;
		}
		
	}
}
