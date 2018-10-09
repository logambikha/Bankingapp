package com.capgemini.bankingapp.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bankingapp.repository.BankAccountRepository;
import com.capgemini.bankingapp.service.BankAccountService;
@Service
public class BankAccountServiceImpl implements BankAccountService {
	@Autowired
	private BankAccountRepository bankaccountrepositoryimpl;

	@Override
	public double getBalance(long accountId) {
		return bankaccountrepositoryimpl.getBalance(accountId);
	}

	@Override
	public double withdraw(long accountId, double amount) {
		double accountBalance = bankaccountrepositoryimpl.getBalance(accountId);
		bankaccountrepositoryimpl.updateBalance(accountId, accountBalance - amount);
		return accountBalance - amount;
	}

	@Override
	public double deposit(long accountId, double amount) {
		double accountBalance = bankaccountrepositoryimpl.getBalance(accountId);
		bankaccountrepositoryimpl.updateBalance(accountId, accountBalance + amount);
		return accountBalance + amount;
	}

	@Override
	public boolean fundTransfer(long fromAcc, long toAcc, double amount) {
		getBalance(toAcc);
		withdraw(fromAcc, amount);
		deposit(toAcc, amount);
		return true;
		
		
	}

	
	}
	
	