package com.RedditDataScraper;

import java.io.FileNotFoundException;
import java.sql.*;

public class Main {
	public static void main(String[] args) {
		String filename = "Database/databaseLocation.txt";

		String jdbc = "jdbc:sqlite:C:/Users/amogh/OneDrive/Documents/Java Projects/Sem_4/RedditDataScraper/Database/dataScraper";

		try {
			JFrameHandler jFrameHandler = new JFrameHandler(filename);
		}
		catch (FileNotFoundException e) {
			System.out.println("Incorrect file path");
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		/*
		LoginJFormFrame loginJFormFrame = new LoginJFormFrame(connection);
		loginJFormFrame.pack();

		MainJFormFrame mainJFormFrame = new MainJFormFrame(myRedditClient);
		mainJFormFrame.pack();

		 */

	}
}