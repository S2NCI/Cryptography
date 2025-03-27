package com.mycompany.securityfundamentalstaba;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PasswordManagerGUI extends javax.swing.JFrame {
    // Declare variables
    public PasswordManager manager;
    public PasswordVerifier verifier;

    private Map<String, String> accountDB = new HashMap<>();
    private Map<String, Map<String, String>> userPasswords = new HashMap<>();
    
    // Initialise supporting classes
    public PasswordManagerGUI() {
        verifier = new PasswordVerifier();
        manager = new PasswordManager(verifier);
        verifier.setManager(manager);
        manager.run();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        createbtn = new javax.swing.JButton();
        loginBtn = new javax.swing.JButton();
        savedBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Password Manager");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                .addContainerGap())
        );

        createbtn.setText("Create an account");
        createbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createbtnActionPerformed(evt);
            }
        });

        loginBtn.setText("Login");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        savedBtn.setText("View Saved Passwords");
        savedBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savedBtnActionPerformed(evt);
            }
        });

        addBtn.setText("Add a username and password");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        logoutBtn.setText("Logout");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoutBtn)
                    .addComponent(addBtn)
                    .addComponent(savedBtn)
                    .addComponent(loginBtn)
                    .addComponent(createbtn))
                .addContainerGap(300, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(createbtn)
                .addGap(18, 18, 18)
                .addComponent(loginBtn)
                .addGap(18, 18, 18)
                .addComponent(savedBtn)
                .addGap(18, 18, 18)
                .addComponent(addBtn)
                .addGap(18, 18, 18)
                .addComponent(logoutBtn)
                .addContainerGap(200, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createbtnActionPerformed
        // Declare the user input fields
        JTextField usernameField = new JTextField(15);
        JTextField passwordField = new JTextField(15);

        // Build the user input box
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Username:"));
        myPanel.add(usernameField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Password:"));
        myPanel.add(passwordField);

        // Instantiate the input box
        int result = JOptionPane.showConfirmDialog(null, myPanel, "Please Enter Account Details", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String username = usernameField.getText();
            String password = passwordField.getText();
            
            // Make sure that the user inputs aren't forms of empty
            if (username != null && password != null && !username.trim().isEmpty() && !password.trim().isEmpty()) {
                if (manager.checkUserExists(username)) {
                    // This seems to skirt the line between functionality and a potential security weakness
                    JOptionPane.showMessageDialog(this, "User already exists.");
                } else {
                    // Insert hashed(encrypted) password into the account and password databases
                    manager.createAccount(username, password);
                    // Confirm and ask if the user wants to autologin
                    int dialogResult = JOptionPane.showConfirmDialog(this, "Account created successfully. Do you want to log in?", "Login Confirmation", JOptionPane.YES_NO_OPTION);
                    if (dialogResult == JOptionPane.YES_OPTION) verifier.login(username, password);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid input. Please try again.");
            }
        }
    }//GEN-LAST:event_createbtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        manager.saveDatabase();
        // End the program, simplest solution 
        // GUI is not a focus of the project
        System.exit(0);
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // Check that user is logged in to draw from
        if (manager != null && manager.getLoggedInUser() != null) {
            // Declare the user input fields
            JTextField locationField = new JTextField(15);
            JTextField usernameField = new JTextField(15);
            JTextField passwordField = new JTextField(15);

            // Build the user input box
            JPanel myPanel = new JPanel();
            myPanel.add(new JLabel("Application:"));
            myPanel.add(locationField);
            myPanel.add(Box.createHorizontalStrut(15)); // a spacer
            myPanel.add(new JLabel("Username:"));
            myPanel.add(usernameField);
            myPanel.add(Box.createHorizontalStrut(15)); // a spacer
            myPanel.add(new JLabel("Password:"));
            myPanel.add(passwordField);

            // Instantiate the input box
            int result = JOptionPane.showConfirmDialog(null, myPanel, "Please Enter Details to be Saved", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                String username = usernameField.getText();
                String password = passwordField.getText();
                String location = locationField.getText();

                // Make sure that the user inputs aren't forms of empty
                if (username != null && password != null  && location != null && !username.trim().isEmpty() && !password.trim().isEmpty() && !location.trim().isEmpty()) {
                    
                    manager.addSavedUsernameAndPassword(manager.getLoggedInUser(), username, password, location);

                    JOptionPane.showMessageDialog(this, "Details saved successfully.");
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid input. Please try again.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "You are not logged in.");
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void savedBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savedBtnActionPerformed
        JOptionPane.showMessageDialog(this, manager.viewSavedPasswords());
    }//GEN-LAST:event_savedBtnActionPerformed

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        // Ensure the user is not already logged in
        if (manager.loggedInUser == null) {
            // Declare the user input fields
            JTextField usernameField = new JTextField(15);
            JTextField passwordField = new JTextField(15);

            // Build the user input box
            JPanel myPanel = new JPanel();
            myPanel.add(new JLabel("Username:"));
            myPanel.add(usernameField);
            myPanel.add(Box.createHorizontalStrut(15)); // a spacer
            myPanel.add(new JLabel("Password:"));
            myPanel.add(passwordField);

            // Instantiate the input box
            int result = JOptionPane.showConfirmDialog(null, myPanel, "Please Enter your Login Details", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                String username = usernameField.getText();
                String password = passwordField.getText();

                // Make sure that the user inputs aren't forms of empty
                if (username != null && password != null && !username.trim().isEmpty() && !password.trim().isEmpty()) {
                    // Verify user details from input
                    String response = verifier.login(username, password);
                    // For security reasons any failure should not be explained in detail
                    JOptionPane.showMessageDialog(this, response);
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid input. Please try again.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "You are already logged in.");
        }
    }//GEN-LAST:event_loginBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PasswordManagerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PasswordManagerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PasswordManagerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PasswordManagerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PasswordManagerGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton createbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton loginBtn;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton savedBtn;
    // End of variables declaration//GEN-END:variables
}
