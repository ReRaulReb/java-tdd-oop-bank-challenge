package com.booleanuk.core;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;

public class BankStatementTest {

	private BankStatement bs;
	private LocalDate date;

	public BankStatementTest(){
		this.date = LocalDate.of(2012, 1, 12);
		this.bs = new BankStatement(this.date, 2000f, 0f, 2000f); // date, credit, debit, balance at the time
	}

	@Test
	public void shouldGetDate(){
		LocalDate res = this.bs.getDate();
		Assertions.assertEquals(this.date, res);
	}

	@Test
	public void shouldGetCredit(){
		float res = this.bs.getCredit();
		Assertions.assertEquals(2000f, res, 0.0001);
	}

	@Test
	public void shouldGetDebit(){
		float res = this.bs.getDebit();
		Assertions.assertEquals(0f, res, 0.0001);
	}

	@Test
	public void shouldGetCurrentBalance(){
		float res = this.bs.getCurrentBalance();
		Assertions.assertEquals(4000f, res, 0.0001);
	}

	@Test
	public void shouldGetBeforeBalance(){
		float res = this.bs.getBeforeBalance();
		Assertions.assertEquals(2000f, res, 0.0001);
	}

	@Test
	public void shouldGetMaxLengh(){
		int res = this.bs.getMaxLenght();
		Assertions.assertEquals(9, res);
	}

	@Test
	public void shouldGetStatementToString(){
		String res = this.bs.toString();
		String expected = "12/01/2012 || 2000.00 ||         || 4000.00";
		Assertions.assertEquals(expected, res);
	}
	
}
