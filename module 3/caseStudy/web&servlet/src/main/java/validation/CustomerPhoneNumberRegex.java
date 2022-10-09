package validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerPhoneNumberRegex {
    private static final String CUSTOMER_PHONE_NUMBER_REGEX = "^[+0]{0,2}(91)?[0-9]{10}$";

    public CustomerPhoneNumberRegex() {};

    public static boolean validate(String customerPhoneNumber) {
        Pattern pattern = Pattern.compile(CUSTOMER_PHONE_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(customerPhoneNumber);

        return matcher.matches();
    }
}
