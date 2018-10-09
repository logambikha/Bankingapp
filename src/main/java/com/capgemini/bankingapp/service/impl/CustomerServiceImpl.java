package com.capgemini.bankingapp.service.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bankingapp.entities.Customer;
import com.capgemini.bankingapp.repository.impl.CustomerRepositoryImpl;
import com.capgemini.bankingapp.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepositoryImpl customerrepositoryimpl;
	
	@Override
	public Customer authenticate(Customer customer) throws SQLException {
		return customerrepositoryimpl.authenticate(customer);
	}

	@Override
	public Customer updateProfile(Customer customer) {
		return customerrepositoryimpl.updateProfile(customer);
	}

	@Override
	public boolean updatePassword(Customer customer, String oldPassword, String newPassword) {
		return customerrepositoryimpl.updatePassword(customer,oldPassword,newPassword);
	}
	

}
