package com.mycompany.securityfundamentalstaba;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * @author x22179551 - Adam Cowan 
 * @author x21229317 - Dillon O’ Connor 
 * @author x22110275 - Eoin Wyse 
 * @author x21237336 - Gavin Kelly 
 * @author x21226695 - Kyle White 
 */

public class PasswordManager {
    // Declare variables
    final Map<String, String> accountDB = new HashMap<>();
    final Map<String, Map<String, PasswordHolder>> userPasswords = new HashMap<>();
    // Currently logged-in user
    String loggedInUser = null; 
    private PasswordVerifier verifier;

    // Constructor
    public PasswordManager(PasswordVerifier verifier) {
        this.verifier = verifier;
    }
   
    // Initialize and run the PasswordManager
    public void run() {
        // Create scanner for user input
        Scanner scanner = new Scanner(System.in);
        scanner.close(); 
    } // End Run

    // Create new account with provided details
    public void createAccount(String username, String password) {
        // Pass password to verifier object
        String hashedPassword = verifier.hashPassword(password);
        // Store returned value in the account database
        accountDB.put(username, hashedPassword);
        // Initialise a map to store saved passwords for this user
        userPasswords.put(username, new HashMap<>());
    } // End Create Account

    // View saved passwords for a given user
    public List<String> viewSavedPasswords(String username) {
        List<String> savedPasswordsList = new ArrayList<>();
        // Retrieve saved passwords for the specified username
        Map<String, PasswordHolder> savedPasswords = userPasswords.get(username);

        // Iterate through extant passwords
        if (savedPasswords != null && !savedPasswords.isEmpty()) {
            for (Map.Entry<String, PasswordHolder> entry : savedPasswords.entrySet()) {
                PasswordHolder data = entry.getValue();
                // Format data as a readable string
                savedPasswordsList.add("Username: " + data.getSavedUsername() + ", Password: " + data.getSavedPassword() + ", Location: " + data.getSavedLocation());
            }
        } else {
            savedPasswordsList.add("No saved passwords for this user.");
        }

        return savedPasswordsList;
    } // End View Saved Passwords

    // Add a saved username and password for a given user
    public void addSavedUsernameAndPassword(String username, String savedUsername, String savedPassword, String savedLocation) {
        // Retrieve saved passwords map for the specified username
        PasswordHolder userPasswordsInstance = new PasswordHolder(savedUsername, savedPassword, savedLocation);
        Map<String, PasswordHolder> savedPasswords = userPasswords.get(username);
        // Add the provided username and password to the retrieved map
        savedPasswords.put(savedUsername, userPasswordsInstance);
    } // End Add Saved Username and Password

    public String getLoggedInUser() {
        return loggedInUser;
    } // End Get Logged in User

    public void setLoggedInUser(String username) {
        loggedInUser = username;
    } // End Set Logged in User
}
