package com.github.RedditDataMiner;

import net.dean.jraw.models.Submission;

public class NoNsfwFilter implements Filter{

	@Override
	public boolean satisfies(Submission s) {
		if (!s.isNsfw()) {
			return true;
		}
		return false;
	}
}
