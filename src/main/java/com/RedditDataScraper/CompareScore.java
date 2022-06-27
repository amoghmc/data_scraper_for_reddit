package com.RedditDataScraper;

import net.dean.jraw.models.Submission;

import java.util.Comparator;

public class CompareScore implements Comparator<Submission> {
	// Sort by highest score
	public int compare(Submission sub1, Submission sub2) {
		int sub1Score = sub1.getScore();
		int sub2Score = sub2.getScore();
		return Integer.compare(sub1Score, sub2Score);
	}
}
