import java.util.Scanner;

public class PasswordValidator {
    public static boolean validatePassword(String password) {
        boolean isValid = true;
        if (password == null || password.trim().isEmpty()) {
            System.out.println("Password cannot be empty.");
            return false;
        }
        if (password.length() < 8) {
            System.out.println("Too short. Password must be at least 8 characters long.");
            isValid = false;
        }
        boolean hasUppercase = false;
        boolean hasDigit = false;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            }
            if (Character.isDigit(ch)) {
                hasDigit = true;
            }
        }
        if (!hasUppercase) {
            System.out.println("Missing an uppercase letter.");
            isValid = false;
        }
        if (!hasDigit) {
            System.out.println("Missing a digit.");
            isValid = false;
        }
        return isValid;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String password;

        System.out.println("=== SafeLog Password Validator ===");

        while (true) {
            System.out.print("Enter your password: ");
            password = sc.nextLine();

            if (validatePassword(password)) {
                System.out.println("Password is valid. Access granted.");
                break;
            } else {
                System.out.println("Please try again.\n");
            }
        }
        sc.close();
    }
}