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

## Authors

Vincent

Markus

Kevin


## Installation

---

To install and run the project, follow these steps:

1. **Clone the repository**:
   First, clone the repository to your local machine using the following command:

   ```sh
   git clone https://github.com/athenaeum-brew/password-validator-impl.git
   cd password-validator-impl

   ```

2. **Install dependencies:**
   Ensure you have Maven installed. If not, you can download and install it from Maven's official website (https://maven.apache.org/download.cgi). Once Maven is installed, run the following command to install the project dependencies:

    ````sh
    mvn clean install
    ```

3. **Build the project:**
Compile and package the project using Maven:

    ````sh
    mvn package
    ```

4. **Run the application:**
After packaging, you can run the application using the following command: 

   ````sh
   java -jar password-validator-1.0.0-20241121.173543-6.jar target/password_validator-1.0-SNAPSHOT.jar
   ```

5. **Run the tests:**
To run the unit tests, use the following command:

   ```sh
   mvn test
   ````