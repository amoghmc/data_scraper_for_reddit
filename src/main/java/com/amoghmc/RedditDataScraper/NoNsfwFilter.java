package com.amoghmc.RedditDataScraper;

import net.dean.jraw.models.Submission;

public class NoNsfwFilter implements Filter {

	@Override
	public boolean satisfies(Submission submission) {
		return !submission.isNsfw();
	}
}
