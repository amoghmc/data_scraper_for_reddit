package com.amoghmc.redditDataScraper;

import net.dean.jraw.models.Submission;

public class NoSpoilerFilter implements Filter {

	@Override
	public boolean satisfies(Submission submission) {
		return !submission.isSpoiler();
	}
}
