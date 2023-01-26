package com.masai.UseCases;

import java.util.List;

import com.masai.Dao.EmployeeDaoImpl;
import com.masai.bean.Employee;

public class GetAllEmployeeWithRange {

	public static void main(String[] args) {
		EmployeeDaoImpl empDao = new EmployeeDaoImpl() ;
		
		List<Employee> list = empDao.getAllEmployeeWithRangeSalary(20000, 22000) ;
		
		for(Employee emp:list) {
			System.out.println(emp) ;
		}
	}
}
