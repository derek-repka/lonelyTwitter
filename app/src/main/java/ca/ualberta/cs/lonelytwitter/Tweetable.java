package ca.ualberta.cs.lonelytwitter;

/**
 * Created by Derek.R on 2017-01-26.
 */

public interface Tweetable {
    public String getMessage();
    public void setMessage(String string) throws TweetTooLongException;
}
