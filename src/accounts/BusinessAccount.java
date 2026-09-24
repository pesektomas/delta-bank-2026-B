package accounts;

import person.AccountOwner;

public class BusinessAccount extends BankAccount {

    public BusinessAccount(AccountOwner accountOwner, String accountNumber) {
        super(accountOwner, accountNumber);
    }

}
