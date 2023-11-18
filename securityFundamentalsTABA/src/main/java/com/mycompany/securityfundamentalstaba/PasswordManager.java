package com.mycompany.securityfundamentalstaba;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    private Map<String, UserHolder> accountDB = new HashMap<>();
    // Currently logged-in user
    public String loggedInUser = null; 
    public String loggedInPassword = null;
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
        
        loadDatabase();
        
        // Debug loaded accounts
        for (Map.Entry<String, UserHolder> account : accountDB.entrySet()) 
            System.out.println("Username: " + account.getKey() + ", Password: " + account.getValue().getUserPassword());
    } // End Run

    // Post-initialisation setter
    public void setManager(PasswordVerifier pVerifier) {
        this.verifier = pVerifier;
    } // End set manager
    
    // Load accountDB from file
    private void loadDatabase() {
        // Define file to check
        File file = new File("data.dat");
        // Check for extant data file and create a blank instance if not found
        if (file.exists()) {
            try {
                FileInputStream fis = new FileInputStream("data.dat");
                ObjectInputStream ois = new ObjectInputStream(fis); 
                // Extract the maps for user data and saved passwords from
                accountDB = (Map<String, UserHolder>) ois.readObject();
                System.out.println("ACCOUNTS LOADED");
                ois.close(); 
            } catch(Exception e) {
                System.out.println(e);
            }
        } else {
            saveDatabase();
            System.out.println("FILE NOT FOUND. NEW FILE CREATED");
        }
    } // End Load Tasks
    
    // Serialise and export the database to a file to keep between runtimes
    public void saveDatabase() {
        try {
            FileOutputStream fos = new FileOutputStream("data.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos); 
            oos.writeObject(accountDB);
            System.out.println("ACCOUNTS SAVED");
            oos.close(); 
        } catch (IOException e) {
            System.out.println(e);
        } 
    } // End Save Tasks
    
    // Create new account with provided details
    public void createAccount(String username, String password) {
        // Pass password to verifier object to hash
        String hashedPassword = verifier.hashPassword(password);
        UserHolder newUser = new UserHolder(hashedPassword);
        // Store returned value in the account database
        accountDB.put(username, newUser);
    } // End Create Account

    // View saved passwords for a given user
    public String viewSavedPasswords() {
        // Combine formatted details into a printable string
        List<String> savedPasswordsList = new ArrayList<>();
        
        // Retrieve saved passwords for the specified username
        UserHolder savedUser = accountDB.get(loggedInUser);

        if (savedUser != null) {
            savedPasswordsList.add("Saved passwords:");
            // Add every login for the user to the savedPasswords list
            savedPasswordsList.addAll(savedUser.getUserPasswords(loggedInPassword));
        } else {
            savedPasswordsList.add("Not Currently Logged In");
        }
        // Turn into one large string and return
        return String.join("\n", savedPasswordsList);
    } // End View Saved Passwords

    // Add a saved username and password for a given user
    public void addSavedUsernameAndPassword(String username, String savedUsername, String savedPassword, String savedLocation) {
        // Retrieve saved passwords map for the specified username
        UserHolder savedUser = accountDB.get(username);

        if (savedUser != null) {
            // Create a new password storage instance
            PasswordHolder userPasswordsInstance = new PasswordHolder(savedUsername, savedPassword, savedLocation);
            // Encrypt the data for storage using the key(user password)
            savedUser.addSavedPassword(loggedInPassword, userPasswordsInstance);
        } else {
            System.out.println("FAILED TO FIND USER");
        }
    } // End Add Saved Username and Password

    public String getLoggedInUser() {
        return loggedInUser;
    } // End Get Logged in User

    public void setLoggedInUser(String username) {
        loggedInUser = username;
    } // End Set Logged in User

    public String getLoggedInPassword() {
        return loggedInPassword;
    } // End Get Logged in Password

    public void setLoggedInPassword(String loggedInPassword) {
        this.loggedInPassword = loggedInPassword;
    } // End Set Logged in Password

    // Retrieve the userholder stored password for a given account database hashset user
    public String getUserPassword(String username) {
        return accountDB.get(username).getUserPassword();
    } // End get User Password
}
