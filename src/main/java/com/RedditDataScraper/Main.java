package com.RedditDataScraper;

import java.io.FileNotFoundException;
import java.sql.*;

public class Main {
	private static final String db_path = "jdbc:sqlite::resource:data_scraper";

	public static void main(String[] args) throws FileNotFoundException {
		try {
			new JFrameHandler(db_path);
		}
		catch (FileNotFoundException e) {
			throw e;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}
}