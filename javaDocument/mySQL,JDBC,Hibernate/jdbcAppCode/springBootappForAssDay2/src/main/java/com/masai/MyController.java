package com.masai;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

	@RequestMapping(value = "/employee" , method = RequestMethod.GET)
	@ResponseBody
	public Employee getEmployee() {
		
		return new Employee(2,"gagan",3000);
	}
	
	@RequestMapping(value = "/employees",method = RequestMethod.GET)
	@ResponseBody
	public List<Employee> getAllEmployee(){
		 
		Employee emp1 = new Employee(3, "rahul",2000) ;
		Employee emp2 = new Employee(4, "kaka",2300) ;
	    Employee emp3  = new Employee(5, "ramu",2400) ;
	    Employee emp4 = new Employee(6,"shnkar",2500) ;
	    Employee emp5 = new Employee(7 , "shubham", 2100) ;
	    
	   return Arrays.asList(emp1,emp2,emp3,emp4,emp5) ;
	}
	
	@RequestMapping(value = "/hello" ,method = RequestMethod.GET)
	@ResponseBody
	public String helloClient() {
		return "Welcome to Spring Boot" ;
	}
	
}
