package com.capgemini.service;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.regex.Pattern;

import com.capgemini.beans.Customer;

import com.capgemini.exception.DuplicatePhoneNo;
import com.capgemini.exception.PhoneNoDoesNotExist;
import com.capgemini.jdbc.JdbcConnection;
import com.capgemini.repository.WalletRepo;
import com.capgemini.repository.WalletRepoImpl;

public class WalletServiceImpl implements WalletService {

	WalletRepo walletRepo = new WalletRepoImpl();

	JdbcConnection jc = new JdbcConnection();

	@Override
	public Customer createAccount(String name, String mobileNumber, double wallet) throws DuplicatePhoneNo {
		// TODO Auto-generated method stub

		Customer customer = new Customer(name, mobileNumber, wallet);

		if (mobileNumber.length() != 10) {
			System.out.println("Not a valid No");
		}

		if (Pattern.compile("[0-9]").matcher(name).find()) {
			System.out.println("Not a valid Name");
		}

		if (walletRepo.findOne(mobileNumber) != null) {
			throw new DuplicatePhoneNo();
		}

		walletRepo.save(customer);
		return customer;
	}

	@Override
	public Customer showBalance(String mobileNumber) {
		// TODO Auto-generated method stub
		return walletRepo.findOne(mobileNumber);
	}

	@Override
	public Customer fundTransfer(String sourceMobileNumber, String targetMobileNumber, double amount)
			throws PhoneNoDoesNotExist {
		if (walletRepo.findOne(sourceMobileNumber) == null) {
			throw new PhoneNoDoesNotExist();
		}
		if (walletRepo.findOne(targetMobileNumber) == null) {
			throw new PhoneNoDoesNotExist();
		}

		this.depositAmount(targetMobileNumber, amount);
		this.withdrawAmount(sourceMobileNumber, amount);
		return walletRepo.findOne(sourceMobileNumber);
	}

	@Override
	public Customer depositAmount(String mobileNumber, double amount) throws PhoneNoDoesNotExist {
		// TODO Auto-generated method stub
		Connection con = jc.addConnection();

		if (walletRepo.findOne(mobileNumber) == null) {
			throw new PhoneNoDoesNotExist();

		}
		Customer customer = walletRepo.findOne(mobileNumber);
		try {

			PreparedStatement stmt1 = con.prepareStatement("update paywallet set wallet=? where mobileno=?");
			stmt1.setDouble(1, customer.getWallet() + amount);
			stmt1.setString(2, mobileNumber);
			stmt1.executeQuery();
		} catch (Exception e) {
			System.out.println(e);
		}
		// customer.setWallet(customer.getWallet() + amount);

		return customer;
	}

	@Override
	public Customer withdrawAmount(String mobileNumber, double amount) throws PhoneNoDoesNotExist {
		// TODO Auto-generated method stub
		Connection con = jc.addConnection();
		if (walletRepo.findOne(mobileNumber) == null) {
			throw new PhoneNoDoesNotExist();
		}
		Customer customer = walletRepo.findOne(mobileNumber);

		//customer.setWallet(customer.getWallet() - amount);
		try {

			PreparedStatement stmt1 = con.prepareStatement("update paywallet set wallet=? where mobileno=?");
			stmt1.setDouble(1, customer.getWallet() - amount);
			stmt1.setString(2, mobileNumber);
			stmt1.executeQuery();
		} catch (Exception e) {
			System.out.println(e);
		}

		return customer;
	}

}
