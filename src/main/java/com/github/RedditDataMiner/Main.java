package com.github.RedditDataMiner;

import net.dean.jraw.RedditClient;
import net.dean.jraw.http.*;
import net.dean.jraw.models.*;
import net.dean.jraw.oauth.Credentials;
import net.dean.jraw.oauth.OAuthHelper;
import net.dean.jraw.oauth.StatefulAuthHelper;
import net.dean.jraw.pagination.BarebonesPaginator;
import net.dean.jraw.pagination.DefaultPaginator;
import net.dean.jraw.references.MultiredditReference;
import net.dean.jraw.references.SubredditReference;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		CredResource cr = new CredResource("src/main/java/com/github/RedditDataMiner/data/credentials.txt");
		UserAgent userAgent = new UserAgent("bot", "com.github.RedditDataMiner",
				"v0.1", "minerBot");
		NetworkAdapter adapter = new OkHttpNetworkAdapter(userAgent);

		UUID uid = new UUID(16,0);
		RedditClient redditClient = OAuthHelper.automatic(adapter,
				Credentials.userless(cr.getClientId(), cr.getClientSecret(), uid));

		List<SubredditSearchResult> javaref = redditClient.searchSubredditsByName("java");
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

		DefaultPaginator<Submission> java = redditClient.subreddit(javaref.get(0).getName()).posts().build();
		for (Submission s : java.next()) {
			System.out.println(s.getTitle() + "\nScore: " + s.getScore());


		}


	}
}