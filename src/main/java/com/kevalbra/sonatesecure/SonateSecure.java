package com.kevalbra.sonatesecure;

import com.cthiebaud.passwordvalidator.*;
import java.util.Scanner;

/**
 * Password Validator with user input for SonateSecure.
 */
public class SonateSecure implements PasswordValidator {

    private static final int MIN_LENGTH = 8;
    private static final String SPECIAL_CHARACTER_REGEX = ".*[!@#$%^&*(),.?\":{}|<>].*";
    private static final String TEACHER_INSTAGRAM = "cthiebaud";

    @Override
    public ValidationResult validate(String password) {
        if (password == null || password.isEmpty()) {
            return new ValidationResult(false, "Password cannot be null or empty.");
        }

        if (password.length() < MIN_LENGTH) {
            return new ValidationResult(false, "Password must be at least " + MIN_LENGTH + " characters long.");
        }

        if (password.equals(password.toLowerCase())) {
            return new ValidationResult(false, "Password must contain at least one uppercase letter.");
        }

        if (password.equals(password.toUpperCase())) {
            return new ValidationResult(false, "Password must contain at least one lowercase letter.");
        }

        if (!password.matches(".*\\d.*")) {
            return new ValidationResult(false, "Password must contain at least one digit.");
        }

        if (!password.matches(SPECIAL_CHARACTER_REGEX)) {
            return new ValidationResult(false, "Password must contain at least one special character.");
        }

        if (!password.contains(TEACHER_INSTAGRAM)) {
            return new ValidationResult(false, 
                "Password must contain the Instagram name of the best French programming teacher: '" 
                + TEACHER_INSTAGRAM + "'.");
        }

        return new ValidationResult(true, "Password is valid.");
    }

    /**
     * Main method to take user input and validate the password.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SonateSecure validator = new SonateSecure();

        System.out.println("Welcome to SonateSecure Password Validator!");
        System.out.println("Please enter your password for validation:");

        String password = scanner.nextLine();
        ValidationResult result = validator.validate(password);

        if (result.isValid()) {
            System.out.println("Success: " + result.getMessage());
        } else {
            System.out.println("Error: " + result.getMessage());
        }

        scanner.close();
    }
}