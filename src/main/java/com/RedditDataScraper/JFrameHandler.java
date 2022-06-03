package com.RedditDataScraper;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class JFrameHandler {
	private Connection connection;
	private String filename;

	public JFrameHandler(String filename) throws FileNotFoundException, SQLException {
		this.filename = filename;
		connection = DriverManager.getConnection(getDbLink());
		openLoginFrame();
	}

	public void openLoginFrame() {
		LoginJFormFrame loginJFormFrame = new LoginJFormFrame(connection, this);
		loginJFormFrame.pack();
	}

	public void openMainFrame(String clientId, String clientSecret, String username) {
		try {
			MyRedditClient myRedditClient = new MyRedditClient(clientId, clientSecret);
			MainJFormFrame mainJFormFrame = new MainJFormFrame(myRedditClient, username);
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

	public String getDbLink() throws FileNotFoundException {
		File file = new File(filename);
		Scanner scanner = new Scanner(file);
		return scanner.nextLine();
	}
}
