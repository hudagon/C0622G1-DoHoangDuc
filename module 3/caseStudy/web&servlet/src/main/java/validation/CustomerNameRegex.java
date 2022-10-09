package validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerNameRegex {
    private static final String CUSTOMER_NAME_REGEX = "^[A-Za-z]*(?: [A-Z][a-z]*)*$";

    public CustomerNameRegex() {};

    public static boolean validate(String customerName) {
        Pattern pattern = Pattern.compile(CUSTOMER_NAME_REGEX);
        Matcher matcher = pattern.matcher(customerName);

        return matcher.matches();
    }
}
