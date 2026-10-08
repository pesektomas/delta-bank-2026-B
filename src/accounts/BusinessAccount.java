package accounts;

import person.AccountOwner;

public class BusinessAccount extends BankAccount {

    public BusinessAccount(AccountOwner accountOwner, double balance) {
        super(accountOwner, balance);
    }
}
