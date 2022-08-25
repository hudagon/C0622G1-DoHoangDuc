package bai_tap_them.bai_1.utils.validation.class_name_validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassNameValidate {
    private static final String CLASS_NAME_REGEX = "^[AC][0-9]{4}[GI]1$";

    public ClassNameValidate() {};

    public static boolean validate(String className) {
        Pattern pattern = Pattern.compile(CLASS_NAME_REGEX);
        Matcher matcher = pattern.matcher(className);

        return matcher.matches();
    }
}
