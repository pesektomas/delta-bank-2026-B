package accounts;

import person.AccountOwner;

public class CurrentAccount extends BankAccount {

    public CurrentAccount(AccountOwner accountOwner) {
        super(accountOwner);
    }

    public CurrentAccount(AccountOwner accountOwner, double balance) {
        super(accountOwner, balance);
    }
}
