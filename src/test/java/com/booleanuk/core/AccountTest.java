package com.booleanuk.core;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;


public class AccountTest {

	private Account a;
	private LocalDate date;

	public AccountTest(){
		this.date = LocalDate.of(2012, 1, 12);
		this.a = new Account("testAccount");
		this.a.deposit(2000f, date);
	}

	@Test
	public void shouldGetBalance(){
		Assertions.assertEquals(2000f, a.getBalance(), 0.0001);
	}

	@Test
	public void shouldGetName(){
		Assertions.assertEquals("testAccount", a.getName());
	}

	@Test
	public void shouldDeposit(){
		this.a.deposit(2000f);
		Assertions.assertEquals(4000f, this.a.getBalance(), 0.0001);
	}

	@Test
	public void shouldWithdraw() throws Exception{
		this.a.withdraw(1000f);
		Assertions.assertEquals(1000f, this.a.getBalance(), 0.0001);
	}

	@Test
	void shouldThrowExeptionWhenWithdrawLeadsToNegativeBalance(){
		Exception exception = Assertions.assertThrows(Exception.class, () -> this.a.withdraw(2500f));
		Assertions.assertEquals("Cannot make withdrawl, balance is less then amount requested", exception.getMessage());
	}

	@Test
	public void shouldGenerateBankStatement(){
		String expected = "date       || credit  || debit   || balance\n"
				+ this.date.toString() + " || 2000.00 ||         || 2000.00";
		String res = this.a.generateBankStatement();
		Assertions.assertEquals(expected, res);
	}

	@Test
	public void shouldDepositAndWithdrawWithDates() throws Exception{
		LocalDate date1 = LocalDate.of(2012, 1, 13);
		LocalDate date2 = LocalDate.of(2012, 1, 14);
		this.a.deposit(2000f, date1);
		this.a.withdraw(500f, date2);
		String expected = """
date       || credit  || debit   || balance
2012-01-14 ||         || 500.00  || 3500.00
2012-01-13 || 2000.00 ||         || 4000.00
2012-01-12 || 2000.00 ||         || 2000.00""";
		Assertions.assertEquals(expected, this.a.generateBankStatement());
	}


}
