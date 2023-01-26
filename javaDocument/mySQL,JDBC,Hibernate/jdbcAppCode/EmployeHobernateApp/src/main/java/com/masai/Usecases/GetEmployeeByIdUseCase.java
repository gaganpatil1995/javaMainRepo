package com.masai.Usecases;

import java.util.Scanner;

import com.masai.Dao.EmployeeDaoImpl;
import com.masai.Exception.EmployeeException;
import com.masai.bean.Employee;

public class GetEmployeeByIdUseCase {

	public static void main(String[] args) {
		EmployeeDaoImpl emplDao = new EmployeeDaoImpl() ;
		Scanner input = new Scanner(System.in) ;
		System.out.println("Enter employee id which you want to fing") ;
		
		int empId = input.nextInt() ;
		Integer empid = empId ;
		
		try {
			Employee employee = emplDao.getEmployeeById(empid) ;
			System.out.println(employee) ;
		}catch(EmployeeException em) {
			System.out.println(em.getMessage()) ;
		}
		
	}
}
