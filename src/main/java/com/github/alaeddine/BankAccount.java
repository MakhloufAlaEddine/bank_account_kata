package com.github.alaeddine;

public class BankAccount {

    double currentBalance = 0d;

    public void deposit(int i) {
        currentBalance += i;
    }

    public double getBalance() {
        return currentBalance;
    }

    public void withdraw(int i) {
        currentBalance -= i;
    }
}
