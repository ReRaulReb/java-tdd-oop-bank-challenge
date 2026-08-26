package com.booleanuk.core;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import com.booleanuk.core.accounts.*;

public class CustomerTest {

	private Customer c;
	private Bank b;

	public CustomerTest() throws Exception{
		this.b = new Bank();
		this.b.requestAccount("nvim funds", "SAV");
		this.c = new Customer(this.b);
	}

	@Test
	public void shouldCreateCurrentAccount() throws Exception{
		Account resAcc = c.createCurrentAccount("testAccount");
		Assertions.assertEquals("testAccount", resAcc.getName());
		Assertions.assertEquals(CurrentAccount.class, resAcc.getClass());
	}

	@Test
	public void shouldCreateSavingsAccount() throws Exception{
		Account resAcc = c.createSavingsAccount("testAccount");
		Assertions.assertEquals("testAccount", resAcc.getName());
		Assertions.assertEquals(SavingsAccount.class, resAcc.getClass());
	}

	@Test
	public void shouldGetAccount() throws Exception{
		Account resAcc = c.getAccount("nvim funds");
		Assertions.assertEquals("nvim funds", resAcc.getName());
		Assertions.assertEquals(SavingsAccount.class, resAcc.getClass());
	}

}
