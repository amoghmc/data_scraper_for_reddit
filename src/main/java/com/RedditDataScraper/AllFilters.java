package com.RedditDataScraper;


import net.dean.jraw.models.Submission;

import java.util.ArrayList;

public class AllFilters implements Filter {
	ArrayList<Filter> filters;

	public AllFilters() {
		filters = new ArrayList<Filter>();
	}

	public void addFilter(Filter f) {
		filters.add(f);
	}

	@Override
	public boolean satisfies(Submission s) {
		for(Filter f : filters) {
			if (!f.satisfies(s)) {
				return false;
			}
		}
		return true;
	}

	public void clear() {
		filters.clear();
	}

}

