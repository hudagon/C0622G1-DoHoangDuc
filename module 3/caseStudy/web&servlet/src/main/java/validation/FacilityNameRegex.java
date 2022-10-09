package validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FacilityNameRegex {
    private static final String FACILITY_NAME_REGEX = "^[0-9A-Za-z]*(?: [A-Z][a-z]*)*$";

    public FacilityNameRegex() {};

    public static boolean validate(String facilityName) {
        Pattern pattern = Pattern.compile(FACILITY_NAME_REGEX);
        Matcher matcher = pattern.matcher(facilityName);

        return matcher.matches();
    }
}
