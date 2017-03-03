package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class EditTweetActivity extends Activity {

    private String message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);
        TextView textView = (TextView) findViewById(R.id.textView);
        Intent intent = getIntent();
        message = intent.getExtras().getString("message");
        textView.setText(message);

    }
}
