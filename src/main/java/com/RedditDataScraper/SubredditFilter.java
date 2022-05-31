package com.RedditDataScraper;

import net.dean.jraw.models.Submission;

public class SubredditFilter implements Filter {
	private final String[] subreddits;

	public SubredditFilter(String[] subreddits) {
		this.subreddits = subreddits;
	}

	@Override
	public boolean satisfies(Submission submission) {
		for (String subreddit : subreddits) {
			if (submission.getSubreddit().equals(subreddit.toLowerCase())) {
				return true;
			}
		}
		return false;
	}
}
