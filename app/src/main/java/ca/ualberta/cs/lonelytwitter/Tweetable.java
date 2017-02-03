/*
 * Copyright (c) 2017 Team X ,CMPUT301, University of Alberta - All Right Reserved.
 * You may use, distribute or modify this code under terms and conditions of the Student behaviour and code of conduct.
 * You may find a copy of the license in this project. Otherwise, please contact contact@abc.ca
 *
 */

package ca.ualberta.cs.lonelytwitter;

/**
 * The interface that the superclass 'Tweet' implements for all tweets,
 * whether they are normal tweets, or important tweets.
 * This interface only contains the getter and setter methods.
 * As well, the setMessage setter method uses the TweetTooLongException
 * when tweets longer than 140 characters are attempted to be saved.
 *
 * @author Derek.R
 * @version 1.0
 */

public interface Tweetable {
    public String getMessage();
    public void setMessage(String string) throws TweetTooLongException;
}
