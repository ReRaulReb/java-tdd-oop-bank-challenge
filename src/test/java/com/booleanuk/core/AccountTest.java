package com.booleanuk.core;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import com.booleanuk.core.accounts.*;


public class AccountTest {

	private Account a;
	private LocalDate date;

	public AccountTest(){
		this.a = new Account("testAccount");
		this.a.deposit(2000f);
		this.date = LocalDate.now();
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
		Exception exception = assertThrows(Exception.class, () -> this.a.withdraw(2500f));
		assertEquals("Cannot make withdrawl, balance is less then amount requested", exception.getMessage());
	}

	// @Test
	// public void generateBankStatement(){
	// 	String expected = "date       || credit  || debit   || balance\n"
	// 			+ this.date.toString() + " || 2000.00 ||         || 0.00";
	// 	String res = this.a.generateBankStatement();
	// 	Assertions.assertEquals(expected, res);
	// }

}
