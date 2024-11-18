package com.kevalbra.sonatesecure;

import com.cthiebaud.passwordvalidator.*;


public class SonateSecure implements PasswordValidator {

    private static final int MIN_LENGTH = 8;
    private static final String SPECIAL_CHARACTER_REGEX = ".*[!@#$%^&*(),.?\":{}|<>].*";
    private static final String TEACHER_INSTAGRAM = "cthiebaud";

    public ValidationResult validate(String password) {
        
        if (password == null || password.isEmpty()) {
            return new ValidationResult(false, "Password cannot be null or empty.");
        }
        
        if (!password.contains(TEACHER_INSTAGRAM)) {
            return new ValidationResult(false, 
                "Password must contain the Instagram name of the best French programming teacher ;): '" 
                + TEACHER_INSTAGRAM + "'.");
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


        return new ValidationResult(true, "Password is valid.");
    }
}