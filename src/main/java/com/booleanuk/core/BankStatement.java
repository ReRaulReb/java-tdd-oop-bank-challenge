package com.booleanuk.core;

import java.time.LocalDate;

public class BankStatement {

	private LocalDate date;
	private float credit;
	private float debit;
	private float currentBalance;
	private float beforeBalance;
	private int maxLenght;

	public BankStatement(LocalDate date, float credit, float debit, float beforeBalance){
		setDate(date);
		setCredit(credit);
		setDebit(debit);
		setBeforeBalance(beforeBalance);
		setCurrentBalance(credit, debit, beforeBalance);
		setMaxLenght(credit, debit);
	}

	public BankStatement(float credit, float debit, float beforeBalance){
		setDate(LocalDate.now());
		setCredit(credit);
		setDebit(debit);
		setBeforeBalance(beforeBalance);
		setCurrentBalance(credit, debit, beforeBalance);
		setMaxLenght(credit, debit);
	}

	private void setDate(LocalDate date){
		this.date = date;
	}

	private void setCredit(float credit){
		this.credit = credit;
	}

	private void setDebit(float debit){
		this.debit = debit;
	}

	private void setBeforeBalance(float beforeBalance){
		this.beforeBalance = beforeBalance;
	}

	private void setCurrentBalance(float credit, float debit, float beforeBalance){
		this.currentBalance = beforeBalance + credit - debit;
	}

	private void setMaxLenght(float credit, float debit){
		if(!(credit == 0f))
			this.maxLenght = String.format("%.2f", credit).length() + 2;
		else
			this.maxLenght = String.format("%.2f", debit).length() + 2;
	}

	public LocalDate getDate(){
		return this.date;
	}

	public float getCredit(){
		return this.credit;
	}

	public float getDebit(){
		return this.debit;
	}

	public float getBeforeBalance(){
		return this.beforeBalance;
	}

	public float getCurrentBalance(){
		return this.currentBalance;
	}

	public int getMaxLenght(){
		return this.maxLenght;
	}

	@Override
	public String toString(){
		if(!(getCredit() == 0f))
			return getDate().toString() + " || " + 
			       String.format("%.2f", getCredit()) + " ||" +
			       " ".repeat(getMaxLenght())+ "|| " +
			       String.format("%.2f", getCurrentBalance());
		else
			return getDate().toString() + " ||" +
			       " ".repeat(getMaxLenght()) + "|| " +
			       String.format("%.2f", getDebit()) + " ||" +
			       String.format("%.2f", getCurrentBalance());
	}

}
