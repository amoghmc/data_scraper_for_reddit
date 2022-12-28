package com.amoghmc.redditDataScraper;

import net.dean.jraw.models.Submission;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DuplicateFilter implements Filter{
	private ArrayList<Integer> keys;

	public DuplicateFilter() {
		keys = new ArrayList<Integer>();
	}

	public boolean satisfies(Submission sub) {
		Integer hash = sub.getPermalink().hashCode();
		if (keys.contains(hash)) {
			return false;
		}
		keys.add(hash);
		return true;
	}
}
