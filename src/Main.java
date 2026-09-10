import accounts.BankAccount;
import accounts.CurrentAccount;
import accounts.StudentAccount;
import person.AccountOwner;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        AccountOwner accountOwner = new AccountOwner("Tomas", "Pesek");
        accountOwner.setLastName("Pokorny");

        BankAccount bankAccount = new CurrentAccount(accountOwner, "123", 500);
        BankAccount studentAccount = new StudentAccount(accountOwner, "123", 500, "Delta");

        List<BankAccount> bankAccounts = new ArrayList<>();
        bankAccounts.add(bankAccount);
        bankAccounts.add(studentAccount);


        for (BankAccount account: bankAccounts){

            if (account instanceof StudentAccount) {
                StudentAccount stdAccount = (StudentAccount) account;
                System.out.println("school: " + stdAccount.getSchoolName());
            }

            System.out.println("balance: " + account.getBalance());

        }


        printBalance(bankAccount);

        bankAccount.add(400);
        bankAccount.add(100);
        bankAccount.add(200);
        bankAccount.add(600);

        printBalance(bankAccount);

        bankAccount.sub(300);
        bankAccount.sub(100);
        bankAccount.sub(50);
        bankAccount.sub(400);

        printBalance(bankAccount);

    }

    private static void printBalance(BankAccount bankAccount) {
        System.out.println("balance: " + bankAccount.getBalance());
    }
}