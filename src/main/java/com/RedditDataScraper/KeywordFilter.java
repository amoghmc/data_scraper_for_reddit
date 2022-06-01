package com.RedditDataScraper;

import net.dean.jraw.models.Submission;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KeywordFilter implements Filter {
	private String[] keys;
	private String regex;

	public KeywordFilter(String[] keys) {
		this.keys = keys;
	}

	public KeywordFilter(String regex) {
		this.regex = regex;
	}

	@Override
	public boolean satisfies(Submission submission) {
		if (keys == null) {
			// Source: https://www.w3schools.com/java/java_regex.asp
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(submission.getTitle());
			return matcher.find();
			// End of source
		} else {
			String title = submission.getTitle().toLowerCase();
			for (String key : keys) {
				if (!title.contains(key.toLowerCase())) {
					return false;
				}
			}
			return true;
		}
	}
}
