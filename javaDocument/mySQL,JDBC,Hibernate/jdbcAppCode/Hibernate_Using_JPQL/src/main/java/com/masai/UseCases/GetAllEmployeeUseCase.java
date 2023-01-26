package com.masai.UseCases;

import java.util.List;

import com.masai.Dao.EmployeeDaoImpl;
import com.masai.bean.Employee;

public class GetAllEmployeeUseCase {

	public static void main(String[] args) {
		
		EmployeeDaoImpl empDao = new EmployeeDaoImpl() ;
		
		List<Employee> empList = empDao.getAllEmployee() ;
		
		for(Employee em:empList) {
			System.out.println(em) ;
		}
	}
}
