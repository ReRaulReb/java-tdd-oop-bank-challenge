package com.booleanuk.core;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Account {
	
	private String name;
	private float balance;
	private List<BankStatement> bankStatements;

	public Account(String name){
		setName(name);
		setBalance(0f);
		this.bankStatements = new ArrayList<BankStatement>();
	}

	private void setName(String name){
		this.name = name;
	}

	private void setBalance(float balance){
		this.balance = balance;
	}

	private void addBankStatement(BankStatement bankStatement){
		this.bankStatements.add(bankStatement);
	}

	public String getName(){
		return this.name;
	}

	public float getBalance(){
		return this.balance;
	}

	public void deposit(float amount){
		float pos = Math.abs(amount);
		BankStatement bankStatement = new BankStatement(pos, 0f, getBalance());
		addBankStatement(bankStatement);
		setBalance(getBalance() + pos);
	}

	public void withdraw(float amount) throws Exception{
		float pos = Math.abs(amount);
		if ((getBalance() - pos) < 0)
			throw new Exception("Cannot make withdrawl, balance is less then amount requested");
		BankStatement bankStatement = new BankStatement(0f, pos, getBalance());
		addBankStatement(bankStatement);
		setBalance(getBalance() - pos);
	}

	public void deposit(float amount, LocalDate date){
		float pos = Math.abs(amount);
		BankStatement bankStatement = new BankStatement(date, pos, 0f, getBalance());
		addBankStatement(bankStatement);
		setBalance(getBalance() + pos);
	}

	public void withdraw(float amount, LocalDate date) throws Exception{
		float pos = Math.abs(amount);
		if ((getBalance() - pos) < 0)
			throw new Exception("Cannot make withdrawl, balance is less then amount requested");
		BankStatement bankStatement = new BankStatement(date, 0f, pos, getBalance());
		addBankStatement(bankStatement);
		setBalance(getBalance() - pos);
	}

	public String generateBankStatement(){
		String tmp = "";
		int currMax = 0;

		List<BankStatement> tempList = this.bankStatements;
		tempList.sort(Comparator.comparing(BankStatement::getDate));
		Collections.reverse(tempList);

		for(BankStatement b : tempList){
			if (currMax < b.getMaxLenght())
				currMax = b.getMaxLenght();
		}

		for(BankStatement b : tempList){
			tmp += b.toString(currMax) + "\n";
		}

		String start = "date" + " ".repeat(11 - 4) +
			       "|| credit" + " ".repeat(currMax - 7) +
			       "|| debit" + " ".repeat(currMax - 6)+
			       "|| balance\n";

		return (start + tmp).trim();
	}

}

