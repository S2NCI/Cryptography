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
    private Map<String, String> accountDB = new HashMap<>();
    private Map<String, Map<String, PasswordHolder>> userPasswords= new HashMap<>();
    // Currently logged-in user
    public String loggedInUser = null; 
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
    } // End Run

    // Post-initialisation setter
    public void setManager(PasswordVerifier pVerifier) {
        this.verifier = pVerifier;
    } // end set manager
    
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
                Pair loadData = (Pair) ois.readObject();
                userPasswords = loadData.getUserPasswords();
                accountDB = loadData.getAccountDB();
                System.out.println("ACCOUNTS LOADED");
                ois.close(); 
            } catch(Exception e) {
                System.out.println(e);
            }
        } else {
            userPasswords = new HashMap<>();
            System.out.println("FILE NOT FOUND. NEW FILE CREATED");
        }
    } // end Load Tasks
    
    // Serialise and export the database to a file to keep between runtimes
    public void saveDatabase() {
        try {
            FileOutputStream fos = new FileOutputStream("data.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos); 
            Pair saveData = new Pair(accountDB, userPasswords); 
            oos.writeObject(saveData);
            System.out.println("ACCOUNTS SAVED");
            oos.close(); 
        } catch (IOException e) {
            System.out.println(e);
        } 
    } // end Save Tasks
    
    // Create new account with provided details
    public void createAccount(String username, String password) {
        // Pass password to verifier object to hash
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
    
    public String getUser(String username) {
        return accountDB.get(username);
    }
}
