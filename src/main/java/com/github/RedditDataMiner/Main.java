package com.github.RedditDataMiner;

import com.github.jreddit.entity.Submission;
import com.github.jreddit.entity.User;
import com.github.jreddit.message.Messages;
import com.github.jreddit.retrieval.Submissions;
import com.github.jreddit.retrieval.params.SubmissionSort;
import com.github.jreddit.utils.restclient.HttpRestClient;
import com.github.jreddit.utils.restclient.RestClient;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        RestClient restClient = new HttpRestClient();
        //restClient.setUserAgent("bot/1.0 by name");

        // Connect the user
        /*
        User user = new User(restClient, "username", "password");
        try {
            user.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        */

        Submissions subms = new Submissions(restClient);

        // Retrieve submissions of a submission
        List<Submission> submissionsSubreddit = subms.ofSubreddit("worldnews", SubmissionSort.HOT, -1, 10, null, null, true);
        for (int i = 1; i < submissionsSubreddit.size(); i++) {
            System.out.println(i + ". ");
            System.out.println(submissionsSubreddit.get(i).getTitle());
            System.out.println("Score: " + submissionsSubreddit.get(i).getScore() + "\n");
        }
    }
}