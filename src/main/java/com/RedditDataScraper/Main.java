package com.RedditDataScraper;

import java.io.FileNotFoundException;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		CredResource cr = new CredResource();
		MyRedditClient myRedditClient = new MyRedditClient(cr);

		MyJFormFrame mjFormFrame = new MyJFormFrame(myRedditClient);
		mjFormFrame.pack();

	}
}