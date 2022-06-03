/*
 * Created by JFormDesigner on Wed Jun 01 20:43:27 IST 2022
 */

package com.RedditDataScraper;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import net.miginfocom.swing.*;
import org.apache.commons.lang3.StringUtils;
import org.sqlite.JDBC;

/**
 * @author unknown
 */
public class LoginJFormFrame extends JFrame {
	private Connection connection;
	public LoginJFormFrame(Connection connection) {
		this.connection = connection;
		initComponents();
	}

	private void login() {
		//String QUERY = "SELECT id, username, password FROM users";
		//ResultSet rs = statement.executeQuery(QUERY);
		//System.out.println("USER: " + rs.getInt("id"));
		if (usernameField.getText().strip().equals("") || String.valueOf(passwordField.getPassword()).equals("")) {
			errorLabel.setText("Username or password is empty");
		}
		else {
			String usernameQuery = "SELECT * from users where username = ? and password = ?";

			try (PreparedStatement selectUsername = connection.prepareStatement(usernameQuery)) {
				selectUsername.setString(1, usernameField.getText().strip());
				selectUsername.setString(2, String.valueOf(passwordField.getPassword()));
				//System.out.println(selectUsername);

				ResultSet resultSet = selectUsername.executeQuery();
				System.out.println("ID: " + resultSet.getInt("id"));
				this.dispose();
			}
			catch (SQLException e) {
				System.out.println("SQL State: " + e.getSQLState());
				System.out.println("Error Code: " + e.getErrorCode());
				System.out.println("Message: " + e.getMessage());
			}
			/*
			ResultSet resultSet;
			try {
				resultSet = statement.executeQuery(passwordQuery);
				System.out.println(resultSet.getInt("id") + "asdasd");
				resultSet.getString("username");
				if (!resultSet.next()) {
					errorLabel.setText("Invalid username or password");
					System.out.println("INVALID");
					//return;
				}
			} catch (SQLException e) {
				e.getMessage();
			}
			errorLabel.setText("WELCOME");
			//System.out.println("Invalid username or password");

			 */
		}
	}

	public JButton getLoginButton() {
		return loginButton;
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		welcomeLabel = new JLabel();
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
		contentPane.add(usernameField, "cell 8 1 17 2");

		//---- passwordLabel ----
		passwordLabel.setText("Password");
		contentPane.add(passwordLabel, "cell 2 4 5 2,alignx center,growx 0");
		contentPane.add(passwordField, "cell 8 4 17 2");

		//---- errorLabel ----
		errorLabel.setText("Username and/or password cannot be empty!");
		contentPane.add(errorLabel, "cell 3 6 22 1,alignx center,growx 0");

		//---- loginButton ----
		loginButton.setText("Login");
		loginButton.addActionListener(e -> login());
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
	private JLabel passwordLabel;
	private JPasswordField passwordField;
	private JLabel errorLabel;
	private JButton loginButton;
	private JButton registerButton;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
