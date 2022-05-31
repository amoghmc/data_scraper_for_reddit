package com.RedditDataScraper;

import net.dean.jraw.models.Submission;

public interface Filter {
	boolean satisfies(Submission submission);
}
