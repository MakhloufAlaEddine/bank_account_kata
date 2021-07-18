package com.github.alaeddine.bankaccount.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    private List<Operation> operationList = new ArrayList<Operation>();

    private MonetaryAmount currentBalance = new MonetaryAmount(0);

    public void deposit(MonetaryAmount ma) {

        operationList.add(new Operation(OperationType.DEPOSIT, ma, currentBalance));

        currentBalance = currentBalance.add(ma);

    }

    public MonetaryAmount getBalance() {
        return currentBalance;
    }

    public void withdraw(MonetaryAmount ma) {
        operationList.add(new Operation(OperationType.WITHDRAWAL, ma, currentBalance));
        currentBalance = currentBalance.subtract(ma);
    }

    public List<Operation> getOperations() {
        return operationList;
    }
}
