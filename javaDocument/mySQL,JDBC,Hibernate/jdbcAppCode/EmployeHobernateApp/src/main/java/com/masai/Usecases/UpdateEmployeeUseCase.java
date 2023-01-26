package com.masai.Usecases;

import com.masai.Dao.EmployeeDaoImpl;
import com.masai.Exception.EmployeeException;
import com.masai.bean.Employee;

public class UpdateEmployeeUseCase {

	public static void main(String[] args) {
		
		EmployeeDaoImpl empDao = new EmployeeDaoImpl() ;
		
		Employee emp = new Employee(1,"rammu","Saoner",35000) ;
		
		try {
			System.out.println( empDao.updateEmployee(emp)) ;
		}catch(EmployeeException em ) {
			System.out.println(em.getMessage());
		}
	}
}
