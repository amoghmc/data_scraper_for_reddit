package com.RedditDataScraper;

import net.dean.jraw.models.Submission;

public class TrueFilter implements Filter {

	@Override
	public boolean satisfies(Submission s) {
		return true;
	}
}