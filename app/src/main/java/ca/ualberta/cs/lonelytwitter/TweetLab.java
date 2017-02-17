package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static junit.framework.Assert.fail;

/**
 * Created by Derek.R on 2017-02-16.
 */

public class TweetLab {
    private ArrayList<NormalTweet> tweets = new ArrayList<NormalTweet>();

    public boolean addTweet(NormalTweet tweet){
        try{
            if (tweets.contains(tweet)){
                fail();
            }
        }catch(IllegalArgumentException e){
            return false;
        }
        tweets.add(tweet);
        return true;
    }

    public void getTweets(){
        Collections.sort(tweets, new Comparator<NormalTweet>() {
            public int compare(NormalTweet tweet1, NormalTweet tweet2) {
                return tweet1.getDate().compareTo(tweet2.getDate());
            }
        });
    }

    public boolean isSorted(){
        boolean sorted = true;
        for (int i = 0; i <= (tweets.size() - 2); i++){
            if (tweets.get(i).getDate().after(tweets.get(i+1).getDate())){
                sorted = false;
                break;
            }
        }
        return sorted;
    }

    public boolean hasTweet(NormalTweet tweet){
        return tweets.contains(tweet);
    }

    public int getCount(){
        return tweets.size();
    }


}
