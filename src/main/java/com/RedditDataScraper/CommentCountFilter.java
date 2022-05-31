package com.RedditDataScraper;

import net.dean.jraw.models.Submission;

public class CommentCountFilter implements Filter {
	private final int min;
	private final int max;

	public CommentCountFilter(int min) {
		this.min = min;
		this.max = -1;
	}

	public CommentCountFilter(int min, int max) {
		this.min = min;
		this.max = max;
	}

	@Override
	public boolean satisfies(Submission submission) {
		if (max == -1) {
			return submission.getCommentCount() >= min;
		} else {
			return submission.getCommentCount() >= min && submission.getCommentCount() <= max;
		}
	}
}
