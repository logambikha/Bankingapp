package com.capgemini.bankingapp.repository.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.capgemini.bankingapp.repository.BankAccountRepository;
@Repository
public class BankAccountRepositoryImpl implements BankAccountRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public double getBalance(long accountId) {
		return jdbcTemplate.queryForObject("SELECT balance FROM accounts WHERE account_id = ?",
				new Object[] { accountId }, Double.class);
	}

	@Override
	public double updateBalance(long accountId, double newBalance) {
		 jdbcTemplate.update(
				"UPDATE accounts SET balance = ? WHERE account_id = ?",
				new Object[] { newBalance,accountId});
		return newBalance ;
	}

}