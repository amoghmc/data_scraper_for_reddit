package com.github.RedditDataMiner;

import net.dean.jraw.models.Submission;

import java.util.ArrayList;

public class KeywordFilter implements Filter{
	private ArrayList<String> keys = new ArrayList<String>();

	public KeywordFilter(String key) {
		this.keys.add(key);
	}

	public KeywordFilter(ArrayList<String> keys) {
		this.keys = keys;
	}

	@Override
	public boolean satisfies(Submission s) {
		String title = s.getTitle().toLowerCase();
		for (String key : keys) {
			if (title.indexOf(key) == -1) {
				return false;
			}
		}
		return true;
	}
}
