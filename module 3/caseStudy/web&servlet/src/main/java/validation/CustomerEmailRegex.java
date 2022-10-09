package validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerEmailRegex {
    private static final String CUSTOMER_EMAIL_REGEX = "^[0-9a-zA-z]+@[0-9a-zA-z]+(\\.com)$";

    public CustomerEmailRegex() {};

    public static boolean validate(String customerEmail) {
        Pattern pattern = Pattern.compile(CUSTOMER_EMAIL_REGEX);
        Matcher matcher = pattern.matcher(customerEmail);

        return matcher.matches();
    }
}
