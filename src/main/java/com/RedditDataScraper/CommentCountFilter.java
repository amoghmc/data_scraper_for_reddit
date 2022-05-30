package com.RedditDataScraper;

import net.dean.jraw.models.Submission;

public class CommentCountFilter implements Filter{
	private int min, max;
	public CommentCountFilter(int min) {
		this.min = min;
		this.max = -1;
	}

	public CommentCountFilter(int min, int max) {
		this.min = min;
		this.max = max;
	}

	@Override
	public boolean satisfies(Submission s) {
		if (max == -1) {
			if (s.getCommentCount() >= min) {
				return true;
			}
			return false;
		}
		else {
			if (s.getCommentCount() >= min && s.getCommentCount() <= max) {
				return true;
			}
			return false;
		}
	}
}
