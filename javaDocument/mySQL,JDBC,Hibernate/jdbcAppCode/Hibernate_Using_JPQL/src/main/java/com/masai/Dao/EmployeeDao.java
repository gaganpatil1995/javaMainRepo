package com.masai.Dao;

import java.util.List;

import com.masai.bean.Employee;

public interface EmployeeDao {

	public List<Employee> getAllEmployee() ;
	
	public List<Employee> getEmployeeByAddress(String address) ;
	
	public List<Employee> getAllEmployeeWithRangeSalary(int startSalary,int endSalary) ;
	
	public Object[] getEmployeeNameAndSalary(int empId) ;
	
	public int getEmployeeSalaryById(int empId) ;
}
