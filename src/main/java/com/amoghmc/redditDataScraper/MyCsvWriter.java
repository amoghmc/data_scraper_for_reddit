package com.amoghmc.redditDataScraper;

import com.opencsv.CSVWriter;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MyCsvWriter {
	private final MainJFormFrame mainJFormFrame;
	private String[] dateAndTime;

	private final ArrayList<Integer> ids;
	private final ArrayList<String> subreddits;
	private final ArrayList<String> scores;
	private final ArrayList<String> commentCounts;
	private final ArrayList<String> titles;
	private final ArrayList<String> urls;
	private final ArrayList<String> permalinks;
	private final ArrayList<String> nsfws;
	private final ArrayList<String> spoilers;
	private final ArrayList<String> dates;
	private final ArrayList<String> times;
	private final ArrayList<String[]> list;
	private final SimpleDateFormat dateFormatter;


	public MyCsvWriter(MainJFormFrame mainJFormFrame) {
		this.mainJFormFrame = mainJFormFrame;
		JTextArea resultTextField = mainJFormFrame.getResultTextArea();
		list = new ArrayList<>();
		String[] header = {
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
		list.add(header);
		dateFormatter = new SimpleDateFormat("d MMM yyyy, hh-mm-ss");
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
		String resultFile = mainJFormFrame.getResultTextArea().getText();
		// Source: https://stackoverflow.com/questions/454908/split-java-string-by-new-line
		String[] lines = resultFile.split("\\r?\\n");
		// End of source

		for (String line : lines) {
			if (!line.equals("")) {
				addToArrayList(line);
			}
		}

		for (int i : ids) {
			String[] record = {
					String.valueOf(ids.get(i) + 1),
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
	}

	private void addToArrayList(String line) {
		if (line.contains("Index")) {
			ids.add(Integer.parseInt(line.replaceAll("Index:", "").strip()) - 1);
		}
		if (line.contains("Subreddit")) {
			subreddits.add(line.replaceAll("Subreddit:", "").strip());
		}
		if (line.contains("Score")) {
			scores.add((line.replaceAll("Score:", "").strip()));
		}
		if (line.contains("Comment Count")) {
			commentCounts.add((line.replaceAll("Comment Count:", "").strip()));
		}
		if (line.contains("URL")) {
			urls.add((line.replaceAll("URL:", "").strip()));
		}
		if (line.contains("Permalink")) {
			permalinks.add((line.replaceAll("Permalink:", "").strip()));
		}
		if (line.contains("Title")) {
			titles.add((line.replaceAll("Title:", "").strip()));
		}
		if (line.contains("NSFW")) {
			nsfws.add((line.replaceAll("NSFW:", "").strip()));
		}
		if (line.contains("Spoiler")) {
			spoilers.add((line.replaceAll("Spoiler:", "").strip()));
		}
		if (line.contains("Search at")) {
			dateAndTime = line.replaceAll("Search at:", "").strip().split(",");
			dates.add(dateAndTime[0].strip());
			times.add(dateAndTime[1].strip());
		}
	}

	// Source: https://www.geeksforgeeks.org/writing-a-csv-file-in-java-using-opencsv/
	public void writeCsvData() {
		File file = new File("Results/" + dateFormatter.format(new Date()) + ".csv");
		if (list.size() > 1) {
			try {
				// check if Results directory exists,
				// create one if it doesn't
				if (!file.exists()) {
					new File("Results").mkdirs();
				}

				FileWriter outputfile = new FileWriter(file);
				CSVWriter writer = new CSVWriter(outputfile);

				// Write each record from list to csv file called writer
				for (String[] record : list) {
					writer.writeNext(record);
				}
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		ids.clear();
	// End of source
	}

}