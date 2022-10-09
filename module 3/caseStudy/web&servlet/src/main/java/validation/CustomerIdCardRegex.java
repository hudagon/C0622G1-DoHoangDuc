package validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerIdCardRegex {
    private static final String CUSTOMER_ID_CARD_REGEX = "^[0-9]{9,12}$";

    public CustomerIdCardRegex() {};

    public static boolean validate(String customerIdCard) {
        Pattern pattern = Pattern.compile(CUSTOMER_ID_CARD_REGEX);
        Matcher matcher = pattern.matcher(customerIdCard);

        return matcher.matches();
    }
}
