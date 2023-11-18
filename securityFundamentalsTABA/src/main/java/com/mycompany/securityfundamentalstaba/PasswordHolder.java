package com.mycompany.securityfundamentalstaba;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import javax.crypto.Cipher;

/*
 * @author x22179551 - Adam Cowan 
 * @author x21229317 - Dillon O’ Connor 
 * @author x22110275 - Eoin Wyse 
 * @author x21237336 - Gavin Kelly 
 * @author x21226695 - Kyle White 
 */

public class PasswordHolder implements Serializable {
    private String savedUsername;
    private String savedPassword;
    private String savedLocation;

    public PasswordHolder(String savedUsername, String savedPassword, String savedLocation) {
        this.savedUsername = savedUsername;
        this.savedPassword = savedPassword;
        this.savedLocation = savedLocation;
    }

    // Getter methods for the three values

    public String getSavedUsername() {
        return savedUsername;
    }

    public String getSavedPassword() {
        return savedPassword;
    }

    public String getSavedLocation() {
        return savedLocation;
    }
    
    // Encrypt the class variables with a provided key
    public void encryptData(Key key) {
        // Encrypt all 3 based on the same parameter
        try {
            this.savedUsername = encrypt(savedUsername, key);
            this.savedPassword = encrypt(savedPassword, key);
            this.savedLocation = encrypt(savedLocation, key);
        } catch (Exception ex) {
            System.out.println(ex);
            System.out.println("FAILED TO ENCRYPT DATA");
        }
    } // End encrypt data
    
    // Decrypt and return the class variables with a provided key
    public String decryptData(Key key) {
        // Decrypt the user data based on a known key(true password)
        try {
            // debug print encrypted values for comparison
            System.out.println("Username: " + savedUsername + ", Password: " + savedPassword + ", Location: " + savedLocation);
            
            String exportUsername = decrypt(savedUsername, key);
            String exportPassword = decrypt(savedPassword, key);
            String exportLocation = decrypt(savedLocation, key);
            // return a user readable string of info for printout
            return "Username: " + exportUsername + ", Password: " + exportPassword + ", Location: " + exportLocation;
        } catch (Exception ex) {
            System.out.println(ex);
            return "FAILED TO DECRYPT";
        }
    } // End Decrypt data
    
    // Encrypt and decrypt methods from https://www.baeldung.com/java-aes-encryption-decryption
    private String encrypt(String plainText, Key secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    private String decrypt(String cipherText, Key secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decodedBytes = cipher.doFinal(Base64.getDecoder().decode(cipherText));
        return new String(decodedBytes, StandardCharsets.UTF_8);
    }// End encrypt and decrypt 
} // End Class
