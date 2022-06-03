package com.RedditDataScraper;

import java.io.FileNotFoundException;
import java.sql.*;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, SQLException {
		CredResource cr = new CredResource("Credentials/credentials.txt");
		MyRedditClient myRedditClient = new MyRedditClient(cr);

		String jdbc = "jdbc:sqlite:C:/Users/amogh/OneDrive/Documents/Java Projects/Sem_4/RedditDataScraper/Database/dataScraper";
		Connection connection = DriverManager.getConnection(jdbc);
		Statement preparedStatement = connection.createStatement();

		LoginJFormFrame loginJFormFrame = new LoginJFormFrame(connection);
		loginJFormFrame.pack();

		MainJFormFrame mjFormFrame = new MainJFormFrame(myRedditClient);
		mjFormFrame.pack();

		//Login login = new Login();
		//login.loginasd();

	}
}