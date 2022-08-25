package bai_tap_them.bai_1.utils.validation.name_validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameValidate {
    private static final String NAME_REGEX = "[A-Za-z ]{5,50}";

    public NameValidate() {};

    public static boolean validate(String name) {
        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(name);

        return matcher.matches();
    }
}
