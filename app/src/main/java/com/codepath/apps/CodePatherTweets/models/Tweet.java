package com.codepath.apps.CodePatherTweets.models;

import com.codepath.apps.CodePatherTweets.TimeFormatter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Tweet {
    public long id;
    public String body;
    public String createdAt;
    public String getFormattedTimestamp;
    public User user;
    private static JSONObject jsonObject;


    //Empty constructor needed by to Parceler Library
    public Tweet(){}
    public static Tweet fromJson(JSONObject jsonObject) throws JSONException {

        Tweet tweet = new Tweet();
        tweet.body = jsonObject.getString("text");
        tweet.createdAt = jsonObject.getString("created_at");
        tweet.id =jsonObject.getLong("id");
        tweet.user = User.fromJson(jsonObject.getJSONObject("user"));
        return tweet;

    }
    //for the date
    public String getFormattedTimestamp() {

        return TimeFormatter.getTimeDifference(createdAt);
    }
    public static List<Tweet> fromJsonArray(JSONArray jsonArray) throws JSONException {
        List<Tweet> tweets = new ArrayList<>();
        for(int i=0; i < jsonArray.length(); i++){
            tweets.add(fromJson(jsonArray.getJSONObject(i)));
        }
        return  tweets;
    }

}