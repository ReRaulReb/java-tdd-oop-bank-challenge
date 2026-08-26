package com.booleanuk.core;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.booleanuk.core.accounts.*;

public class BankTest {

	private Bank b;

	public BankTest(){
		this.b = new Bank();
		this.b.requstAccount("nvim funds", "SAV");
	}

	@Test
	public void shouldRequestCurrentAccount(){
		Account resAcc = this.b.requestAccount("testAccount", "CUR");
		Assertions.assertEquals(CurrentAccount.class, resAcc.class);
		Assertions.assertEquals("testAccount", resAcc.getName());
	}

	@Test
	public void shouldRequestSavingsAccount(){
		Account resAcc = this.b.requestAccount("testAccount", "SAV");
		Assertions.assertEquals(SavingsAccount.class, resAcc.class);
		Assertions.assertEquals("testAccount", resAcc.getName());
	}

	@Test void shouldBeVailidAccount(){
		Assertions.assertTrue(this.b.isValidAccount("TestAccount"));
	}

	@Test void shouldBeInvalidAccount(){
		Assertions.assertFalse(this.b.isValidAccount("nvim funds"));
	}

	@Test void shouldGetAccount(){
		Account resAcc = this.b.getAccount("nvim funds");
		Assertions.assertEquals(SavingsAccount.class, resAcc.class);
		Assertions.assertEquals("nvim funds", resAcc.getName());
	}
}
