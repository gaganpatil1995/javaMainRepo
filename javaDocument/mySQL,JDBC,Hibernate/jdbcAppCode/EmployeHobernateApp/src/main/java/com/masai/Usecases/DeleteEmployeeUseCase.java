package com.masai.Usecases;

import java.util.Scanner;

import com.masai.Dao.EmployeeDaoImpl;
import com.masai.Exception.EmployeeException;

public class DeleteEmployeeUseCase {

	public static void main(String[] args) {
		
		EmployeeDaoImpl empDao = new EmployeeDaoImpl() ;
		
		Scanner input = new Scanner(System.in) ;
		System.out.println("Please Enter Employee Id") ;
		int empid = input.nextInt() ;
		Integer empId = empid ;
		
		try {
			empDao.deleteEmployeeById(empId) ;
		}catch(EmployeeException em) {
			System.out.println(em.getMessage()) ;
		}
	}
}
