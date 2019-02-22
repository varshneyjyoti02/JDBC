package com.capi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	public static Connection con;
	public static Connection toConnect()
	{try
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
	return con;}


	

}
