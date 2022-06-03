/*
 * Created by JFormDesigner on Wed Jun 01 20:43:27 IST 2022
 */

package com.RedditDataScraper;

import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author unknown
 */
public class LoginJFormFrame extends JFrame {
	private Connection connection;
	private JFrameHandler jFrameHandler;

	public LoginJFormFrame(Connection connection, JFrameHandler jFrameHandler) {
		this.connection = connection;
		this.jFrameHandler = jFrameHandler;
		initComponents();
	}

	private void login() {
		if (usernameField.getText().strip().equals("") || String.valueOf(passwordField.getPassword()).equals("")) {
			errorLabel.setText("Username or password is empty!");
		}
		else {
			String usernameQuery = "SELECT * from users where username = ? and password = ?";

			try (PreparedStatement preparedStatement = connection.prepareStatement(usernameQuery)) {
				preparedStatement.setString(1, usernameField.getText().strip());
				preparedStatement.setString(2, String.valueOf(passwordField.getPassword()));

				ResultSet resultSet = preparedStatement.executeQuery();
				System.out.println("ID: " + resultSet.getInt("id"));

				// Close this and open Main frame
				jFrameHandler.openMainFrame(resultSet.getString("clientid"),
						resultSet.getString("clientsecret"),
						resultSet.getString("username"));
				this.setVisible(false);
				this.dispose();
			}
			catch (SQLException e) {
				errorLabel.setText("Username or password invalid!");
				System.out.println("SQL State: " + e.getSQLState());
				System.out.println("Error Code: " + e.getErrorCode());
				System.out.println("Message: " + e.getMessage() + "\n");
			}
		}
	}

	public JButton getLoginButton() {
		return loginButton;
	}

	private void register() {
		// Close this and open Register frame
		jFrameHandler.openRegisterFrame();
		this.setVisible(false);
		this.dispose();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		usernameLabel = new JLabel();
		usernameField = new JFormattedTextField();
		passwordLabel = new JLabel();
		passwordField = new JPasswordField();
		errorLabel = new JLabel();
		loginButton = new JButton();
		registerButton = new JButton();

		//======== this ========
		setTitle("Login");
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
			"[fill]" +
			"[fill]"));

		//---- usernameLabel ----
		usernameLabel.setText("Username");
		contentPane.add(usernameLabel, "cell 2 2 5 2,alignx center,growx 0");
		contentPane.add(usernameField, "cell 8 2 17 2");

		//---- passwordLabel ----
		passwordLabel.setText("Password");
		contentPane.add(passwordLabel, "cell 2 5 5 2,alignx center,growx 0");
		contentPane.add(passwordField, "cell 8 5 17 2");
		contentPane.add(errorLabel, "cell 2 8 23 2,alignx center,growx 0");

		//---- loginButton ----
		loginButton.setText("Login");
		loginButton.addActionListener(e -> login());
		contentPane.add(loginButton, "cell 2 11 9 2,alignx left,growx 0,width 200:200:200");

		//---- registerButton ----
		registerButton.setText("Register a new account");
		registerButton.addActionListener(e -> register());
		contentPane.add(registerButton, "cell 16 11 9 2,alignx right,growx 0,width 200:200:200");
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JLabel usernameLabel;
	private JFormattedTextField usernameField;
	private JLabel passwordLabel;
	private JPasswordField passwordField;
	private JLabel errorLabel;
	private JButton loginButton;
	private JButton registerButton;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
