package com.RedditDataScraper;

import java.io.FileNotFoundException;
import java.sql.*;

public class Main {

	public static void main(String[] args) {
		String filename = "Database/databaseLocation.txt";
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