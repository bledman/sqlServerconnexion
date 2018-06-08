package conSqlServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {

		System.out.println("ici Sql server !");

		// Create a variable for the connection string.
		String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=Airline;user=abdou;password=*****";
		// declaration JDBC
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			 con = DriverManager.getConnection(connectionUrl);
			 String sql = "Select* from Pilote";
			 stmt = con.createStatement(); // creation de statement;
			 rs = stmt.executeQuery(sql);
			 while(rs.next())
			 {
				 System.out.println(rs.getString(4)+" "+rs.getString(6));
			 }
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			 if(rs!=null)try { rs.close(); } catch(Exception e) {}  
			 if(stmt!=null)try { stmt.close(); } catch(Exception e) {} 
			 if(con!=null)try { con.close(); } catch(Exception e) {} 
			 
		}
		
		

	}

}
