package com.github.RedditDataMiner;

import net.dean.jraw.models.Submission;

public class NoSpamFilter implements Filter{

	@Override
	public boolean satisfies(Submission s) {
		if (!s.isSpam()) {
			return true;
		}
		return false;
	}
}
