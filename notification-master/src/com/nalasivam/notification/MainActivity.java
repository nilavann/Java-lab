package com.nalasivam.notification;

import android.accessibilityservice.GestureDescription.Builder;
import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	NotificationCompat.Builder builder;
	NotificationManager manager;
	String data;
	Handler handle;
	int sec = 0;
	int giventime = 0, interval = 0;
	Runnable start;
	Button click;
	EditText input_sec, input_interval;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		handle = new Handler();
		click = (Button) findViewById(R.id.button1);
		input_sec = (EditText) findViewById(R.id.editText1);
		input_interval = (EditText) findViewById(R.id.editText2);
		manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		builder = new NotificationCompat.Builder(this);
		start = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				if (sec <= giventime) {
					if (sec == 0)
						builder.setContentText("Reminder started");
					else
						builder.setContentText(String.valueOf(sec)
								+ " sec elapsed");
					builder.setContentTitle("Remainder");
					builder.setSmallIcon(R.drawable.icon);
					manager.notify(0, builder.build());
					sec += interval;
					handle.postDelayed(this, 1000 * interval);
				} else
					handle.removeCallbacks(start);
			}
		};

		click.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				giventime = Integer.parseInt(String.valueOf(input_sec.getText()));
				interval = Integer.parseInt(String.valueOf(input_interval
						.getText()));
				Toast.makeText(getApplicationContext(), "Reminder on",
						Toast.LENGTH_SHORT).show();
				handle.post(start);
			}
		});

	}
}
