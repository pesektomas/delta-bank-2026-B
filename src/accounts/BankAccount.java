package accounts;

// 2010

import person.AccountOwner;

import java.util.UUID;

// 2102405518
public abstract class BankAccount {



    private String uuid;

    private AccountOwner accountOwner;

    private String accountNumber;

    private double balance;

    public BankAccount(AccountOwner accountOwner, String accountNumber) {
        this.uuid = UUID.randomUUID().toString();
        this.accountOwner = accountOwner;
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public BankAccount(AccountOwner accountOwner, String accountNumber, double balance) {
        this(accountOwner, accountNumber);

        this.balance = balance;
    }

    public void add(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }

        this.balance += amount;
    }

    public void sub(double amount) {
        double newBalance = balance - amount;

        if (newBalance < 0) {
            throw new IllegalArgumentException("Cannot subtract negative amount");
        }

        this.balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}
