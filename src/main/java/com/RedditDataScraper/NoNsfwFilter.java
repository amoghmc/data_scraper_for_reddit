package com.RedditDataScraper;

import net.dean.jraw.models.Submission;

public class NoNsfwFilter implements Filter{

	@Override
	public boolean satisfies(Submission submission) {
		if (!submission.isNsfw()) {
			return true;
		}
		return false;
	}
}
