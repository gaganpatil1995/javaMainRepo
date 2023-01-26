package com.masai;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("name.properties")
@ComponentScan(basePackages = "com.masai")
public class AppConfig {

	@Bean(name = "map")
	public Map<Department ,Employee> getmap() {
		
 Department dpt1 = new Department(1, "sales", "Mumbai") ;
 Department dpt2 = new Department(1, "Marketing", "pune") ;
 Department dpt3 = new Department(1, "IT", "Banglore") ;
		
 Employee emp1 = new Employee(12, "raghav", 10000) ;
 Employee emp2 = new Employee(13, "rahul", 20000) ;
 Employee emp3 = new Employee(12, "durgesh", 12000) ;
 
 Map<Department , Employee> theMap = new HashMap() ;
 
 theMap.put(dpt1, emp1);
 theMap.put(dpt3, emp3);
 theMap.put(dpt2, emp2) ;
 return theMap ;
 
	}

	@Bean(name = "list")
	public List<Employee> getList(){
		Employee emp1  = new Employee(13,"gagan",90000) ;
		Employee emp2 = new Employee(15, "roshni", 91000) ;
		Employee emp3 = new Employee(16, "pawan", 92000) ;
		Employee emp4 = new Employee(17, "rahul", 93000) ;
		Employee emp5 = new Employee(18, "shubham",1000) ;
		return Arrays.asList(emp1,emp2,emp3,emp4,emp5) ;
	}
}
