package com.github.RedditDataMiner;

import net.dean.jraw.models.Submission;

public interface Filter {
	public boolean satisfies(Submission s);
}
