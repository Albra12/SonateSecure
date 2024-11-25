package com.kevalbra;

import com.kevalbra.sonatesecure.*;
import com.cthiebaud.passwordvalidator.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SonateSecureTest {

    private static SonateSecure validator;

    @BeforeAll
    public static void setup() {
        validator = new SonateSecure();
    }

    @Test
    public void testNullPassword() {
        ValidationResult result = validator.validate(null);
        assertFalse(result.isValid());
        assertEquals("Password cannot be null or empty.", result.message());
    }

    @Test
    public void testEmptyPassword() {
        ValidationResult result = validator.validate("");
        assertFalse(result.isValid());
        assertEquals("Password cannot be null or empty.", result.message());
    }

    @Test
    public void testMissingTeacherInstagram() {
        ValidationResult result = validator.validate("Valid1!Pass");
        assertFalse(result.isValid());
        assertTrue(result.message().contains("cthiebaud"));
    }

    @Test
    public void testShortPassword() {
        ValidationResult result = validator.validate("cthie1!");
        assertFalse(result.isValid());
        assertEquals("Password must be at least 8 characters long.", result.message());
    }

    @Test
    public void testMissingUppercase() {
        ValidationResult result = validator.validate("cthiebaud1!");
        assertFalse(result.isValid());
        assertEquals("Password must contain at least one uppercase letter.", result.message());
    }

    @Test
    public void testMissingLowercase() {
        ValidationResult result = validator.validate("CTHIEBAUD1!");
        assertFalse(result.isValid());
        assertEquals("Password must contain at least one lowercase letter.", result.message());
    }

    @Test
    public void testMissingDigit() {
        ValidationResult result = validator.validate("Cthiebaud!");
        assertFalse(result.isValid());
        assertEquals("Password must contain at least one digit.", result.message());
    }

    @Test
    public void testMissingSpecialCharacter() {
        ValidationResult result = validator.validate("Cthiebaud1");
        assertFalse(result.isValid());
        assertEquals("Password must contain at least one special character.", result.message());
    }

    public void testValidPassword() {
        String validPassword = "Cthiebaud1!";
    
        ValidationResult result = validator.validate(validPassword);
        assertTrue(result.isValid(), "Password should be valid.");
        assertEquals("Password is valid.", result.message());
    }
}