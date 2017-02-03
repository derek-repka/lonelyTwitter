/*
 * Copyright (c) 2017 Team X ,CMPUT301, University of Alberta - All Right Reserved.
 * You may use, distribute or modify this code under terms and conditions of the Student behaviour and code of conduct.
 * You may find a copy of the license in this project. Otherwise, please contact contact@abc.ca
 *
 */

package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


/**
 * This class is the main view class of the project. <br> In this class,
 * user interaction and file manipulation is performed.
 * All files are in the form of "json" files that are stored in Emulator's
 * accessible from Android Device Monitor:
 * <pre>
 *     pre-formatted text: <br>
 *         File Explorer -> data ->ca.ualberta.cs.lonelytwitter -> file
 * </pre>
 * <code> begin <br>
 *     some pseudo code here <br>
 * end.</code>
 * This file name is indicated in the &nbsp &nbsp &nbsp FILENAME constant.
 * <ul>
 *     <li>Item 1</li>
 *     <li>Item 2</li>
 *     <li>Item 3</li>
 * </ul>
 * <ol>
 *     <li>Item 1</li>
 *     <li>Item 2</li>
 *     <li>Item 3</li>
 * </ol>
 * @author Derek.R
 * @version 1.4.2
 * @since 1.0
 */
public class LonelyTwitterActivity extends Activity {

	/**
	 * The file that all the tweets are saved there.
	 * The format of the file is JSON.
	 * @see #loadFromFile()
	 * @see #saveInFile()
	 */

	private static final String FILENAME = "file.sav";
	private enum TweetListOrdering {DATE_ASCENDING, DATE_DESCENDING, TEXT_ASCENDING, TEXT_DESCENDING};
	private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayList<Tweet> tweetList;
	private ArrayAdapter<Tweet> adapter;

	/**
	 * Called when the activity is first created
	 * @param savedInstanceState
     */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		/**
		 * Listener for the save button, that is called when then save button is clicked.
		 * Saves a copy of the tweet from the bodyText field to a string variable 'text'.
		 * After trimming the string of excess spaces, a new normal tweet is created
		 * and saves string as its message.
		 * Lastly, the new normal tweet is added to the tweetList arrayList,
		 * and is then saved to the file.
		 */

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				text = trimExtraSpace(text);

				Tweet tweet = new NormalTweet(text);
				tweetList.add(tweet);

				adapter.notifyDataSetChanged();

				saveInFile();

			}
		});

		/**
		 * Listener for the clear button, that is called when then clear button is clicked.
		 * Sets the bodyText to nothing, and clears the tweet list before saving the file.
		 * This will remove all tweets currently being stored.
		 */

		clearButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);

				bodyText.setText("");
				tweetList.clear();

				adapter.notifyDataSetChanged();
				saveInFile();

			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		loadFromFile();

		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
	}

	/**
	 * Removes extra spaces in the given string
	 * @param inputString input string
	 * @return string without extra spaces
     */
	private String trimExtraSpace(String inputString){
		inputString = inputString.replaceAll("\\s+", " ");
		return inputString;
	}

	private void sortTweetListItems(TweetListOrdering ordering){

	}

	/**
	 * Loads tweets from file
	 * @throws TweetTooLongException if the tweet is too long
	 * @exception FileNotFoundException if the file is not created
	 */
	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

			Gson gson = new Gson();
			// Taken from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
			// 2017-01-26 17:54:15
			tweetList = gson.fromJson(in, new TypeToken<ArrayList<NormalTweet>>(){}.getType());

			fis.close();


		} catch (FileNotFoundException e) {
			tweetList = new ArrayList<Tweet>();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	/**
	 * Saves tweets in file on JSON format.
	 * @throws FileNotFoundException if folder does not exist
	 */
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);

			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

			Gson gson = new Gson();

			gson.toJson(tweetList, out);

			out.flush();

			fos.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}