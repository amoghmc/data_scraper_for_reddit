package com.amoghmc.RedditDataScraper;

import net.dean.jraw.RedditClient;
import net.dean.jraw.http.NetworkAdapter;
import net.dean.jraw.http.NoopHttpLogger;
import net.dean.jraw.http.OkHttpNetworkAdapter;
import net.dean.jraw.http.UserAgent;
import net.dean.jraw.oauth.Credentials;
import net.dean.jraw.oauth.OAuthHelper;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class MyRedditClient {
	private final UserAgent userAgent;
	private final NetworkAdapter adapter;
	private final UUID userId;
	private final RedditClient myclient;

	public MyRedditClient(@NotNull String clientId, String clientSecret) {
		userAgent = new UserAgent("bot", "com.github.RedditDataMiner",
				"v1.2", "minerBot");
		adapter = new OkHttpNetworkAdapter(userAgent);
		userId = UUID.randomUUID();
		myclient = OAuthHelper.automatic(adapter,
				Credentials.userless(clientId, clientSecret, userId));
		myclient.setLogger(new NoopHttpLogger());
	}

	public RedditClient getMyclient() {
		return myclient;
	}
}
