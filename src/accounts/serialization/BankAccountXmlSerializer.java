package accounts.serialization;

import accounts.BankAccount;

import java.util.List;

public class BankAccountXmlSerializer {

    BankAccountSerializeFactory bankAccountSerializeFactory = new BankAccountSerializeFactory();


    public String serializeAll(List<BankAccount> bankAccounts) {
        StringBuilder builder = new StringBuilder();

        builder.append("<root>");
        for (BankAccount bankAccount : bankAccounts) {
            builder.append(this.serialize(bankAccount));
        }
        builder.append("</root>");

        return builder.toString();
    }

    public String serialize(BankAccount bankAccount) {
        BankAccountSerialize bankAccountSerialize =
                bankAccountSerializeFactory.createBankAccountSerialize(bankAccount);

        StringBuilder builder = new StringBuilder();

        builder.append("<bankAccountNumber>");
        builder.append(bankAccountSerialize.accountNumber);
        builder.append("</bankAccountNumber>");

        return builder.toString();
    }

}
