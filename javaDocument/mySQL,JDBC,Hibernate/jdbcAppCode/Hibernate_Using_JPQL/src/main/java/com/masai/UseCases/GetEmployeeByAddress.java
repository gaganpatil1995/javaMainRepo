package com.masai.UseCases;

import java.util.List;

import com.masai.Dao.EmployeeDaoImpl;
import com.masai.bean.Employee;

public class GetEmployeeByAddress {

	public static void main(String[] args) {
		EmployeeDaoImpl empDao = new EmployeeDaoImpl() ;
		
		List<Employee> list = empDao.getEmployeeByAddress("nagpur") ;
		
		for(Employee em :list) {
			System.out.println(em) ;
		}
	}
}
