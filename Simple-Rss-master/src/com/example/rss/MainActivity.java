package com.example.rss;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv = (TextView) findViewById(R.id.textView1);
		try {
			tv.setText(readRssFiles());
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	String readRssFiles() throws XmlPullParserException, IOException {
		String output = "";
		Reader input = null;
		try {
			input = new InputStreamReader(getAssets()
					.open("studentdetails.xml"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		XmlPullParserFactory ppfactory = XmlPullParserFactory.newInstance();
		ppfactory.setNamespaceAware(true);
		XmlPullParser par = ppfactory.newPullParser();
		par.setInput(input);

		int event = par.getEventType();

		while (event != XmlPullParser.END_DOCUMENT) {
			String data = par.getName();
			if (event == XmlPullParser.START_DOCUMENT) {
				Toast.makeText(getApplicationContext(), "Parsing Starts",
						Toast.LENGTH_SHORT).show();
			}

			else if (event == XmlPullParser.START_TAG) {
				if (data.equals("name"))
					output += ("Name :" + par.nextText() + "\n");
				else if (data.equals("id"))
					output += ("ID: " + par.nextText() + "\n");
				else if (data.equals("department"))
					output += ("Department: " + par.nextText() + "\n");
				else if (data.equals("phoneno"))
					output += ("Phone No: " + par.nextText() + "\n");
				Toast.makeText(getApplicationContext(), output,
						Toast.LENGTH_SHORT).show();
			}

			else if (event == XmlPullParser.END_TAG) {
				if (data.equals("studentdetails")) {
					output = output + "\n";
				}
			}
			event = par.nextToken();
		}
		Toast.makeText(getApplicationContext(), "Parsing Ends",
				Toast.LENGTH_SHORT).show();
		return output;

	}

}
