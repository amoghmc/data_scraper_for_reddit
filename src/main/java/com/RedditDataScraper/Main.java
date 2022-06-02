package com.RedditDataScraper;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, SQLException {
		CredResource cr = new CredResource("Credentials/credentials.txt");
		MyRedditClient myRedditClient = new MyRedditClient(cr);

		LoginJFormFrame loginJFormFrame = new LoginJFormFrame();
		loginJFormFrame.pack();

		MainJFormFrame mjFormFrame = new MainJFormFrame(myRedditClient);
		mjFormFrame.pack();

		Login login = new Login();
		login.loginasd();

	}
}