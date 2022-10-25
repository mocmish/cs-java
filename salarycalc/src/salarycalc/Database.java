package salarycalc;
import java.sql.*;

public class Database {
	Connection connect = null;
	String dburl = null;
	String[] logininfo = null;
	
	Database(String url, String user, String pass) {
		this.dburl = url;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Attempting connection to Xampp Mysql..");
			connect=DriverManager.getConnection(url,"root","");
			System.out.println("Xampp Mysql Connected!");
		} catch(Exception e) {
			System.out.println("Error connecting to database..");
			e.printStackTrace();
		}
	}
	
	public void runUpdate(String Query) { //run queries
		try {
			System.out.println("Querying database");
			Statement stat = this.connect.createStatement();
			stat.executeUpdate(Query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet searchQuery(String tablename,String collumn, String pattern) {
		ResultSet returnVal = null;
		try {
			String query = "SELECT * FROM `"+tablename+"` WHERE `"+collumn+"` LIKE '"+pattern+"'";
			System.out.println("Querying database");
			Statement stat = this.connect.createStatement();
			returnVal = stat.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnVal;
	}
}
