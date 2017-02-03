/*
 * Copyright (c) 2017 Team X ,CMPUT301, University of Alberta - All Right Reserved.
 * You may use, distribute or modify this code under terms and conditions of the Student behaviour and code of conduct.
 * You may find a copy of the license in this project. Otherwise, please contact contact@abc.ca
 *
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * This subclass of the Tweet class is used to indicate if a particular tweet is regular.
 * There is no difference between the normal and important tweets, beside the return value
 * of the isImportant function.
 *
 * @author Derek.R
 * @version 1.0
 */


public class NormalTweet extends Tweet{

    /**
     * Called when a new tweet entity is created, with only a message.
     * @param message
     */

    public NormalTweet(String message) {
        super(message);
    }

    /**
     * Called when a new tweet entity is created, with both a date and a message.
     * @param date
     * @param message
     */

    public NormalTweet(Date date, String message) {
        super(date, message);
    }

    /**
     * Returns false when checking if the tweet is important.
     * @return false
     */

    @Override
    public Boolean isImportant(){
        return false;
    }
}

