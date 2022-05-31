package com.RedditDataScraper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class CredResource {
	private String username, password, clientId, clientSecret;

	public CredResource(String filename) throws FileNotFoundException {
		File file = new File(filename);
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

		this.username = dictionary.get("username:").toString();
		this.password = dictionary.get("password:").toString();
		this.clientId = dictionary.get("clientid:").toString();
		this.clientSecret = dictionary.get("clientsecret:").toString();
	}

	public String getClientId() {
		return clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public String getUsername() throws Exception {
		if (!username.equals("null")) {
			return username;
		}
		Exception NullPointerException = null;
		throw NullPointerException;
	}

	public String getPassword() throws Exception {
		if (!password.equals("null")) {
			return password;
		}
		Exception NullPointerException = null;
		throw NullPointerException;
	}
}
