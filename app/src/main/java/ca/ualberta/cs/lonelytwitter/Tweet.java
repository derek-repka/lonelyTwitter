/*
 * Copyright (c) 2017 Team X ,CMPUT301, University of Alberta - All Right Reserved.
 * You may use, distribute or modify this code under terms and conditions of the Student behaviour and code of conduct.
 * You may find a copy of the license in this project. Otherwise, please contact contact@abc.ca
 *
 */

package ca.ualberta.cs.lonelytwitter;
import java.util.Date;

/**
 * This is the main superclass that both important and normal tweets inherit.
 * For this method, there are two objects, date and message, and their
 * respective setters and getters methods. Additionally, there are methods
 * for the importance of the tweet, as well as the conversion of the input
 * message into the format that is saved to the file.
 *
 * @author Derek.R
 * @version 1.0
 */
public abstract class Tweet implements Tweetable{
    private Date date;
    private String message;

    /**
     * The constructor for the Tweet. If a date is provided,
     * the tweet uses that date, but otherwise, it uses the current date.
     * @param message input message
     */
    public Tweet(String message){
        this.message = message;
        this.date = new Date();
    }

    /**
     * The constructor for the Tweet. If a date is provided,
     * the tweet uses that date, but otherwise, it uses the current date.
     * @param message input message
     */
    public Tweet(Date date, String message){
        this.message = message;
        this.date = date;
    }

    /**
     * The getter method for the date of the tweet.
     * @return the date of the tweet
     */
    public Date getDate() {
        return date;
    }

    /**
     * The setter method for the date of the tweet, which sets the date to the current date.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * The getter method for the message.
     * @return the tweet
     */


    public String getMessage() {
        return message;
    }

    /**
     * The setter method for the message.
     * When setting the message, if the message trying to be set is
     * longer than 140 characters, a TweetTooLongException is thrown.
     * @param message
     * @throws TweetTooLongException
     */
    public void setMessage(String message) throws TweetTooLongException{
        if (message.length() > 140){
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    /**
     * The abstract method for the importance of the tweet that is
     * used by ImportantTweet and NormalTweet.
     */
    public abstract Boolean isImportant();

    /**
     * When converting another object into a string, the date and a vertical bar is inserted
     * before the object, before returning it as a string.
     * @return the date of the tweet and the tweet itself, separated by a vertical bar.
     */
    @Override
    public String toString(){
        return date.toString() + " | " + message;
    }
}
