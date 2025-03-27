package com.mycompany.securityfundamentalstaba;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.security.Key;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;


public class UserHolder implements Serializable {
    private String userPassword;
    private ArrayList<PasswordHolder> savedPasswords;

    public UserHolder(String userPassword) {
        this.userPassword = userPassword;
        this.savedPasswords = new ArrayList<>();
    }

    // Getter Setter methods for the three values
    
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public ArrayList<PasswordHolder> getSavedPasswords() {
        return savedPasswords;
    }
    
    public PasswordHolder getSavedPassword(int index) {
        // Get the user password at a specified index
        return savedPasswords.get(index);
    }

    // Encrypt and add a given password holder(assumed decrypted) to this users array
    public void addSavedPassword(String password, PasswordHolder newPasswordHolder) {
        // Create a secret key from the decrypted user password
        Key passKey = generateKey(password);
        // Encrypt data in the password holder
        newPasswordHolder.encryptData(passKey);
        // Add the provided username and password to the user list
        this.savedPasswords.add(newPasswordHolder);
    } // End add saved Password
    
    // View saved passwords for a given user
    public List<String> getUserPasswords(String password) {
        List<String> savedPasswordsList = new ArrayList<>();
                
        // Create a secret key from the decrypted user password
        Key passKey = generateKey(password);
        
        // If the saved passwords array contains at least one valid entry
        if (savedPasswords != null && savedPasswords.size() >= 1) {
            // Iterate through extant passwords
            for (PasswordHolder p : savedPasswords) {
                // Add each valid holder to a printable list
                savedPasswordsList.add(p.decryptData(passKey));
            }
        } else {
            savedPasswordsList.add("No saved passwords for this user.");
        } // End if/else

        return savedPasswordsList;
    } // End Get User Passwords
    
    // Key Generation from external source
    private Key generateKey(String password) {
        try {
            // Use PBKDF2 for key derivation
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");

            // Random salt is higher security but this is more consistent
            KeySpec spec = new PBEKeySpec(password.toCharArray(), new byte[16], 10000, 256); // Item to spec, salt, iterations, bytes

            // Generate the secret key using PBKDF2
            SecretKey tmp = factory.generateSecret(spec);

            // Convert the key to an AES key
            return new SecretKeySpec(tmp.getEncoded(), "AES");
        } catch (Exception ex) {
            throw new RuntimeException("Failed to generate AES key from password", ex);
        }
    } // End generateKey
}
