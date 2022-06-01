package com.RedditDataScraper;

import com.opencsv.CSVWriter;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class MyCsvWriter {
	private final MyJFormFrame myJFormFrame;
	private final JTextArea resultTextField;
	private final String[] header = {
			"ID",
			"Subreddit",
			"Score",
			"Comment Count",
			"Title",
			"URL",
			"Permalink",
			"NSFW?",
			"Spoiler?",
			"Date",
			"Time"
	};
	private String[] dateAndTime;

	private ArrayList<Integer> ids;
	private ArrayList<String> subreddits;
	private ArrayList<String> scores;
	private ArrayList<String> commentCounts;
	private ArrayList<String> titles;
	private ArrayList<String> urls;
	private ArrayList<String> permalinks;
	private ArrayList<String> nsfws;
	private ArrayList<String> spoilers;
	private ArrayList<String> dates;
	private ArrayList<String> times;
	private ArrayList<String[]> list;


	public MyCsvWriter(MyJFormFrame myJFormFrame) {
		this.myJFormFrame = myJFormFrame;
		resultTextField = myJFormFrame.getResultTextArea();
		list = new ArrayList<>();
		list.add(header);
		dateAndTime = new String[2];

		ids = new ArrayList<>();
		titles = new ArrayList<>();
		subreddits = new ArrayList<>();
		scores = new ArrayList<>();
		spoilers = new ArrayList<>();
		nsfws = new ArrayList<>();
		commentCounts = new ArrayList<>();
		dates = new ArrayList<>();
		times = new ArrayList<>();
		urls = new ArrayList<>();
		permalinks = new ArrayList<>();
	}

	public void createCsvData() {
		String resultFile = myJFormFrame.getResultTextArea().getText();
		// Source: https://stackoverflow.com/questions/454908/split-java-string-by-new-line
		String[] lines = resultFile.split("\\r?\\n");
		// End of source

		for (int i = 0; i < lines.length; i++) {
			if (!lines[i].equals("")) {
				addToArrayList(lines[i]);
			}
		}

		for (int i : ids) {
			String[] record = {
					String.valueOf(ids.get(i)),
					subreddits.get(i),
					scores.get(i),
					commentCounts.get(i),
					titles.get(i),
					urls.get(i),
					permalinks.get(i),
					nsfws.get(i),
					spoilers.get(i),
					dates.get(i),
					times.get(i)
			};
			list.add(record);
		}
		return;
	}

	private void addToArrayList(String line) {
		if (line.indexOf("Index") != -1) {
			ids.add(Integer.parseInt(line.replaceAll("Index:", "").strip()));
		}
		if (line.indexOf("Subreddit") != -1) {
			subreddits.add(line.replaceAll("Subreddit:", "").strip());
		}
		if (line.indexOf("Score") != -1) {
			scores.add((line.replaceAll("Score:", "").strip()));
		}
		if (line.indexOf("Comment Count") != -1) {
			commentCounts.add((line.replaceAll("Comment Count:", "").strip()));
		}
		if (line.indexOf("URL") != -1) {
			urls.add((line.replaceAll("URL:", "").strip()));
		}
		if (line.indexOf("Permalink") != -1) {
			permalinks.add((line.replaceAll("Permalink:", "").strip()));
		}
		if (line.indexOf("Title") != -1) {
			titles.add((line.replaceAll("Title:", "").strip()));
		}
		if (line.indexOf("NSFW") != -1) {
			nsfws.add((line.replaceAll("NSFW:", "").strip()));
		}
		if (line.indexOf("Spoiler") != -1) {
			spoilers.add((line.replaceAll("Spoiler:", "").strip()));
		}
		if (line.indexOf("Search at") != -1) {
			dateAndTime = line.replaceAll("Search at:", "").strip().split(" ");
			dates.add(dateAndTime[0]);
			times.add(dateAndTime[1]);
		}
		return;
	}

	// Source: https://www.geeksforgeeks.org/writing-a-csv-file-in-java-using-opencsv/
	public void writeCsvData(String filePath) {
		File file = new File(filePath);
		try {
			// create FileWriter object with file as parameter
			FileWriter outputfile = new FileWriter("Results/" + file + ".csv");

			// create CSVWriter object filewriter object as parameter
			CSVWriter writer = new CSVWriter(outputfile);

			for (String[] record : list) {
				writer.writeNext(record);
			}
			// closing writer connection
			writer.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		ids.clear();
	// End of source
	}

}