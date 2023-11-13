/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.securityfundamentalstaba;

import java.util.Scanner;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author gavin
 */
    public class PasswordVerifier {

        private PasswordManager pManager;

        public PasswordVerifier(PasswordManager pManager) {
            this.pManager = pManager;
        }

        public String hashPassword(String password) {
            String salt = BCrypt.gensalt();
            return BCrypt.hashpw(password, salt);
        }

        public boolean verifyPassword(String inputPassword, String hashedPassword) {
            return BCrypt.checkpw(inputPassword, hashedPassword);
        }

        public String login(String username, String password) {
            String storedPassword = pManager.accountDB.get(username);

            if (storedPassword != null && verifyPassword(password, storedPassword)) {
                pManager.setLoggedInUser(username);
                return username;
            } else {
                return null;
            }
        }
    }
