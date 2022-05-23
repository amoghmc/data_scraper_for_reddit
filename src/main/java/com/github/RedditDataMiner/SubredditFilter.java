package com.github.RedditDataMiner;

import net.dean.jraw.models.Submission;

public class SubredditFilter implements Filter{
	private String sub;

	public SubredditFilter(String sub) {
		this.sub = sub;
	}

	@Override
	public boolean satisfies(Submission s) {
		if (s.getSubreddit().equals(sub)) {
			return true;
		}
		return false;
	}
}
