package com.amoghmc.redditDataScraper;

import net.dean.jraw.models.Submission;

public class NoNsfwFilter implements Filter {

	@Override
	public boolean satisfies(Submission submission) {
		return !submission.isNsfw();
	}
}
