package com.RedditDataScraper;

import net.dean.jraw.models.Listing;
import net.dean.jraw.models.Submission;
import net.dean.jraw.models.SubredditSort;
import net.dean.jraw.models.TimePeriod;
import net.dean.jraw.pagination.DefaultPaginator;

import java.util.Collections;
import java.util.Comparator;

public class RedditResult {
	private final MyJFormFrame myJFormFrame;
	private final MyRedditClient myRedditClient;
	private final AllFilters filterArrayList;
	private String subredditTextField;
	private String keywordTextField;

	public RedditResult(MyJFormFrame myJFormFrame, MyRedditClient myRedditClient) {
		this.myJFormFrame = myJFormFrame;
		this.myRedditClient = myRedditClient;
		filterArrayList = new AllFilters();
	}

	public void addFilters() {
		subredditTextField = myJFormFrame.getSubredditTextField().getText().replaceAll(" ", "");
		keywordTextField = myJFormFrame.getKeywordTextField().getText();
		if (myJFormFrame.getNoNsfwCheckBox().isSelected()) {
			filterArrayList.addFilter(new NoNsfwFilter());
		}
		if (myJFormFrame.getNoSpoilerCheckBox().isSelected()) {
			filterArrayList.addFilter(new NoSpoilerFilter());
		}
		if (myJFormFrame.getScoreFilterCheckBox().isSelected()) {
			System.out.println(myJFormFrame.getScoreMinTextField().getText());
			int scoreMin = Integer.parseInt(myJFormFrame.getScoreMinTextField().getText().replaceAll(",", ""));
			int scoreMax = Integer.parseInt(myJFormFrame.getScoreMaxTextField().getText().replaceAll(",", ""));
			if (scoreMax == 0) {
				filterArrayList.addFilter(new ScoreFilter(scoreMin));
			} else {
				filterArrayList.addFilter(new ScoreFilter(scoreMin, scoreMax));
			}
		}
		if (myJFormFrame.getCommentCountFilterCheckBox().isSelected()) {
			int commentMin = Integer.parseInt(myJFormFrame.getCommentCountMinTextField().getText().replaceAll(",", ""));
			int commentMax = Integer.parseInt(myJFormFrame.getCommentCountMaxTextField().getText().replaceAll(",", ""));
			if (commentMax == 0) {
				filterArrayList.addFilter(new CommentCountFilter(commentMin));
			} else {
				filterArrayList.addFilter(new CommentCountFilter(commentMin, commentMax));
			}
		}

		if (subredditTextField.equals("")) {
			//filterArrayList.addFilter(new SubredditFilter(subredditTextField.split(",")));
			subredditTextField = "all";
		}
		if (myJFormFrame.getRegexCheckBox().isSelected()) {
			filterArrayList.addFilter(new KeywordFilter(keywordTextField));
		} else {
			filterArrayList.addFilter(new KeywordFilter(keywordTextField.replaceAll(" ", "").split(",")));
			System.out.println(keywordTextField.replaceAll(" ", "").split(","));
		}
	}

	public Comparator<Submission> getSortSettings() {
		Comparator<Submission> comparator;
		if (myJFormFrame.getAzSort().isSelected()) {
			comparator = new CompareTitle();
		} else if (myJFormFrame.getZaSort().isSelected()) {
			comparator = new CompareTitle().reversed();
		} else if (myJFormFrame.getScoreSortMin().isSelected()) {
			comparator = new CompareScore();
		} else {
			myJFormFrame.getScoreSortMax().setSelected(true);
			comparator = new CompareScore().reversed();
		}
		return comparator;
	}

	public void display() {
		DefaultPaginator<Submission> paginator = myRedditClient
				.getMyclient()
				.subreddit(subredditTextField)
				//.subreddits("world","politics", subreddits[0])
				.posts()
				.sorting((SubredditSort) myJFormFrame.getRedditSortComboBox().getSelectedItem())
				.timePeriod((TimePeriod) myJFormFrame.getTimeComboBox().getSelectedItem())
				.build();

		Listing<Submission> nextPage = paginator.next();
		Comparator<Submission> comparator = getSortSettings();
		Collections.sort(nextPage, comparator);

		for (Submission s : nextPage) {
			if (filterArrayList.satisfies(s)) {
				myJFormFrame.getResultTextArea().append("Title: "
						+ s.getTitle().replace('’', '\'').replace('—', '-')
						+ "\nScore: "
						+ s.getScore()
						+ "\nComment Count: "
						+ s.getCommentCount()
						+ "\nSubreddit: "
						+ s.getSubreddit()
						+ "\nURL: "
						+ s.getUrl()
						+ "\nPermalink: "
						+ "https://www.reddit.com" + s.getPermalink()
						+ "\n"
						+ "\n");


				System.out.println(s.getTitle()
						.replace('’', '\'')
						.replace('—', '-')
						+ "\nScore: "
						+ s.getScore()
						+ "\n"
						+ s.getUrl()
						+ "\n"
						+ "https://www.reddit.com"
						+ s.getPermalink()
						+ "\n");
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
