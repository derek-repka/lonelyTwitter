package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

/**
 * Created by Derek.R on 2017-02-16.
 */

public class TweetLabTest extends ActivityInstrumentationTestCase2{

    public TweetLabTest() {
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet(){
        TweetLab tweets = new TweetLab();
        NormalTweet tweet = new NormalTweet("Some Tweet");
        assertTrue(tweets.addTweet(tweet));
        //assertTrue(tweets.addTweet(tweet));
    }

    public void testGetTweets(){
        TweetLab tweets = new TweetLab();
        NormalTweet tweet = new NormalTweet("Some Tweet");
        try {
            Thread.sleep(1000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        NormalTweet tweet2 = new NormalTweet("Another Tweet");
        try {
            Thread.sleep(1000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        NormalTweet tweet3 = new NormalTweet("Yet Another Tweet");
        assertTrue(tweets.addTweet(tweet2));
        assertTrue(tweets.addTweet(tweet));
        assertTrue(tweets.addTweet(tweet3));
        tweets.getTweets();
        assertTrue(tweets.isSorted());
    }

    public void testHasTweet(){
        TweetLab tweets = new TweetLab();
        NormalTweet tweet = new NormalTweet("Some Tweet");
        assertTrue(tweets.addTweet(tweet));
        assertTrue(tweets.hasTweet(tweet));
    }

    public void testGetCount(){
        TweetLab tweets = new TweetLab();
        NormalTweet tweet = new NormalTweet("Some Tweet");
        NormalTweet tweet2 = new NormalTweet("Another Tweet");
        assertTrue(tweets.addTweet(tweet));
        assertTrue(tweets.addTweet(tweet2));
        assertEquals(tweets.getCount(), 2);


    }

}
