package com.masai.Dao;

import java.util.List;

import com.masai.Exception.EmployeException;
import com.masai.bean.Employee;

public interface EmployeeDao {

	public boolean saveEmployee(Employee emp);
	public List getAllEmployee();
	public Employee getEmployeeById(int empId)throws EmployeException ;
	public String deleteEmployeeById(int empId)throws EmployeException ;

}
