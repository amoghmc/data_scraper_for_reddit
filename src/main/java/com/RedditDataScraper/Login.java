package com.RedditDataScraper;

import java.sql.*;

public class Login {
	public void loginasd() throws SQLException {
		String jdbc = "jdbc:sqlite:C:/Users/amogh/OneDrive/Documents/Java Projects/Sem_4/RedditDataScraper/Database/dataScraperDB";
		Connection connection = DriverManager.getConnection(jdbc);

		String QUERY = "SELECT id, username, passwordhash FROM users";
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(QUERY);
		System.out.println("USER: " + rs.getInt("id"));
	}
}
