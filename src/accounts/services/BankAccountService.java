package accounts.services;

import accounts.*;
import accounts.factories.BankAccountFactory;
import person.AccountOwner;

import java.util.ArrayList;
import java.util.List;

public class BankAccountService {

    BankAccountFactory bankAccountFactory = new BankAccountFactory();

    List<BankAccount> bankAccounts = new ArrayList<>();

    public BankAccount createCurrentBankAccount(AccountOwner accountOwner, double balance) {
        BankAccount currentAccount = bankAccountFactory.createCurrentBankAccount(accountOwner, balance);
        this.bankAccounts.add(currentAccount);

        return currentAccount;
    }

    public BankAccount createSavingBankAccount(AccountOwner accountOwner, double balance) {
        BankAccount savingAccount = bankAccountFactory.createSavingBankAccount(accountOwner, balance);
        this.bankAccounts.add(savingAccount);

        return savingAccount;
    }

    public BankAccount createStudentBankAccount(AccountOwner accountOwner, double balance, String school) {
        BankAccount studentAccount = bankAccountFactory.createStudentBankAccount(accountOwner, balance, school);
        this.bankAccounts.add(studentAccount);

        return studentAccount;
    }

    public BankAccount createBusinessBankAccount(AccountOwner accountOwner, double balance) {
        BankAccount businessAccount = bankAccountFactory.createBusinessBankAccount(accountOwner, balance);
        this.bankAccounts.add(businessAccount);

        return businessAccount;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }
}
