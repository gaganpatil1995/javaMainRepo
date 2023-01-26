package com.masai;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service(value = "ser")
public class EmployeeService {

	@Autowired
	private Map<Department , Employee> theMap ;
	@Autowired
	private List<Employee> theList ;
	
	@Value("${name}")
	private String appName ;
	
	public void printMap() {
		System.out.println(theMap) ;
	}
	public void printList() {
		Collections.sort(theList , new Comparator<Employee>() {
			public int compare( Employee em1, Employee em2){
				return Integer.valueOf(em1.getSalary() - em2.getSalary()) ;
			}
		}) ;
		
		
		System.out.println(theList) ;
	}
	public void printAppName() {
		System.out.println(appName) ;
	}
}
