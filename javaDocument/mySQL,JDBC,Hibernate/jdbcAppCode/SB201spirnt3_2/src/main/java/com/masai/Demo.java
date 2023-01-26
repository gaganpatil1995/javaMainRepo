package com.masai;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		EmployeeService em = ctx.getBean("ser",EmployeeService.class) ;
		
		em.printMap();
		em.printList(); 
		em.printAppName();

	}

}
