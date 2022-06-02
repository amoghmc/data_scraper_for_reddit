/*
 * Created by JFormDesigner on Wed Jun 01 20:43:27 IST 2022
 */

package com.RedditDataScraper;

import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author unknown
 */
public class LoginJFormFrame extends JFrame {
	public LoginJFormFrame() {
		initComponents();
	}

	private void login() {
		if (usernameField.getText().equals("") || passwordField.getText().equals("")) {
			//errorLabel.setText("Username and/or Password is empty");
		}
		else {
			//errorLabel.setText("WELCOME");
		}
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		welcomeLabel = new JLabel();
		usernameLabel = new JLabel();
		usernameField = new JFormattedTextField();
		label1 = new JLabel();
		passwordLabel = new JLabel();
		passwordField = new JPasswordField();
		label2 = new JLabel();
		loginButton = new JButton();
		registerButton = new JButton();

		//======== this ========
		setTitle("Login");
		setVisible(true);
		setResizable(false);
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
			"[fill]"));

		//---- welcomeLabel ----
		welcomeLabel.setText("Enter your login details");
		contentPane.add(welcomeLabel, "cell 2 0 23 1,align center center,grow 0 0");

		//---- usernameLabel ----
		usernameLabel.setText("Username");
		contentPane.add(usernameLabel, "cell 2 1 5 2,alignx center,growx 0");
		contentPane.add(usernameField, "cell 7 1 18 2");

		//---- label1 ----
		label1.setText("Username cannot be empty!");
		contentPane.add(label1, "cell 3 3 22 1,alignx center,growx 0");

		//---- passwordLabel ----
		passwordLabel.setText("Password");
		contentPane.add(passwordLabel, "cell 2 4 5 2,alignx center,growx 0");
		contentPane.add(passwordField, "cell 7 4 18 2");

		//---- label2 ----
		label2.setText("Password cannot be empty!");
		contentPane.add(label2, "cell 3 6 22 1,alignx center,growx 0");

		//---- loginButton ----
		loginButton.setText("Login");
		contentPane.add(loginButton, "cell 2 7 9 2,alignx center,growx 0,width 200:200:200");

		//---- registerButton ----
		registerButton.setText("Register");
		contentPane.add(registerButton, "cell 16 7 9 2,alignx center,growx 0,width 200:200:200");
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JLabel welcomeLabel;
	private JLabel usernameLabel;
	private JFormattedTextField usernameField;
	private JLabel label1;
	private JLabel passwordLabel;
	private JPasswordField passwordField;
	private JLabel label2;
	private JButton loginButton;
	private JButton registerButton;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
