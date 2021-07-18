package com.github.alaeddine.bankaccount.domain;

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

    @Test
    void return_one_deposit_operation_upon_deposit_of_100() {
        BankAccount bankAccount = new BankAccount();

        bankAccount.deposit(100);

        assertEquals(1, bankAccount.getOperations().size());
        Operation first = bankAccount.getOperations().get(0);
        assertEquals(100, first.getAmount());
        assertEquals(OperationType.DEPOSIT, first.getOperationType());
        assertEquals(100, first.getCurrentBalance());
        assertNotNull(first.getDate());
    }


    @Test
    void return_one_withdrawal_operation_upon_withdraw_of_100() {
        BankAccount bankAccount = new BankAccount();

        bankAccount.withdraw(100);

        assertEquals(1, bankAccount.getOperations().size());
        Operation first = bankAccount.getOperations().get(0);
        assertEquals(100, first.getAmount());
        assertEquals(OperationType.WITHDRAWAL, first.getOperationType());
        assertEquals(-100, first.getCurrentBalance());
        assertNotNull(first.getDate());
    }

    @Test
    void return_two_operations_upon_deposit_of_200_withdraw_of_100() {
        // given
        BankAccount bankAccount = new BankAccount();

        // when
        bankAccount.deposit(200);
        bankAccount.withdraw(100);

        // then
        assertEquals(2, bankAccount.getOperations().size());
        Operation first = bankAccount.getOperations().get(0);
        assertEquals(200, first.getAmount());
        assertEquals(OperationType.DEPOSIT, first.getOperationType());
        assertNotNull(first.getDate());
        assertEquals(200, first.getCurrentBalance());

        Operation second = bankAccount.getOperations().get(1);
        assertEquals(100, second.getAmount());
        assertEquals(OperationType.WITHDRAWAL, second.getOperationType());
        assertNotNull(second.getDate());
        assertEquals(100, second.getCurrentBalance());
    }

}
