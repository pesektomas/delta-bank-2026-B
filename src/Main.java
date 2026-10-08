import accounts.*;
import accounts.serialization.BankAccountGsonSerializer;
import accounts.serialization.BankAccountJsonSerializer;
import accounts.serialization.BankAccountSerializer;
import accounts.serialization.BankAccountXmlSerializer;
import accounts.services.BankAccountService;
import person.AccountOwner;
import person.factories.AccountOwnerFactory;
import person.services.AccountOwnerService;
import transfer.DepositTransferService;
import transfer.WithdrawTransferService;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        AccountOwnerService accountOwnerService = new AccountOwnerService();
        BankAccountService bankAccountService = new BankAccountService();

        AccountOwner accountOwner = accountOwnerService.createAccountOwner("Tomas", "Pesek");

        BankAccount bankAccount = bankAccountService.createCurrentBankAccount(accountOwner, 500);
        BankAccount studentAccount = bankAccountService.createStudentBankAccount(accountOwner, 500, "Delta");
        BankAccount savingAccount = bankAccountService.createSavingBankAccount(accountOwner, 500);
        BankAccount businessAccount = bankAccountService.createBusinessBankAccount(accountOwner, 500);

        BankAccountSerializer bankAccountJsonSerializer = new BankAccountGsonSerializer();
        BankAccountSerializer bankAccountXmlSerializer = new BankAccountXmlSerializer();

        String bankAccountXml = bankAccountXmlSerializer.serialize(bankAccount);
        String bankAccountXmlAll = bankAccountXmlSerializer.serializeAll(bankAccountService.getBankAccounts());

        String bankAccountJson = bankAccountJsonSerializer.serialize(bankAccount);
        String bankAccountJsonAll = bankAccountJsonSerializer.serializeAll(bankAccountService.getBankAccounts());

        System.out.println(bankAccountXml);
        System.out.println(bankAccountXmlAll);

        System.out.println(bankAccountJson);
        System.out.println(bankAccountJsonAll);


        for (BankAccount account: bankAccountService.getBankAccounts()){
            if (account instanceof InterestPoint) {
                ((InterestPoint)account).calculateInterest();
            }
        }

        for (BankAccount account: bankAccountService.getBankAccounts()){

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