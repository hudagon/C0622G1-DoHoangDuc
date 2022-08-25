package ss18_string_regex.exercise.phone_number_validate;

public class Main {
    public static void main(String[] args) {
        PhoneNumberValidate phoneNumberValidate = new PhoneNumberValidate();
        String[] validPhoneNumbers = {"(84)-(0978489648)"};
        String[] inValidPhoneNumbers = {"(a8)-(22222222)"};

        for (String validPhoneNumber : validPhoneNumbers) {
            boolean isValid = phoneNumberValidate.validate(validPhoneNumber);
            System.out.println(validPhoneNumber + " is " + "isValid: " + isValid);
        }
        System.out.println("------------------------");
        for (String inValidPhoneNumber : inValidPhoneNumbers) {
            boolean isValid = phoneNumberValidate.validate(inValidPhoneNumber);
            System.out.println(inValidPhoneNumber + " is " + "isValid: " + isValid);
        }
    }
}
