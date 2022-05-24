package com.github.RedditDataMiner;

import net.dean.jraw.RedditClient;
import net.dean.jraw.http.NetworkAdapter;
import net.dean.jraw.http.OkHttpNetworkAdapter;
import net.dean.jraw.http.UserAgent;
import net.dean.jraw.oauth.Credentials;
import net.dean.jraw.oauth.OAuthHelper;
import net.dean.jraw.http.*;
import org.jetbrains.annotations.NotNull;

import java.io.FileNotFoundException;
import java.util.UUID;

public class MyRedditClient {
	private UserAgent userAgent;
	private NetworkAdapter adapter;
	private UUID userId;
	private RedditClient myclient;

	public MyRedditClient(@NotNull CredResource cr) {
		userAgent = new UserAgent("bot", "com.github.RedditDataMiner",
				"v0.1", "minerBot");
		adapter = new OkHttpNetworkAdapter(userAgent);
		userId = UUID.randomUUID();
		myclient = OAuthHelper.automatic(adapter,
				Credentials.userless(cr.getClientId(), cr.getClientSecret(), userId));
		myclient.setLogger(new NoopHttpLogger());
	}

	public RedditClient getMyclient() {
		return myclient;
	}
}
