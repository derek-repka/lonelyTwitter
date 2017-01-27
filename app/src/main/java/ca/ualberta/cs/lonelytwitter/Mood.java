package ca.ualberta.cs.lonelytwitter;
import java.util.Date;

/**
 * Created by Derek.R on 2017-01-19.
 */

public abstract class Mood {
    private Date date;
    private String mood;

    public Mood() {
        this.date = new Date();
    }

    public Mood(Date date) {
        this.date = date;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract String currentMood();

}
