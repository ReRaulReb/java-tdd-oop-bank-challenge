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

	public Account requestAccount(String name, String type){
		Account acc = null;
		switch(type){
			case "CUR":
				acc = new CurrentAccount(name);
				break;
			case "SAV":
				acc = new SavingsAccount(name);
				break;
		}

		addAccount(name, acc);
		return acc;
	}

	private void addAccount(String name, Account acc){
		this.accounts.put(name, acc);
	}
}
