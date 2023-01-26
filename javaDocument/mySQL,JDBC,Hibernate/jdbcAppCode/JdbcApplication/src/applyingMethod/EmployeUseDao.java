package applyingMethod;
import java.util.Scanner ;

import BeanClasses.Employee3;

import java.util.List ;

import DaoMethods.EmployeIntrDao;
import DaoMethods.EmployeMethods;

public class EmployeUseDao {

	public static void main(String[] args) {
		
		
		Scanner input = new Scanner(System.in) ;
//		System.out.println("Please Enter roll number");
//		int eid = input.nextInt() ;
//		
//		EmployeMethods emp = new EmployeMethods() ;
//	  int salary = emp.getSalaryByid(eid) ;
//	  System.out.println(salary);
		Employee3 empl = new Employee3(1,"daga","sda",2000);
		EmployeIntrDao empInt = new EmployeMethods();
		
		String Detail =empInt.saveEmployeeDetails(empl);
		System.out.println(Detail);
//		List<Employee3> list = empInt.getAllEmploye();
//		 
//		list.forEach(s-> System.out.println(s));                
		
	}
}
