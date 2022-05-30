package com.RedditDataScraper;

import net.dean.jraw.models.*;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		CredResource cr = new CredResource(".idea/credentials.txt");
		MyRedditClient myRedditClient = new MyRedditClient(cr);

		MyJFormFrame mjFormFrame = new MyJFormFrame(myRedditClient);
		mjFormFrame.pack();

		List<SubredditSearchResult> javaref = myRedditClient.getMyclient().searchSubredditsByName("worldnews");
		System.out.println(javaref);
		if (javaref.isEmpty()) {
			System.out.println("No results found");
		}

		AllFilters allFilters = new AllFilters();

	}
}