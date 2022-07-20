/*
 * Created by JFormDesigner on Fri Jun 03 16:23:32 IST 2022
 */

package com.amoghmc.RedditDataScraper;

import javax.swing.*;
import net.miginfocom.swing.*;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.*;

/**
 * @author unknown
 */
public class RegisterJFormFrame extends JFrame {
	private final Connection connection;
	private final JFrameHandler jFrameHandler;
	public RegisterJFormFrame(Connection connection, JFrameHandler jFrameHandler) {
		this.connection = connection;
		this.jFrameHandler = jFrameHandler;
		initComponents();
	}

	private void login() {
		// Close this and open Login frame
		jFrameHandler.openLoginFrame();
		this.setVisible(false);
		this.dispose();
	}

	public JButton getLoginButton() {
		return loginButton;
	}

	private void register() {
		String username = usernameField.getText().strip();
		// DigestUtils code via https://stackoverflow.com/questions/30670123/java-hashing-password-doesnt-match
		String password = DigestUtils.sha256Hex(String.valueOf(passwordField.getPassword()));
		String confirmPassword = DigestUtils.sha256Hex(String.valueOf(confirmPasswordField.getPassword()));
		String clientid = clientIdField.getText().strip();
		String clientsecret = String.valueOf(clientSecretField.getPassword());

		if (username.equals("")
				|| password.equals("")
				|| confirmPassword.equals("")
				|| clientid.equals("")
				|| clientsecret.equals("")) {
			errorLabel.setText("Empty fields are not allowed!");
		}
		else if (!password.equals(confirmPassword)) {
			errorLabel.setText("Passwords don't match!");
		}
		else if (checkExistingUser()) {
			errorLabel.setText("User already exists!");
		}
		else if (checkInvalidCred(username, clientid, clientsecret)) {
			errorLabel.setText("Invalid client ID or client secret!");
		}
		else {
			String usernameUpdate = "INSERT INTO users (username, password, clientid, clientsecret) VALUES (?, ?, ?, ?)";

			try (PreparedStatement preparedStatement = connection.prepareStatement(usernameUpdate)) {
				preparedStatement.setString(1, username);
				preparedStatement.setString(2, password);
				preparedStatement.setString(3, clientid);
				preparedStatement.setString(4, clientsecret);

				preparedStatement.addBatch();
				preparedStatement.executeBatch();

				// Close this and open Main frame
				//jFrameHandler.openMainFrame(clientid, clientsecret, username);
				this.setVisible(false);
				this.dispose();
			}
			catch (SQLException e) {
				errorLabel.setText("Username or password invalid");
				System.out.println("SQL State: " + e.getSQLState());
				System.out.println("Error Code: " + e.getErrorCode());
				System.out.println("Message: " + e.getMessage() + "\n");
			}
		}
	}

	private boolean checkInvalidCred(String username, String clientid, String clientsecret) {
		try {
			MyRedditClient myRedditClient = new MyRedditClient(clientid, clientsecret);
			MainJFormFrame mainJFormFrame = new MainJFormFrame(myRedditClient, username, clientid);
			mainJFormFrame.pack();
			return false;
		}
		catch (Exception e) {
			return true;
		}
	}

	private boolean checkExistingUser() {
		String searchExistingUser = "Select * from users where username = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(searchExistingUser)){
			preparedStatement.setString(1, usernameField.getText().strip());
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.getInt("id");
			return true;
		}
		catch (SQLException e) {
			return false;
		}
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		this.setSize(500, 400);
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
		loginButton.setText("Login to an account");
		loginButton.addActionListener(e -> login());
		contentPane.add(loginButton, "cell 2 20 10 3,alignx left,growx 0,width 200:200:200");

		//---- registerButton ----
		registerButton.setText("Register");
		registerButton.addActionListener(e -> register());
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
