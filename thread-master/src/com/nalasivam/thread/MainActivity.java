package com.nalasivam.thread;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends Activity {

	TextView output;
	EditText time;
	Button start;
	Handler handle;
	int num, i = 1;
	Runnable colorChanger, count;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		handle = new Handler();
		time = (EditText) findViewById(R.id.editText1);
		start = (Button) findViewById(R.id.button1);
		output = (TextView) findViewById(R.id.textView1);

		count = new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				if (num != 0) {
					output.setText(String.valueOf(num));
					num -= 1;
					handle.postDelayed(this, 1000);
				} else {
					output.setTextColor(Color.BLACK);
					output.setText("Thanks!!");
				}

			}
		};

		colorChanger = new Runnable() {

			public void run() {
				// TODO Auto-generated method stub

				if (i == 1)
					output.setTextColor(Color.RED);
				else if (i == 2)
					output.setTextColor(Color.BLUE);
				else if (i == 3)
					output.setTextColor(Color.GREEN);
				else
					output.setTextColor(Color.GRAY);
				if (num != 0)
					handle.postDelayed(this, 2000);
				if (i == 4)
					i = 1;
				i++;

			}
		};

		start.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String input = String.valueOf(time.getText());
				String array[] = input.split(":");
				num = (Integer.parseInt(array[0]) * 3600)
						+ (Integer.parseInt(array[1]) * 60)
						+ (Integer.parseInt(array[2]));
				handle.post(count);
				handle.post(colorChanger);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
