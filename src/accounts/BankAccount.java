package accounts;

// 2010

import notifier.ConsoleNotifierService;
import notifier.EmailNotifierService;
import notifier.NotifierService;
import person.AccountOwner;

import java.util.UUID;

// 2102405518
public abstract class BankAccount {

    private String uuid;

    private AccountOwner accountOwner;

    private String accountNumber;

    private double balance;

    private NotifierService notifierService = new ConsoleNotifierService();

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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
