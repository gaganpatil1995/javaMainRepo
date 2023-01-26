package DaoMethods;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException ;
import java.util.List;
import java.util.ArrayList ;

import BeanClasses.Employee3;


import java.sql.ResultSet;


import Jdbc_app_Util.db3_Database;
import exceptions.EmployeeException;

public class EmployeMethods implements EmployeIntrDao {
   
	@Override
	public  int getSalaryByid(int id) {
		int salary = -1 ;
		
		try(Connection conn = db3_Database.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select salary from Employee3 where eid = ?");
			ps.setInt(1,id) ;
			ResultSet rs = ps.executeQuery() ;
			rs.next();
			salary = rs.getInt("salary");
//			System.out.println(salary);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return salary ;
	}

	
//	@Override
//	public List<Employee3> getAllEmploye() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	@Override 
	public List<Employee3> getAllEmploye(){
		List <Employee3> list = new ArrayList<>() ;
//		Connection conn = null ;
		try(Connection conn = db3_Database.provideConnection()){
			PreparedStatement ps = conn.prepareStatement(" select * from Employee3");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int eid = rs.getInt("eid"); 
				String name = rs.getString("name");
				String addres = rs.getString("address");
				int salary = rs.getInt("salary");
				Employee3 emp = new Employee3(eid,name,addres,salary);
				list.add(emp);
			}
		}catch(SQLException e ) {
			e.printStackTrace();
		}
		
		
		
		return list ;
	}


	@Override
	public String saveEmployeeDetails(Employee3 employee) {
		String detail = "" ;
		int eid = employee.getEid();
		
		try(Connection conn = db3_Database.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from employee3 where eid=?");
			ps.setInt(1, eid);
			ResultSet rs = ps.executeQuery();
			if(rs.next()==true) {
				while(rs.next()) {
					int emid = rs.getInt("eid");
					String name = rs.getString("name") ;
					String add = rs.getString("address");
					int salary = rs.getInt("salary");
					
					detail = "Employe id : "+emid +" Name : "+name +" Address :"+add + " Salary "+salary ;
				}
			}
			else {
				EmployeeException e = new EmployeeException("This employee id is not valid");
				throw e ;
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
				
				
	return detail;
	}
	
}
