package com.amoghmc.redditDataScraper;

import net.dean.jraw.models.Submission;

public interface Filter {
	boolean satisfies(Submission submission);
}
