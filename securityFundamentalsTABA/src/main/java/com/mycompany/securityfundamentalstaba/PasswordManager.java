/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.securityfundamentalstaba;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author gavin
 */

public class PasswordManager {
    final Map<String, String> accountDB = new HashMap<>();
    final Map<String, Map<String, String>> userPasswords = new HashMap<>();
    String loggedInUser = null; 
    private PasswordVerifier verifier;

    public PasswordManager(PasswordVerifier verifier) {
        this.verifier = verifier;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        scanner.close(); 
    }

    public void createAccount(String username, String password) {
    String hashedPassword = verifier.hashPassword(password);
    accountDB.put(username, hashedPassword);
    userPasswords.put(username, new HashMap<>());
    }

    public List<String> viewSavedPasswords(String username) {
    List<String> savedPasswordsList = new ArrayList<>();
    Map<String, String> savedPasswords = userPasswords.get(username);

    if (savedPasswords != null && !savedPasswords.isEmpty()) {
        for (Map.Entry<String, String> entry : savedPasswords.entrySet()) {
            savedPasswordsList.add("Username: " + entry.getKey() + ", Password: " + entry.getValue());
        }
    } else {
        savedPasswordsList.add("No saved passwords for this user.");
    }

    return savedPasswordsList;
    }

    public void addSavedUsernameAndPassword(String username, String savedUsername, String savedPassword) {
    Map<String, String> savedPasswords = userPasswords.get(username);
    savedPasswords.put(savedUsername, savedPassword);
    }

    public String getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(String username) {
        loggedInUser = username;
    }
}
