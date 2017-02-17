package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

/**
 * Created by Derek.R on 2017-02-16.
 */

public class TweetList {
    private ArrayList<NormalTweet> tweets = new ArrayList<NormalTweet>();

    public void add(NormalTweet tweet){
        tweets.add(tweet);
    }

    public boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }
    public NormalTweet getTweet(int index){
  //      return new NormalTweet("not the tweet");
        return tweets.get(index);
    }

    public void delete(Tweet tweet){
        tweets.remove(tweet);
    }
}
