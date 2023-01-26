package methods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Beanclass.Employee;
import DOAUtil.DoaUtil;
import EmployeeException.EmployeeException;

public class EmployeMethoImp implements EmpoyeMethodIntr {

	@Override
	public String saveEmployeeDetails(Employee employee) {
		String detail = "" ;
		int eid = employee.getEid();
		
		try(Connection conn = DoaUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from employee3 where eid=?");
			ps.setInt(1, eid);
			ResultSet rs = ps.executeQuery();
			
				while(rs.next()) {
					int emid = rs.getInt("eid");
					String name = rs.getString("name") ;
					String add = rs.getString("address");
					int salary = rs.getInt("salary");
					
					detail = "Employe id : "+emid +" Name : "+name +" Address :"+add + " Salary "+salary ;
				}
			
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
				
				
	return detail;
	}

}
