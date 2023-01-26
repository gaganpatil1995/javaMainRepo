package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.EmployeeException;
import com.masai.Service.EmployeeService;
import com.masai.bean.Employee;
import com.masai.bean.EmployeeDTO;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService empSer ; 
	
	@PostMapping("/employee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp) throws EmployeeException{
		
		Employee emp1 =  empSer.registerEmployee(emp) ;
		 return new ResponseEntity<>(emp1,HttpStatus.ACCEPTED);
	}
  
	@GetMapping("/employee/{emp}")
	public ResponseEntity<Employee> getEmployeebyItsId(@PathVariable("emp") Integer emp) throws EmployeeException{
		
		Employee emp1 =  empSer.getEmployeeById(emp) ;
		 
		return new ResponseEntity<>(emp1,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/employeeList")
	public ResponseEntity<List<Employee>> getAllEmployees() throws EmployeeException{
		
		List<Employee> emp1 =  empSer.getAllEmployeeDetails();
		 return new ResponseEntity<>(emp1,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/employee/{empId}")
	public ResponseEntity<Employee> deleteEmployee( @PathVariable("empId") Integer emp) throws EmployeeException{
		
		Employee emp1 =  empSer.deleteEmployeeById(emp) ;
		 return new ResponseEntity<>(emp1,HttpStatus.OK);
	}
	
	@GetMapping("/employeeListByAdd/{addres}")
	public ResponseEntity<List<Employee>> getAllEmployees(@PathVariable("address") String address) throws EmployeeException{
		
		List<Employee> emp1 =  empSer.getEmployeeDetailsByAddress(address) ;
		 return new ResponseEntity<>(emp1,HttpStatus.OK);
	}
	
	@PutMapping("/employee")
	public ResponseEntity<Employee> UpdateEmployee(@RequestBody Employee emp) throws EmployeeException{
		
		Employee emp1 =  empSer.updateEmployee(emp) ;
		 return new ResponseEntity<>(emp1,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/employeeNameAndAdd/{empId}")
	public ResponseEntity<String[] > getNameAndAddressByemployeeId(@PathVariable("empId") Integer emp) throws EmployeeException{
		
		String[] emp1 =  empSer.getNameAndAddressOfEmplyeeById(emp);
		 return new ResponseEntity<>(emp1,HttpStatus.FOUND);
	}
	
	@GetMapping("/employeeDto")
	public ResponseEntity<List<EmployeeDTO>> getAllEmployeesDTO() throws EmployeeException{
		
		List<EmployeeDTO> emp1 =  empSer.getNameAddressSalaryOfAllEmployee();
		 return new ResponseEntity<>(emp1,HttpStatus.ACCEPTED);
	}
	
	
	
	
}
