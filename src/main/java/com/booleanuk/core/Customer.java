package com.booleanuk.core;

public class Customer {
	
	private Bank bank;

	public Customer(Bank bank){
		setBank(bank);
	}

	private void setBank(Bank bank){
		this.bank = bank;
	}

	private Bank getBank(){
		return this.bank;
	}

	public Account createCurrentAccount(String name) throws Exception{
		return getBank().requestAccount(name, "CUR");
	}

	public Account createSavingsAccount(String name) throws Exception{
		return getBank().requestAccount(name, "SAV");
	}

	public Account getAccount(String name) throws Exception{
		return getBank().getAccount(name);
	}
}
