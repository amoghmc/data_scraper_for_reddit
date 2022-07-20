package com.amoghmc.RedditDataScraper;

import net.dean.jraw.models.Submission;

import java.util.Comparator;

public class CompareTitle implements Comparator<Submission> {
	public int compare(Submission sub1, Submission sub2) {
		return sub1.getTitle().compareTo(sub2.getTitle());
	}
}
