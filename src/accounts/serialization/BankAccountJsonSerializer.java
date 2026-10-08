package accounts.serialization;

import accounts.BankAccount;

import java.util.List;

public class BankAccountJsonSerializer implements BankAccountSerializer {

    BankAccountSerializeFactory bankAccountSerializeFactory = new BankAccountSerializeFactory();

    public String serializeAll(List<BankAccount> bankAccounts) {
        StringBuilder builder = new StringBuilder();

        builder.append("[");

        int i = 0;
        for (BankAccount bankAccount : bankAccounts) {
            builder.append(this.serialize(bankAccount));
            i ++;

            if (i != bankAccounts.size()) {
                builder.append(",");
            }
        }
        builder.append("]");

        return builder.toString();
    }

    public String serialize(BankAccount bankAccount) {
        BankAccountSerialize bankAccountSerialize =
                bankAccountSerializeFactory.createBankAccountSerialize(bankAccount);

        StringBuilder builder = new StringBuilder();

        builder.append("{");
        builder.append("\"accountNumber\": ");
        builder.append("\"" + bankAccountSerialize.accountNumber + "\"");
        builder.append("}");

        return builder.toString();
    }
}
