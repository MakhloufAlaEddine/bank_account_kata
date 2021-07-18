package com.github.alaeddine.bankaccount.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class MonetaryAmount {

    private BigDecimal amount;

    public MonetaryAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public MonetaryAmount(double amount) {
        this(BigDecimal.valueOf(amount));
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    MonetaryAmount add(MonetaryAmount amountToAdd) {
        return new MonetaryAmount(
                amount.add(amountToAdd.amount)
        );
    }

    MonetaryAmount subtract(MonetaryAmount amountToSubstract) {
        return new MonetaryAmount(
                amount.subtract(amountToSubstract.amount)
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonetaryAmount that = (MonetaryAmount) o;
        return amount.compareTo(that.amount) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
