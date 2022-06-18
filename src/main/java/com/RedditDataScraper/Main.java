package com.RedditDataScraper;

import java.io.FileNotFoundException;
import java.sql.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		String filename = "Database/databaseLocation.txt";
		//CredResource cr = new CredResource();
		//MyRedditClient myRedditClient = new MyRedditClient(cr);
		try {
			new JFrameHandler(filename);
		}
		catch (FileNotFoundException e) {
			System.out.println("Incorrect file path");
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}
}