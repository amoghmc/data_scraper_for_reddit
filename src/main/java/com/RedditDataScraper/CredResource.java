package com.RedditDataScraper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

public class CredResource {
	private final String clientId;
	private final String clientSecret;

	public CredResource() throws FileNotFoundException {
		clientId = "j_20W3vqYfrOmxkgqGSUWg";
		clientSecret = "a4sKpmsobsi6Oni7juTDBXDD9VZ5ng";
		/*File file = new File(filename);
		Scanner scanner = new Scanner(file);
		Dictionary dictionary = new Hashtable();
		String[] list = new String[2];

		while (scanner.hasNextLine()) {
			int i = 0;
			for (String word : scanner.nextLine().split(" ")) {
				list[i] = word;
				i++;
			}
			dictionary.put(list[0].toLowerCase(), list[1]);
		}

		this.clientId = dictionary.get("clientid:").toString();
		this.clientSecret = dictionary.get("clientsecret:").toString();*/
	}

	public String getClientId() {
		return clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}
}
