/*
 * Created by JFormDesigner on Fri Jun 03 16:23:32 IST 2022
 */

package com.RedditDataScraper;

import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author unknown
 */
public class RegisterJFormFrame extends JFrame {
	public RegisterJFormFrame() {
		initComponents();
	}

	private void login() {
		// TODO add your code here
	}

	public JButton getLoginButton() {
		return loginButton;
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		usernameLabel = new JLabel();
		usernameField = new JFormattedTextField();
		passwordLabel = new JLabel();
		passwordField = new JPasswordField();
		confirmPasswordLabel = new JLabel();
		confirmPasswordField = new JPasswordField();
		clientIdLabel = new JLabel();
		clientIdField = new JFormattedTextField();
		clientSecretLabel = new JLabel();
		clientSecretField = new JPasswordField();
		errorLabel = new JLabel();
		loginButton = new JButton();
		registerButton = new JButton();

		//======== this ========
		setTitle("Register");
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		var contentPane = getContentPane();
		contentPane.setLayout(new MigLayout(
			"fill,hidemode 3,gap 5 8",
			// columns
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]",
			// rows
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]"));

		//---- usernameLabel ----
		usernameLabel.setText("Username");
		contentPane.add(usernameLabel, "cell 2 2 7 2,alignx center,growx 0");
		contentPane.add(usernameField, "cell 10 2 18 2");

		//---- passwordLabel ----
		passwordLabel.setText("Password");
		contentPane.add(passwordLabel, "cell 2 5 7 2,alignx center,growx 0");
		contentPane.add(passwordField, "cell 10 5 18 2");

		//---- confirmPasswordLabel ----
		confirmPasswordLabel.setText("Confirm \nPassword");
		contentPane.add(confirmPasswordLabel, "cell 2 8 7 2,alignx center,growx 0");
		contentPane.add(confirmPasswordField, "cell 10 8 18 2");

		//---- clientIdLabel ----
		clientIdLabel.setText("Client ID");
		contentPane.add(clientIdLabel, "cell 2 11 7 2,alignx center,growx 0");
		contentPane.add(clientIdField, "cell 10 11 18 2");

		//---- clientSecretLabel ----
		clientSecretLabel.setText("Client Secret");
		contentPane.add(clientSecretLabel, "cell 2 14 7 2,alignx center,growx 0");
		contentPane.add(clientSecretField, "cell 10 14 18 2");
		contentPane.add(errorLabel, "cell 2 17 26 2,alignx center,growx 0");

		//---- loginButton ----
		loginButton.setText("Login");
		loginButton.addActionListener(e -> login());
		contentPane.add(loginButton, "cell 2 20 10 3,alignx left,growx 0,width 200:200:200");

		//---- registerButton ----
		registerButton.setText("Register");
		contentPane.add(registerButton, "cell 18 20 10 3,alignx right,growx 0,width 200:200:200");
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JLabel usernameLabel;
	private JFormattedTextField usernameField;
	private JLabel passwordLabel;
	private JPasswordField passwordField;
	private JLabel confirmPasswordLabel;
	private JPasswordField confirmPasswordField;
	private JLabel clientIdLabel;
	private JFormattedTextField clientIdField;
	private JLabel clientSecretLabel;
	private JPasswordField clientSecretField;
	private JLabel errorLabel;
	private JButton loginButton;
	private JButton registerButton;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
