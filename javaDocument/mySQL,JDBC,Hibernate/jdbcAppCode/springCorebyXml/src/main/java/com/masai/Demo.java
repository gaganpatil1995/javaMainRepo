package com.masai;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {

	public static void main(String[] args) {
		ApplicationContext ctx1 = new  ClassPathXmlApplicationContext("applicationcontext.xml") ;
		
		College clg =  ctx1.getBean("clg1", College.class) ;
		
		clg.showDetails();
		

	}

}
