package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import com.booleanuk.core.accounts.CurrentAccount;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomerTest {

	private Customer c;

	public CustomerTest(){
		this.c = new Customer();
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

	@Test
	void throwsWhenAccountAllreadyExists() throws Exception{
		// might be implemented elsewhere? makes more sense in Bank maybe

	}
}
