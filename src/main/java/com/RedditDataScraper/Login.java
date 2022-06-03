package com.RedditDataScraper;

import java.sql.*;

public class Login {
	public void loginasd() throws SQLException {
		String jdbc = "jdbc:sqlite:C:/Users/amogh/OneDrive/Documents/Java Projects/Sem_4/RedditDataScraper/Database/dataScraper";
		Connection connection = DriverManager.getConnection(jdbc);


		Statement stmt = connection.createStatement();
	}
}
