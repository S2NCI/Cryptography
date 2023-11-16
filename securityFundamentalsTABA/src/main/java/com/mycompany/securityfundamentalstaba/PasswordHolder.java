package com.mycompany.securityfundamentalstaba;

/*
 * @author x22179551 - Adam Cowan 
 * @author x21229317 - Dillon O’ Connor 
 * @author x22110275 - Eoin Wyse 
 * @author x21237336 - Gavin Kelly 
 * @author x21226695 - Kyle White 
 */

public class PasswordHolder {
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
}
