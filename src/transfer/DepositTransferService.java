package transfer;

import accounts.BankAccount;
import accounts.StudentAccount;

public class DepositTransferService {

    private static final double STUDENT_ACCOUNT_DEPOSIT_BONUS = 0.005;

    public void deposit(BankAccount bankAccount, double amount) {
        double newBalance = bankAccount.getBalance() + amount;

        if (bankAccount instanceof StudentAccount) {
            double depositBonus = amount * STUDENT_ACCOUNT_DEPOSIT_BONUS;

            newBalance += depositBonus;
        }

        bankAccount.setBalance(newBalance);
    }

}
