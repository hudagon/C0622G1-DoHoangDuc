package ss18_string_regex.practice.validate_account;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountExample {
    private static final String ACCOUNT_REGEX = "[a-z_0-9]{6,}";

    public AccountExample() {};

    public boolean accountValidate(String acount) {
        Pattern pattern = Pattern.compile(ACCOUNT_REGEX);
        Matcher matcher = pattern.matcher(acount);
        return matcher.matches();
    }
}
