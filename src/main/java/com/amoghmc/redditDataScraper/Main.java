package com.amoghmc.redditDataScraper;

import java.sql.SQLException;

public class Main {
	private static final String db_path = "jdbc:sqlite::resource:data_scraper";

	public static void main(String[] args) {
		try {
			new JFrameHandler(db_path);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}
}