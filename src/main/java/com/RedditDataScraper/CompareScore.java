package com.RedditDataScraper;

import net.dean.jraw.models.Submission;

import java.util.Comparator;

public class CompareScore implements Comparator<Submission> {
	public int compare(Submission sub1, Submission sub2) {
		int sub1Score = sub1.getScore();
		int sub2Score = sub2.getScore();
		if (sub1Score == sub2Score)
			return 0;
		else if (sub1Score > sub2Score)
			return 1;
		else
			return -1;
	}
}
