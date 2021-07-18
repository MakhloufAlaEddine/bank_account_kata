package com.github.alaeddine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountShould {

    @Test
    void create_bank_account() {
        BankAccount bankAccount = new BankAccount();
        assertNotNull(bankAccount);
    }

    @Test
    void deposit_100_in_account() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(100);

        assertEquals(100, bankAccount.getBalance());
    }

    @Test
    void return_balance_as_minus100_when_retrieve_100_from_account() {
        // given
        BankAccount bankAccount = new BankAccount();
        //when
        bankAccount.withdraw(100);

        //then
        assertEquals(-100, bankAccount.getBalance());
    }

    @Test
    void return_balance_as_400_when_retrieve_100_from_account(){
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(500);

        bankAccount.withdraw(100);

        assertEquals(400, bankAccount.getBalance());
    }

    @Test
    void return_balance_as_0_when_retrieve_100_from_account() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(100);

        bankAccount.withdraw(100);

        assertEquals(0, bankAccount.getBalance());
    }


}
