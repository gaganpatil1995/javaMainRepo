package com.masai.Dao;

import com.masai.Exception.EmployeeException;
import com.masai.bean.Employee;

public interface EmployeeDao {

	public Employee registerEmployee(Employee employee) throws EmployeeException ;
	
	public Employee getEmployeeById(Integer empId) throws EmployeeException ;
	
	public Employee deleteEmployeeById(Integer empId)throws EmployeeException ;
	
	public Employee updateEmployee(Employee employee) throws EmployeeException ;
}
