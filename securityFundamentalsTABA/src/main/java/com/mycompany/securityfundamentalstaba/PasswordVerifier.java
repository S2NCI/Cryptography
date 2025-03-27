package com.mycompany.securityfundamentalstaba;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordVerifier {
    // Declare variables
    private PasswordManager pManager;

    // Constructor
    public PasswordVerifier() {
        
    } // End PasswordVerifier
    
    // Post-initialisation setter
    public void setManager(PasswordManager pManager) {
        this.pManager = pManager;
    } // end set manager
    
    // Hash a given password using BCrypt
    public String hashPassword(String password) {
        String salt = BCrypt.gensalt();
        return BCrypt.hashpw(password, salt);
    } // End Hash Password

    // Verify a given input password against a hashed password using BCrypt
    public boolean verifyPassword(String inputPassword, String hashedPassword) {
        return BCrypt.checkpw(inputPassword, hashedPassword);
    } // End Verify Password

    // Perform login by checking the provided username and password
    public String login(String username, String password) {
        try {
            // Retrieve the stored hashed password from the account database
            String storedPassword = pManager.getUserPassword(username);

            // Check if the stored password is not null and matches the provided password
            if (storedPassword != null && verifyPassword(password, storedPassword)) {
                // Set the logged in user in the PasswordManager class and return if successful
                pManager.setLoggedInUser(username);
                pManager.setLoggedInPassword(password);
                return "Login successful!";
            } else {
                return "Login failed :(";
            }
        } catch (Exception ex) {
            // No need to log, it's because the user doesn't exist
            return "Login failed :(";
        }
    } // End Login
} // End Class
