package ss18_string_regex.practice.validate_email;

public class EmailExampleTest {
    public static final String[] validEmail = {"a@gmail.com", "ab@yahoo.com", "abc@hotmail.com"};
    public static final String[] invalidEmail = {"@gmail.com", "ab@gmail.", "@#@gmail.com.vn"};

    public static void main(String[] args) {
        EmailExample emailExample = new EmailExample();
        for (String s : validEmail) {
            boolean isValid = emailExample.validateEmail(s);
            System.out.println(s + " is" + " isValid: " + isValid);
        }

        for (String s : invalidEmail) {
            boolean isValid = emailExample.validateEmail(s);
            System.out.println(s + " is" + " isValid: " + isValid);
        }
    }
}
