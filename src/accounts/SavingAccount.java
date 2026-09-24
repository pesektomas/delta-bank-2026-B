package accounts;

import person.AccountOwner;

public class SavingAccount extends BankAccount implements InterestPoint {
    private static final float INTEREST_RATE = 0.05f;

    public SavingAccount(AccountOwner accountOwner, String accountNumber) {
        super(accountOwner, accountNumber);
    }

    @Override
    public void calculateInterest() {
        double interest = getBalance() * INTEREST_RATE;
        double newBalance = getBalance() + interest;

        super.setBalance(newBalance);
    }
}
