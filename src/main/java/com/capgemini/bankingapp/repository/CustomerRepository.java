package com.capgemini.bankingapp.repository;

import java.sql.SQLException;

import com.capgemini.bankingapp.entities.Customer;

public interface CustomerRepository {
	public Customer authenticate(Customer customer) throws SQLException;

	public Customer updateProfile(Customer customer);

	public boolean updatePassword(Customer customer, String oldPassword, String newPassword);

	

}
