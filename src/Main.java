import accounts.*;
import person.AccountOwner;
import transfer.DepositTransferService;
import transfer.WithdrawTransferService;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        AccountOwner accountOwner = new AccountOwner("Tomas", "Pesek");
        accountOwner.setLastName("Pokorny");

        BankAccount bankAccount = new CurrentAccount(accountOwner, "123", 500);
        BankAccount studentAccount = new StudentAccount(accountOwner, "123", 500, "Delta");
        BankAccount savingAccount = new SavingAccount(accountOwner, "123");


        List<BankAccount> bankAccounts = new ArrayList<>();
        bankAccounts.add(bankAccount);
        bankAccounts.add(studentAccount);


        for (BankAccount account: bankAccounts){
            if (account instanceof InterestPoint) {
                ((InterestPoint)account).calculateInterest();
            }
        }

        for (BankAccount account: bankAccounts){

            if (account instanceof StudentAccount) {
                StudentAccount stdAccount = (StudentAccount) account;
                System.out.println("school: " + stdAccount.getSchoolName());
            }

            System.out.println("balance: " + account.getBalance());

        }


        printBalance(bankAccount);

        DepositTransferService depositTransferService = new DepositTransferService();
        depositTransferService.deposit(bankAccount, 400);
        depositTransferService.deposit(bankAccount, 100);
        depositTransferService.deposit(bankAccount, 200);
        depositTransferService.deposit(bankAccount, 600);

        printBalance(bankAccount);

        WithdrawTransferService withdrawTransferService = new WithdrawTransferService();

        withdrawTransferService.withdraw(bankAccount, 300);
        withdrawTransferService.withdraw(bankAccount, 300);

        withdrawTransferService.withdraw(bankAccount, 100);
        withdrawTransferService.withdraw(bankAccount, 50);
        withdrawTransferService.withdraw(bankAccount, 400);

        printBalance(bankAccount);

    }

    private static void printBalance(BankAccount bankAccount) {
        System.out.println("balance: " + bankAccount.getBalance());
    }
}