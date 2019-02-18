package com.capgemini.service;

import java.math.BigDecimal;
import java.util.List;

import com.capgemini.beans.Customer;

import com.capgemini.exception.DuplicatePhoneNo;
import com.capgemini.exception.PhoneNoDoesNotExist;

public interface WalletService {
	public Customer createAccount(String name,String mobileNumber,double amount) throws DuplicatePhoneNo;
	public Customer showBalance(String mobileNumber);
	public Customer fundTransfer(String sourceMobileNumber,String targetMobileNumber,double amount) throws PhoneNoDoesNotExist;
	public Customer depositAmount(String mobileNumber,double amount) throws PhoneNoDoesNotExist;
	public Customer withdrawAmount(String mobileNumber,double amount) throws PhoneNoDoesNotExist;
	
	
}
