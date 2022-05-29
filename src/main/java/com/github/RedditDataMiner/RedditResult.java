package com.github.RedditDataMiner;

import net.dean.jraw.models.Listing;
import net.dean.jraw.models.Submission;
import net.dean.jraw.models.SubredditSort;
import net.dean.jraw.models.TimePeriod;
import net.dean.jraw.pagination.DefaultPaginator;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class RedditResult {
	private MyJFormFrame myJFormFrame;
	private MyRedditClient myRedditClient;
	private AllFilters filterArrayList;
	private String[] subreddits;

	public RedditResult(MyJFormFrame myJFormFrame, MyRedditClient myRedditClient) {
		this.myJFormFrame = myJFormFrame;
		this.myRedditClient = myRedditClient;
		filterArrayList = new AllFilters();
	}

	public void addFilters() {
		if (myJFormFrame.getNoNsfwCheckBox().isSelected()) {
			filterArrayList.addFilter(new NoNsfwFilter());
		}
		if (myJFormFrame.getNoSpoilerCheckBox().isSelected()) {
			filterArrayList.addFilter(new NoSpoilerFilter());
		}
		if (myJFormFrame.getScoreFilterCheckBox().isSelected()) {
			System.out.println(myJFormFrame.getScoreMinTextField().getText());
			int scoreMin = Integer.parseInt(myJFormFrame.getScoreMinTextField().getText().replaceAll(",",""));
			int scoreMax = Integer.parseInt(myJFormFrame.getScoreMaxTextField().getText().replaceAll(",",""));
			if (scoreMax == 0) {
				filterArrayList.addFilter(new ScoreFilter(scoreMin));
			}
			else {
				filterArrayList.addFilter(new ScoreFilter(scoreMin, scoreMax));
			}
		}
		if (myJFormFrame.getCommentCountFilterCheckBox().isSelected()) {
			int commentMin = Integer.parseInt(myJFormFrame.getCommentCountMinTextField().getText().replaceAll(",",""));
			int commentMax = Integer.parseInt(myJFormFrame.getCommentCountMaxTextField().getText().replaceAll(",",""));
			if (commentMax == 0) {
				filterArrayList.addFilter(new CommentCountFilter(commentMin));
			}
			else {
				filterArrayList.addFilter(new CommentCountFilter(commentMin, commentMax));
			}
		}
		//subreddits = myJFormFrame.getSubredditTextField().getText().replaceAll(" ","").split(",");
	}

	public void display() {
		DefaultPaginator<Submission> paginator = myRedditClient
				.getMyclient()
				//.subreddit("all")
				.subreddits("worldnews", "politics", "ukraine", "russia", "news")
				.posts()
				.sorting((SubredditSort) myJFormFrame.getRedditSortComboBox().getSelectedItem())
				.timePeriod((TimePeriod) myJFormFrame.getTimeComboBox().getSelectedItem())
				.build();

		Listing<Submission> nextPage = paginator.next();
		Collections.sort(nextPage, new CompareTitle().reversed());

		for (Submission s : nextPage) {
			if (filterArrayList.satisfies(s)) {
				myJFormFrame.getResultTextArea().append(s.getTitle()
						.replace('’', '\'')
						.replace('—','-')
						+ "\nScore: "
						+ s.getScore());
				System.out.println(s.getTitle()
						.replace('’', '\'')
						.replace('—','-')
						+ "\nScore: "
						+ s.getScore());

				myJFormFrame.getResultTextArea().append(s.getSubreddit() + "\n" + s.getUrl() + "\n" + "https://www.reddit.com" + s.getPermalink());
				System.out.println(s.getSubreddit() + "\n" + s.getUrl() + "\n" + "https://www.reddit.com" + s.getPermalink());
				/*
				System.out.println(s.getPostHint());
				System.out.println(s.getDistinguished());
				System.out.println(s.getThumbnail());
				System.out.println(s.isSpam());
				System.out.println(s.isSpoiler());
				System.out.println(s.getReports());
				System.out.println(s.getGilded());
				System.out.println(s.getPreview());
				System.out.println(s.isLocked());
				System.out.println(s.getCommentCount());
				System.out.println(s.getCreated());

				 */
			}
		}
		filterArrayList.clear();
	}
}
