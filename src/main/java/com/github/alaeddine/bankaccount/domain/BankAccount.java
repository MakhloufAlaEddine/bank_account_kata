package com.github.alaeddine.bankaccount.domain;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    private List<Operation> operationList = new ArrayList<Operation>();

    private double currentBalance = 0d;

    public void deposit(double i) {

        operationList.add(new Operation(OperationType.DEPOSIT, i, currentBalance));

        currentBalance += i;

    }

    public double getBalance() {
        return currentBalance;
    }

    public void withdraw(double i) {
        operationList.add(new Operation(OperationType.WITHDRAWAL, i, currentBalance));
        currentBalance -= i;
    }

    public List<Operation> getOperations() {
        return operationList;
    }
}
