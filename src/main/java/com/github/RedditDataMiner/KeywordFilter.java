package com.github.RedditDataMiner;

import net.dean.jraw.models.Submission;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KeywordFilter implements Filter{
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
		if (keys.length == 0) {
			// Source: https://www.w3schools.com/java/java_regex.asp
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(submission.getTitle());
			boolean matchFound = matcher.find();
			if (matchFound) {
				return true;
			}
			else {
				return false;
			}
			// End of source
		}
		else {
			String title = submission.getTitle().toLowerCase();
			for (String key : keys) {
				if (title.indexOf(key.toLowerCase()) == -1) {
					return false;
				}
			}
			return true;
		}
	}
}
