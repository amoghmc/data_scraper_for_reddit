package com.github.RedditDataMiner;

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
		Scanner sc = new Scanner(file);
		Dictionary dict = new Hashtable();
		String[] list = new String[2];

		while (sc.hasNextLine()) {
			int i = 0;
			for (String word : sc.nextLine().split(" ")) {
				list[i] = word;
				i++;
			}
			dict.put(list[0].toLowerCase(), list[1]);
		}

		this.username = dict.get("username").toString();
		this.password = dict.get("password").toString();
		this.clientId = dict.get("clientid").toString();
		this.clientSecret = dict.get("clientsecret").toString();
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
