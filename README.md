# SonateSecure

SonateSecure: A Custom Password Validator
SonateSecure is a Java implementation of the PasswordValidator interface, enforcing strong password policies with a fun twist. It validates passwords against the following rules:

Must contain at least 8 characters.
<br>
Includes at least one uppercase and one lowercase letter.
<br>
Contains at least one digit and one special character (e.g., ```!@#$%^&*()```).
<br>
Must include the Instagram handle of the "best French programming teacher": ```cthiebaud```.

The validate method returns a ValidationResult indicating whether the password is valid, along with a message for invalid cases.

