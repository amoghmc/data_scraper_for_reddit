package com.RedditDataScraper;

import java.io.FileNotFoundException;
import java.sql.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		String filename = "databaseLocation.txt";
		try {
			new JFrameHandler(filename);
		}
		catch (FileNotFoundException e) {
			throw e;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}
}