package com.RedditDataScraper;

import net.dean.jraw.models.Submission;

public class ScoreFilter implements Filter{
	private int min, max;
	public ScoreFilter(int min) {
		this.min = min;
		this.max = -1;
	}

	public ScoreFilter(int min, int max) {
		this.min = min;
		this.max = max;
	}

	@Override
	public boolean satisfies(Submission submission) {
		if (max == -1) {
			if (submission.getScore() >= min) {
				return true;
			}
			return false;
		}
		else {
			if (submission.getScore() >= min && submission.getScore() <= max) {
				return true;
			}
			return false;
		}
	}
}
