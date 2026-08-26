package com.booleanuk.core;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.booleanuk.core.accounts.*;

public class CustomerTest {

	private Customer c;
	private Bank b;

	public CustomerTest(){
		this.b = new Bank();
		this.b.requestAccount("nvim funds", "SAV");
		this.c = new Customer(this.b);
	}

	@Test
	public void shouldCreateCurrentAccount(){
		Account resAcc = c.createCurrentAccount("testAccount");
		Assertions.assertEquals("testAccount", resAcc.getName());
		Assertions.assertEquals(CurrentAccount.class, resAcc.class);
	}

	@Test
	public void shouldCreateSavingsAccount(){
		Account resAcc = c.createSavingsAccount("testAccount");
		Assertions.assertEquals("testAccount", resAcc.getName());
		Assertions.assertEquals(SavingsAccount.class, resAcc.class);
	}

}
