package com.masai.usecases;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.masai.Dao.PresentationBean;
import com.masai.bean.AppConfig;

public class Demo {
	
	

	public static void main(String[] args) {
   ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
   
   PresentationBean prs = ctx.getBean("presentationBean", PresentationBean.class) ;
   prs.insertEmployee();
   prs.printAllEmployee();
   prs.deleteEmployee();
	}
}
