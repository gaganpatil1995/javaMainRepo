package com.masai.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.Dao.EmployeeDao;
import com.masai.Exception.EmployeeException;
import com.masai.bean.Employee;
import com.masai.bean.EmployeeDTO;
import java.util.Optional ;


public class EmployeeSerivceImpl implements EmployeeService {

	@Autowired
	EmployeeDao empDao ;
	
	@Override
	public Employee registerEmployee(Employee emp) throws EmployeeException {
	
		if(emp.getEmpId() != null) {
			throw new  EmployeeException("Employee with Employee Id is not Allowed for Registring") ;
		}
		return empDao.save(emp) ;
	}

	@Override
	public Employee getEmployeeById(Integer empId) throws EmployeeException {
		Optional<Employee> op = empDao.findById(empId);
		if(op.isEmpty()) {
			throw new EmployeeException("Employee with id"+empId+" is not Found") ;
		}
		
		return op.get();
	}

	@Override
	public List<Employee> getAllEmployeeDetails() throws EmployeeException {
		
		return empDao.findAll();
	}

	@Override
	public Employee deleteEmployeeById(Integer empId) throws EmployeeException {
	  Optional<Employee> op = empDao.findById(empId) ;
	  if(op.isEmpty()) {
			throw new EmployeeException("Employee with id"+empId+" is not Found") ;
		}
	  Employee emp = op.get() ;
	  empDao.delete(emp );
		return emp ;
	}

	@Override
	public List<Employee> getEmployeeDetailsByAddress(String address) throws EmployeeException {
	 List<Employee> empList = empDao.findByAddress(address) ;
	 if(empList.size()>=0 )
		return empList;
	 throw new EmployeeException("No Employee found with given Address") ;
	}

	@Override
	public Employee updateEmployee(Employee emp) throws EmployeeException {
		Optional<Employee> op = empDao.findById(emp.getEmpId()) ;
		if(op.isEmpty())
			throw new EmployeeException("Employee is not Found with Id :"+emp.getEmpId());
//		Employee emp1 = op.get() ;
		
		return empDao.save(emp);
	}

	@Override
	public String[] getNameAndAddressOfEmplyeeById(Integer empId) throws EmployeeException {
		String detail = empDao.findNameAndAddresByempId(empId);
		if(detail.length()==0) {
			throw new EmployeeException("Employee is Not Found with given Details") ;
		}
		String[] ans = detail.trim().split(" ") ;
		return ans;
	}

	@Override
	public List<EmployeeDTO> getNameAddressSalaryOfAllEmployee() throws EmployeeException {
		List<EmployeeDTO> empDto = empDao.getAllEmployeeDTO() ;
		
		if(empDto.size() !=0) {
			return empDto ;
		}
		
		throw new EmployeeException("Employees are not Found") ;
	}

	
}
