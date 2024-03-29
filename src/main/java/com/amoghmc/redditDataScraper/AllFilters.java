package com.amoghmc.redditDataScraper;


import net.dean.jraw.models.Submission;

import java.util.ArrayList;

public class AllFilters implements Filter {
	final ArrayList<Filter> filters;

	public AllFilters() {
		filters = new ArrayList<>();
	}

	public void addFilter(Filter filter) {
		filters.add(filter);
	}

	@Override
	public boolean satisfies(Submission submission) {
		for (Filter filter : filters) {
			if (!filter.satisfies(submission)) {
				return false;
			}
		}
		return true;
	}

	public void clear() {
		filters.clear();
	}

}

