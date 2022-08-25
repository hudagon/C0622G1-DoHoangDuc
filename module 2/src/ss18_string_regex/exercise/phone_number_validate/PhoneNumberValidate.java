package ss18_string_regex.exercise.phone_number_validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidate {
    private static final String PHONE_NUMBER_REGEX = "[(][0-9]{2}[)][-][(]0[0-9]{9}[)]";

    public PhoneNumberValidate() {};

    public boolean validate(String className) {
        Pattern pattern = Pattern.compile(PHONE_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(className);

        return matcher.matches();
    }
}
