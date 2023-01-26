package Jdbc_app_Util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db3_Database {
  
	public static Connection provideConnection() {
		Connection conn = null ;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sc = "jdbc:mysql://localhost:3306/db3" ;
		
		try {
		 conn = DriverManager.getConnection(sc, "root", "Gagan@1995");
		 if(conn!=null)
			 System.out.println("connected..");
		 else
			 System.out.println("Not connected..");
		}
		catch(SQLException e ) {
			e.printStackTrace();
		}
		
		
		return conn;
	}
	public static void main(String[] args) {
		Connection conn = db3_Database.provideConnection();
	}
}
