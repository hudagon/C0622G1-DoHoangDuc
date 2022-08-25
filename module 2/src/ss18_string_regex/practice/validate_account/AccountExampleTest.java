package ss18_string_regex.practice.validate_account;

public class AccountExampleTest {
    public static String[] validAccount = {"123abc_", "_abc123", "______", "123456","abcdefgh"};
    public static String[] invalidAccount = {".@", "12345", "1234_", "abcde"};

    public static void main(String[] args) {
        AccountExample accountExample = new AccountExample();

        for (String s : validAccount) {
            boolean isValid = accountExample.accountValidate(s);
            System.out.println(s + " is " + "isValid: " + isValid);
        }
        System.out.println("---------------------------------");
        for (String s : invalidAccount) {
            boolean isValid = accountExample.accountValidate(s);
            System.out.println(s + " is " + "isValid: " + isValid);
        }

    }
}
