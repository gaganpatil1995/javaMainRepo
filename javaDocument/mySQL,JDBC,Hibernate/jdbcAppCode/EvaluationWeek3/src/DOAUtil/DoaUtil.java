package DOAUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DoaUtil {

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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return conn ;
	}
}
