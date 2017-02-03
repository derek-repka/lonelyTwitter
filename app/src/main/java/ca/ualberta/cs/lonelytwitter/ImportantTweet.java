/*
 * Copyright (c) 2017 Team X ,CMPUT301, University of Alberta - All Right Reserved.
 * You may use, distribute or modify this code under terms and conditions of the Student behaviour and code of conduct.
 * You may find a copy of the license in this project. Otherwise, please contact contact@abc.ca
 *
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * This subclass of the Tweet class is used to indicate if a particular tweet is important.
 * There is no difference between the normal and important tweets, beside the return value
 * of the isImportant call.
 *
 * @author Derek.R
 * @version 1.0
 */

public class ImportantTweet extends Tweet {

    /**
     * Called when a new tweet entity is created, with only a message.
     * @param message
     */

    public ImportantTweet(String message) {
        super(message);
    }

    /**
     * Called when a new tweet entity is created, with both a date and a message.
     * @param date
     * @param message
     */

    public ImportantTweet(Date date, String message) {
        super(date, message);
    }

    /**
     * Returns true when checking if the tweet is important.
     * @return true
     */
    @Override
    public Boolean isImportant() {
        return true;
    }
}
