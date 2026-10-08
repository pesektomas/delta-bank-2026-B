package accounts.factories;

import accounts.*;
import accounts.services.AccountNumberGenerator;
import person.AccountOwner;

import java.util.UUID;

public class BankAccountFactory {

    AccountNumberGenerator accountNumberGenerator = new AccountNumberGenerator("0800");

    public BankAccount createCurrentBankAccount(AccountOwner accountOwner, double balance) {
        BankAccount currentAccount = new CurrentAccount(accountOwner, balance);
        this.initBankAccount(currentAccount);

        return currentAccount;
    }

    public BankAccount createSavingBankAccount(AccountOwner accountOwner, double balance) {
        BankAccount savingAccount = new SavingAccount(accountOwner, balance);
        this.initBankAccount(savingAccount);

        return savingAccount;
    }

    public BankAccount createStudentBankAccount(AccountOwner accountOwner, double balance, String school) {
        BankAccount studentAccount = new StudentAccount(accountOwner, balance, school);
        this.initBankAccount(studentAccount);

        return studentAccount;
    }

    public BankAccount createBusinessBankAccount(AccountOwner accountOwner, double balance) {
        BankAccount businessAccount = new BusinessAccount(accountOwner, balance);
        this.initBankAccount(businessAccount);

        return businessAccount;
    }

    private void initBankAccount(BankAccount bankAccount) {
        bankAccount.setUuid(UUID.randomUUID().toString());
        bankAccount.setAccountNumber(accountNumberGenerator.generate());
    }

}
