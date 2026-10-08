package accounts;

import person.AccountOwner;

public class StudentAccount extends BankAccount{

    private String schoolName;

    public StudentAccount(AccountOwner accountOwner, double balance, String schoolName) {
        super(accountOwner, balance);

        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }
}
