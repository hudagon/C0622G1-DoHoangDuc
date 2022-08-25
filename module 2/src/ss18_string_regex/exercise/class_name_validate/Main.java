package ss18_string_regex.exercise.class_name_validate;

public class Main {
    public static void main(String[] args) {
        ClassNameValidate classNameValidate = new ClassNameValidate();
        String[] validClassNames = {"C0622G", "C0123G", "C9999G"};
        String[] inValidClassNames = {"CC8777", "H3339H", "A00000L"};

        for (String validClassName : validClassNames) {
            boolean isValid = classNameValidate.validate(validClassName);
            System.out.println(validClassName + " is " + "isValid: " + isValid);
        }

        for (String inValidClassName : inValidClassNames) {
            boolean isValid = classNameValidate.validate(inValidClassName);
            System.out.println(inValidClassName + " is " + "isValid: " + isValid);
        }
    }
}
