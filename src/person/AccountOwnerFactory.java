package person;

import java.util.UUID;

public class AccountOwnerFactory {

    public AccountOwner createAccountOwner(String name, String lastName)
    {
        String uuid = UUID.randomUUID().toString();

        return new AccountOwner(uuid, name, lastName);
    }
}
