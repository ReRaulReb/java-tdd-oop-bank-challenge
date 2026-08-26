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

	@Test
	void shouldThrowAccountNotAvailable() throws Exception{
		Exception exception = assertThrows(Exception.class, () -> b.requestAccount("nvim funds", "SAV"));
		assertEquals("Account is not available!", exception.getMessage());
	}

	@Test
	void shouldThrowNoSuchAccountType() throws Exception{
		Exception exception = assertThrows(Exception.class, () -> b.requestAccount("nvim funds", "NOT"));
		assertEquals("No such account type!", exception.getMessage());
	}

	@Test
	void shouldThrowAccountDoesNotExist() throws Exception{
		Exception exception = assertThrows(Exception.class, () -> b.getAccount("test"));
		assertEquals("No such account type!", exception.getMessage());
	}
}
