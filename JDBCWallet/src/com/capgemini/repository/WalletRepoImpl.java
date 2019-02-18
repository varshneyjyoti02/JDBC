package com.capgemini.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import com.capgemini.beans.Customer;
import com.capgemini.jdbc.JdbcConnection;

public class WalletRepoImpl implements WalletRepo {
	JdbcConnection jc=new JdbcConnection();
	
	@Override
	public boolean save(Customer customer) {
		// TODO Auto-generated method stub
		Connection con=jc.addConnection();
		String name=customer.getName();
		String phone=customer.getMobileNumber();
		double amount=customer.getWallet();
		try {
				
			PreparedStatement stmt=con.prepareStatement("insert into paywallet values(?,?,?)") ;
			stmt.setString(1, name);
		    stmt.setString(2, phone);
		    stmt.setDouble(3, amount);
		    stmt.executeQuery();
		    con.close();
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return true;
	}


	@Override
	public Customer findOne(String mobilenumber) {
		// TODO Auto-generated method stub
		Connection con =jc.addConnection();
		Customer c=new Customer();
		try {
	
	PreparedStatement stmt1=con.prepareStatement("select * from paywallet where mobileno=?")	;
	stmt1.setString(1, mobilenumber);
    ResultSet rs=stmt1.executeQuery();
		while(rs.next())
		{
			c.setName(rs.getString(1));
			c.setMobileNumber(rs.getString(2));
			c.setWallet(rs.getDouble(3));
			con.close();
			return c;
		}
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	return null;
	}


}
