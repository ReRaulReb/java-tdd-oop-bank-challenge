package com.booleanuk.core;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import com.booleanuk.core.accounts.*;

public class BankTest {

	private Bank b;

	public BankTest() throws Exception{
		this.b = new Bank();
		this.b.requestAccount("nvim funds", "SAV");
	}

	@Test
	public void shouldRequestCurrentAccount() throws Exception{
		Account resAcc = b.requestAccount("testAccount", "CUR");
		Assertions.assertEquals(CurrentAccount.class, resAcc.getClass());
		Assertions.assertEquals("testAccount", resAcc.getName());
	}

	@Test
	public void shouldRequestSavingsAccount() throws Exception{
		Account resAcc = b.requestAccount("testAccount", "SAV");
		Assertions.assertEquals(SavingsAccount.class, resAcc.getClass());
		Assertions.assertEquals("testAccount", resAcc.getName());
	}

	@Test void shouldBeVailidAccount(){
		Assertions.assertTrue(b.isValidAccount("TestAccount"));
	}

	@Test void shouldBeInvalidAccount(){
		Assertions.assertFalse(b.isValidAccount("nvim funds"));
	}

	@Test void shouldGetAccount() throws Exception{
		Account resAcc = this.b.getAccount("nvim funds");
		Assertions.assertEquals(SavingsAccount.class, resAcc.getClass());
		Assertions.assertEquals("nvim funds", resAcc.getName());
	}

	@Test
	void shouldThrowAccountNotAvailable() throws Exception{
		Exception exception = Assertions.assertThrows(Exception.class, () -> b.requestAccount("nvim funds", "SAV"));
		Assertions.assertEquals("Account is not available!", exception.getMessage());
	}

	@Test
	void shouldThrowNoSuchAccountType() throws Exception{
		Exception exception = Assertions.assertThrows(Exception.class, () -> b.requestAccount("nvim funds", "NOT"));
		Assertions.assertEquals("No such account type!", exception.getMessage());
	}

	@Test
	void shouldThrowAccountDoesNotExist() throws Exception{
		Exception exception = Assertions.assertThrows(Exception.class, () -> b.getAccount("test"));
		Assertions.assertEquals("Account is not available!", exception.getMessage());
	}
	
}
