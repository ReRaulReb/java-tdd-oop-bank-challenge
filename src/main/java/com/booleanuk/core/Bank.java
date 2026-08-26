package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;

import com.booleanuk.core.accounts.CurrentAccount;
import com.booleanuk.core.accounts.SavingsAccount;

public class Bank {

	private Map<String,Account> accounts;

	public Bank(){
		this.accounts = new HashMap<String, Account>();
	}

	public boolean isValidAccount(String name){
		return !(this.accounts.containsKey(name));
	}

	public Account requestAccount(String name, String type) throws Exception{
		Account acc = null;
		switch(type){
			case "CUR":
				acc = new CurrentAccount(name);
				break;
			case "SAV":
				acc = new SavingsAccount(name);
				break;
			default:
				throw new Exception("No such account type!");
		}
		if(isValidAccount(name))
			addAccount(name, acc);
		else
			throw new Exception("Account is not available!");

		return acc;
	}

	public Account getAccount(String name) throws Exception{
		if(!isValidAccount(name))
			return this.accounts.get(name);
		else
			throw new Exception("Account is not available!");
	}

	private void addAccount(String name, Account acc){
		this.accounts.put(name, acc);
	}
	
}
