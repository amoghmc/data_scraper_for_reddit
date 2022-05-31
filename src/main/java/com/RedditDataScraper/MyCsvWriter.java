package com.RedditDataScraper;

import com.opencsv.CSVWriter;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyCsvWriter{
	private static int id = 0;
	private MyJFormFrame myJFormFrame;
	private JTextArea resultTextField;
	private String[] header = {
			"ID",
			"Subreddit",
			"Score",
			"Comment Count",
			"Title",
			"URL",
			"Permalink",
			"NSFW?",
			"Spoiler?",
			"",
			"Timestamp"
	};

	public MyCsvWriter(MyJFormFrame myJFormFrame) {
		this.myJFormFrame = myJFormFrame;
		resultTextField = myJFormFrame.getResultTextArea();
		id++;
		//List<String[]> csvData = createCsvData();
		// default all fields are enclosed in double quotes
		// default separator is a comma

		try (CSVWriter writer = new CSVWriter(new FileWriter("Results\\result" + id))) {
			//writer.writeAll(csvData);
		}
		catch (IOException e) {
			System.out.println("ERROR");
		}
	}

	private void createCsvData() {
		String result = myJFormFrame.getResultTextArea().getText();
		String[] record1 = {"1", "first name", "address 1", "11111"};
		String[] record2 = {"2", "second name", "address 2", "22222"};

		List<String[]> list = new ArrayList<>();
		list.add(header);
		list.add(record1);
		list.add(record2);

		//return list;
	}

}