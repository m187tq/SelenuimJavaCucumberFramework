package practice.demo.day10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 1) Create a connection
2) Create a query/statement
3) Execute statement/query
4) close connection

 * 
 */
public class JDBCExample2 {

	public static void main(String[] args) throws SQLException {
		
		//Create a connection
		
			
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/pdborcl","hr","hr");

		//Create a query/statement
		Statement stmt=con.createStatement();
		String s="select employee_id,first_name,last_name from employees";
		
		//Execute statement/query
		ResultSet rs=stmt.executeQuery(s);
		
		while(rs.next())
			{
				int eid=rs.getInt("EMPLOYEE_ID");
				String fname=rs.getString("FIRST_NAME");
				String lname=rs.getString("LAST_NAME");
				System.out.println(eid+"          "+fname+"        "+lname);
			
			}
			
		//close connection
		con.close();
		
		System.out.println("Program is completed");
		
		
		
	}

}
