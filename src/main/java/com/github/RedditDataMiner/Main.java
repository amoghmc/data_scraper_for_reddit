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

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		CredResource cr = new CredResource(".idea/credentials.txt");
		UserAgent userAgent = new UserAgent("bot", "com.github.RedditDataMiner",
				"v0.1", "minerBot");
		NetworkAdapter adapter = new OkHttpNetworkAdapter(userAgent);

		UUID uid = UUID.randomUUID();
		RedditClient redditClient = OAuthHelper.automatic(adapter,
				Credentials.userless(cr.getClientId(), cr.getClientSecret(), uid));

		List<SubredditSearchResult> javaref = redditClient.searchSubredditsByName("worldnews");
		System.out.println(javaref);
		if (javaref.isEmpty()) {
			System.out.println("No results found");
		}

		/*
		try {
			DefaultPaginator<Submission> javasr = javaref.posts().build();
		}
		catch (Exception e) {
			System.out.println("ERROR");
		}
		DefaultPaginator<Submission> java = javaref.posts().build();
		//BarebonesPaginator<Message> unread = redditClient.me().inbox().iterate("unread")
		//		.build();
		//Listing<Message> firstPage = unread.next();
		DefaultPaginator<Submission> sr = redditClient.subreddit("RocketjjhfLeague").posts().build();
		for (Submission s : java.next()) {
			System.out.println(s.getTitle() + "\nScore: " + s.getScore());


		}

		for (Submission s : sr.next()) {
			System.out.println(s.getTitle());
		}

        /*
        for (Message m : firstPage) {
            System.out.println(m);
        }
        */

		DefaultPaginator<Submission> paginator = redditClient.subreddit(javaref.get(0).getName()).posts().sorting(SubredditSort.TOP).timePeriod(TimePeriod.MONTH).build();

		Listing<Submission> nextPage = paginator.next();
		AllFilters allFilters = new AllFilters();

		CommentCountFilter commentCountFilter = new CommentCountFilter(10);
		NoNsfwFilter noNsfwFilter = new NoNsfwFilter();
		NoSpamFilter noSpamFilter = new NoSpamFilter();
		ScoreFilter scoreFilter = new ScoreFilter(1000);
		ArrayList<String> stringArrayList = new ArrayList<String>();
		stringArrayList.add("russia");
		stringArrayList.add("ukraine");
		KeywordFilter keywordFilter = new KeywordFilter(stringArrayList);
		allFilters.addFilter(noSpamFilter);
		allFilters.addFilter(noNsfwFilter);
		allFilters.addFilter(scoreFilter);
		allFilters.addFilter(commentCountFilter);
		allFilters.addFilter(keywordFilter);
		for (Submission s : nextPage) {
			if (allFilters.satisfies(s)) {
				System.out.println(s.getTitle() + "\nScore: " + s.getScore());
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
	}
}