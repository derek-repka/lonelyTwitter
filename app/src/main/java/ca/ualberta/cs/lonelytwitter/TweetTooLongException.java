/*
 * Copyright (c) 2017 Team X ,CMPUT301, University of Alberta - All Right Reserved.
 * You may use, distribute or modify this code under terms and conditions of the Student behaviour and code of conduct.
 * You may find a copy of the license in this project. Otherwise, please contact contact@abc.ca
 *
 */

package ca.ualberta.cs.lonelytwitter;

/**
 * This is the exception for the tweets class, then is used to catch the
 * thrown exception when the tweet being saved is longer than 140 characters.
 * Currently, this exception does not do anything, but in the future will
 * alert the user that the tweet is too long, and to shorten the message
 * before saving the tweet.
 *
 * @author Derek.R
 * @version 1.0
 */

public class TweetTooLongException extends Exception {
}
