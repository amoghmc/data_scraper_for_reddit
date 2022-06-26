package com.RedditDataScraper;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JFrameHandler {
	private final Connection connection;

	public JFrameHandler(String db_path) throws FileNotFoundException, SQLException {
		connection = DriverManager.getConnection(db_path);
		openLoginFrame();
	}

	public void openLoginFrame() {
		LoginJFormFrame loginJFormFrame = new LoginJFormFrame(connection, this);
		loginJFormFrame.pack();
	}

	public void openMainFrame(String clientId, String clientSecret, String username) {
		try {
			MyRedditClient myRedditClient = new MyRedditClient(clientId, clientSecret);
			MainJFormFrame mainJFormFrame = new MainJFormFrame(myRedditClient, username, clientId);
			mainJFormFrame.pack();
		}
		catch (Exception e) {
			System.out.println("Invalid client ID or client secret");
		}
	}

	public void openRegisterFrame() {
	    RegisterJFormFrame registerFrame = new RegisterJFormFrame(connection, this);
		registerFrame.pack();
	}

}
