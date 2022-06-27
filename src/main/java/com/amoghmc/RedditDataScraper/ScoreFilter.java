package com.amoghmc.RedditDataScraper;

import net.dean.jraw.models.Submission;

public class ScoreFilter implements Filter {
	private final int min;
	private final int max;

	public ScoreFilter(int min) {
		this.min = min;
		this.max = -1;
	}

	public ScoreFilter(int min, int max) {
		this.min = min;
		this.max = max;
	}

	@Override
	// Return true if submission satisfies min (and max) score
	public boolean satisfies(Submission submission) {
		if (max == -1) {
			return submission.getScore() >= min;
		} else {
			return submission.getScore() >= min && submission.getScore() <= max;
		}
	}
}
