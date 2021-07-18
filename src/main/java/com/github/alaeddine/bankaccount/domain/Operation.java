package com.github.alaeddine.bankaccount.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Operation {

    private OperationType operationType;
    private Date date;
    private MonetaryAmount amount;
    private MonetaryAmount currentBalance;

    public Operation(OperationType operationType, MonetaryAmount amount, MonetaryAmount previousBalance) {
        this.operationType = operationType;
        this.date = new Date();
        this.amount = amount;
        this.currentBalance = OperationType.DEPOSIT == operationType ? previousBalance.add(amount) : previousBalance.subtract(amount);
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

    public MonetaryAmount getAmount() {
        return amount;
    }

    public void setAmount(MonetaryAmount amount) {
        this.amount = amount;
    }

    public MonetaryAmount getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(MonetaryAmount currentBalance) {
        this.currentBalance = currentBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return operationType == operation.operationType &&
                date.equals(operation.date) &&
                amount.equals(operation.amount) &&
                currentBalance.equals(operation.currentBalance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationType, date, amount, currentBalance);
    }
}
