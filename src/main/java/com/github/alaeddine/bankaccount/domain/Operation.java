package com.github.alaeddine.bankaccount.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Operation {

    private OperationType operationType;
    private Date date;
    private double amount;
    private double currentBalance;

    public Operation(OperationType operationType, double amount, double previousBalance) {
        this.operationType = operationType;
        this.date = new Date();
        this.amount = amount;
        this.currentBalance = OperationType.DEPOSIT == operationType ? previousBalance + amount : previousBalance - amount;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return Double.compare(operation.amount, amount) == 0 &&
                Double.compare(operation.currentBalance, currentBalance) == 0 &&
                operationType == operation.operationType &&
                date.equals(operation.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationType, date, amount, currentBalance);
    }
}
