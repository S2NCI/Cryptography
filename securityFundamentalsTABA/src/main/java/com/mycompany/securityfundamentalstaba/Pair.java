package com.mycompany.securityfundamentalstaba;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/*
 * @author x22179551 - Adam Cowan 
 * @author x21229317 - Dillon O’ Connor 
 * @author x22110275 - Eoin Wyse 
 * @author x21237336 - Gavin Kelly 
 * @author x21226695 - Kyle White 
 */

public class Pair implements Serializable{
    // Declare variables
    private Map<String, String> accountDB = new HashMap<>();
    private Map<String, Map<String, PasswordHolder>> userPasswords;

    public Pair(Map<String, String> accountDB, Map<String, Map<String, PasswordHolder>> userPasswords) {
        this.userPasswords = userPasswords;
        this.accountDB = accountDB;
    }

    public Map<String, String> getAccountDB() {
        return accountDB;
    }

    public Map<String, Map<String, PasswordHolder>> getUserPasswords() {
        return userPasswords;
    }
    
}
