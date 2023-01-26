package com.masai.Dao;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.masai.Exception.EmployeException;
import com.masai.bean.Employee;

@Component
public class PresentationBean {

	@Autowired
	EmployeeDaoImpl empDao ;
	
	public void insertEmployee() {
		Scanner input = new Scanner(System.in) ;
		System.out.println("Please Enter Employee name") ;
		String name = input.nextLine() ;
		System.out.println("Please Enter Employee address") ;
		String add =  input.nextLine() ;
		
		System.out.println("Please Enter Employee Salary");
		int salary = input.nextInt() ;
		
		Employee em = new Employee() ;
		em.setEmpName(name);
		em.setAddress(add);
		em.setSalary(salary);
		
		empDao.saveEmployee(em);
	}
	
	public void printAllEmployee() {
		List<Employee>  empList =empDao.getAllEmployee() ;
		
		for(Employee emp : empList) {
			System.out.println(emp);
		}
	}
	
	public void deleteEmployee(){
	   Scanner input = new Scanner(System.in) ;
	   System.out.println("Please Enter Employee Id for Delete Information");
	    int id = input.nextInt() ;
	    try {
			empDao.deleteEmployeeById(id) ;
			System.out.println("Employee Information is Deleted") ;
		} catch (EmployeException e) {
			System.out.println(e.getMessage()) ;
		}
		}
	
}
