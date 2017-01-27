package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Derek.R on 2017-01-19.
 */

public class Sad extends Mood {
    public Sad() {
    }

    public Sad(Date date) {
        super(date);
    }

    public String currentMood(){
        return ("My mood is currently Sad.");
    }
}
