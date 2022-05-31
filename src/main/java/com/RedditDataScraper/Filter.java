package com.RedditDataScraper;

import net.dean.jraw.models.Submission;

public interface Filter {
	public boolean satisfies(Submission submission);
}
