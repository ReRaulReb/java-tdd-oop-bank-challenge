package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Account {
	
	private String name;
	private float balance;
	private List<BankStatement> bankStatement;

	public Account(String name){
		setName(name);
		setBalance(0f);
		this.bankStatement = new ArrayList<BankStatement>();
	}

	private void setName(String name){
		this.name = name;
	}

	private void setBalance(float balance){
		this.balance = balance;
	}
}

