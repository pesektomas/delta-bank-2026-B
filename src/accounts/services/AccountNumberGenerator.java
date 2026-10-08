package accounts.services;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class AccountNumberGenerator {

    private static final int[] WEIGHTS = {6, 3, 7, 9, 10, 5, 8, 4, 2, 1};

    private final String bankCode;
    private final Random random = new Random();
    private final Set<String> issuedNumbers = new HashSet<>();

    public AccountNumberGenerator(String bankCode) {
        this.bankCode = bankCode;
    }

    public String generate() {
        String number;
        do {
            number = generateBaseNumber();
        } while (!issuedNumbers.add(number));

        return number + "/" + bankCode;
    }

    private String generateBaseNumber() {
        while (true) {
            int[] digits = new int[10];
            int sum = 0;

            for (int i = 0; i < 9; i++) {
                digits[i] = (i == 0) ? 1 + random.nextInt(9) : random.nextInt(10);
                sum += digits[i] * WEIGHTS[i];
            }

            int checkDigit = (11 - sum % 11) % 11;
            if (checkDigit == 10) {
                continue;
            }
            digits[9] = checkDigit;

            StringBuilder sb = new StringBuilder();
            for (int d : digits) {
                sb.append(d);
            }

            return sb.toString();
        }
    }

    public static boolean isValid(String number) {
        if (!number.matches("\\d{2,10}")) {
            return false;
        }
        String padded = String.format("%10s", number).replace(' ', '0');
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += (padded.charAt(i) - '0') * WEIGHTS[i];
        }

        return sum % 11 == 0;
    }
}
