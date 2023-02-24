package com.bank;

import com.bank.service.impl.BankServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class BankServiceImplTest {
    BankServiceImpl bankService;
    BankAccount bankAccount;

    @Before
    public void initialize() {
        bankService = new BankServiceImpl();
        bankAccount = new BankAccount("David", "2");
    }


    @Test
    public void testWithdrawNormal() {
        bankAccount.setBalance(300.0);
        bankService.withdraw(bankAccount, 100.0);
        Assertions.assertEquals(200.0, bankAccount.getBalance());
        Assertions.assertEquals(-100.0, bankAccount.getPrevTrans());


    }

    @Test
    public void testWithdrawBiggerAmountThanCurrentBalance() {
        bankAccount.setBalance(200.0);
        bankService.withdraw(bankAccount, 300.0);
        Assertions.assertEquals(200.0, bankAccount.getBalance());


    }


    @Test
    public void testDepositNormal() {
        bankService.deposit(bankAccount, 200.0);
        Assertions.assertEquals(200.0, bankAccount.getBalance());
        Assertions.assertEquals(200, bankAccount.getPrevTrans());


    }

    @Test
    public void testDepositWithNegativeAmount() {
        bankService.deposit(bankAccount, 100.0);
        bankService.deposit(bankAccount, -100.0);
        Assertions.assertEquals(100, bankAccount.getBalance());

    }

}
