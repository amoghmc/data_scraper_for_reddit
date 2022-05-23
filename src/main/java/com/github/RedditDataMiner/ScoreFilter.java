package com.github.RedditDataMiner;

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
	public boolean satisfies(Submission s) {
		if (max == -1) {
			if (s.getScore() >= min) {
				return true;
			}
			return false;
		}
		else {
			if (s.getScore() >= min && s.getScore() <= max) {
				return true;
			}
			return false;
		}
	}
}
