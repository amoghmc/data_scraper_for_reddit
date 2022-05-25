package com.github.RedditDataMiner;

import net.dean.jraw.RedditClient;
import net.dean.jraw.http.*;
import net.dean.jraw.models.*;
import net.dean.jraw.oauth.Credentials;
import net.dean.jraw.oauth.OAuthHelper;
import net.dean.jraw.oauth.StatefulAuthHelper;
import net.dean.jraw.pagination.BarebonesPaginator;
import net.dean.jraw.pagination.DefaultPaginator;
import net.dean.jraw.pagination.Paginator;
import net.dean.jraw.references.MultiredditReference;
import net.dean.jraw.references.SubredditReference;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		CredResource cr = new CredResource(".idea/credentials.txt");
		MyRedditClient myRedditClient = new MyRedditClient(cr);
		/*
		MyFrame jFrame = new MyFrame();
		HeadingLabel jLabel = new HeadingLabel();
		jLabel.setText("Welcome to Reddit Data Miner");
		jFrame.add(jLabel);

		HeadingLabel jLabe2 = new HeadingLabel();
		jLabe2.setText("Add");
		jFrame.add(jLabe2);


		 */
		MyJFormFrame mjFormFrame = new MyJFormFrame();
		mjFormFrame.setVisible(true);
		mjFormFrame.setSize(100,100);

		List<SubredditSearchResult> javaref = myRedditClient.getMyclient().searchSubredditsByName("worldnews");
		System.out.println(javaref);
		if (javaref.isEmpty()) {
			System.out.println("No results found");
		}

		AllFilters allFilters = new AllFilters();

		DefaultPaginator<Submission> paginator = myRedditClient
				.getMyclient()
				.subreddits("worldnews", "politics", "ukraine", "russia", "news")
				.posts()
				.sorting(SubredditSort.TOP)
				.timePeriod(TimePeriod.MONTH)
				.build();

		Listing<Submission> nextPage = paginator.next();
		Collections.sort(nextPage, new CompareTitle().reversed());

		CommentCountFilter commentCountFilter = new CommentCountFilter(10);
		NoNsfwFilter noNsfwFilter = new NoNsfwFilter();
		NoSpamFilter noSpamFilter = new NoSpamFilter();
		ScoreFilter scoreFilter = new ScoreFilter(1000);
		ArrayList<String> stringArrayList = new ArrayList<String>();
		stringArrayList.add("russia");
		//stringArrayList.add("ukraine");
		KeywordFilter keywordFilter = new KeywordFilter(stringArrayList);
		allFilters.addFilter(noSpamFilter);
		allFilters.addFilter(noNsfwFilter);
		allFilters.addFilter(scoreFilter);
		allFilters.addFilter(commentCountFilter);
		allFilters.addFilter(keywordFilter);
		for (Submission s : nextPage) {
			if (allFilters.satisfies(s)) {
				System.out.println(s.getTitle()
						.replace('’', '\'')
						.replace('—','-')
						+ "\nScore: "
						+ s.getScore());
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
		//System.exit(0);
	}
}