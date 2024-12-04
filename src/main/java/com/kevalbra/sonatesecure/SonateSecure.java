package com.kevalbra.sonatesecure;

import com.cthiebaud.passwordvalidator.*;

/**
 * This class implements the PasswordValidator interface and provides a custom password validation.
 * The password must meet several criteria: length, case, digits, special characters, and an Instagram name.
 */

public class SonateSecure implements PasswordValidator {

    private static final int MIN_LENGTH = 8; // Minimum password length
    private static final String SPECIAL_CHARACTER_REGEX = ".*[!@#$%^&*(),.?\":{}|<>].*"; // Special character regex
    private static final String TEACHER_INSTAGRAM = "cthiebaud"; // Special character regex

     /**
     * Validates a given password based on predefined criteria.
     * 
     * @param password the password to validate
     * @return a ValidationResult object indicating whether the password is valid or not.
     */

    public ValidationResult validate(String password) {
        if (password == null || password.isEmpty()) {
            return new ValidationResult(false, "Password cannot be null or empty.");
        }
        
        // Check if password meets the minimum length of 8 charakters
        if (password.length() < MIN_LENGTH) {
            System.out.println("Password failed length check.");
            return new ValidationResult(false, "Password must be at least " + MIN_LENGTH + " characters long.");
        }
    
        // Check if password contains at least one uppercase letter
        if (password.equals(password.toLowerCase())) {
            return new ValidationResult(false, "Password must contain at least one uppercase letter.");
        }
    
        // Check if password contains at least one lowercase letter
        if (password.equals(password.toUpperCase())) {
            return new ValidationResult(false, "Password must contain at least one lowercase letter.");
        }
    
        // Check if password contains at least one digit
        if (!password.matches(".*\\d.*")) {
            return new ValidationResult(false, "Password must contain at least one digit.");
        }
    
        // Check if password contains at least one special character
        if (!password.matches(SPECIAL_CHARACTER_REGEX)) {
            return new ValidationResult(false, "Password must contain at least one special character.");
        }
    
        // Check if password contains the teacher's Instagram name
        if (!password.contains(TEACHER_INSTAGRAM)) {
            return new ValidationResult(false, 
                "Password must contain the Instagram name of the best French programming teacher at the DHBW ;): '" 
                + TEACHER_INSTAGRAM + "'.");
        }
    
        // If all checks pass
        return new ValidationResult(true, "Password is valid.");
    }
    
}