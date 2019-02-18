package com.capgemini.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnection {
	private static Connection con=null;
	public static Connection addConnection()
	{
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Capgemini123");
	
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
		return con;
	}
	public static Connection getCon() {
		return con;
	}
//	public static void setCon(Connection con) {
//		JdbcConnection.con = con;
//	}

}
