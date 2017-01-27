package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Derek.R on 2017-01-19.
 */

public class Happy extends Mood {
    public Happy() {
    }

    public Happy(Date date) {
        super(date);
    }

    public String currentMood(){
        return ("My mood is currently Happy.");
    }
}