package com.nalasivam.labexpriment;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button greet, cf, cc;
	TextView output1, output2, output3;
	EditText name;
	Typeface tf1, tf2;
	int font = 0;
	int color = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		greet = (Button) findViewById(R.id.button1);
		cf = (Button) findViewById(R.id.button3);
		cc = (Button) findViewById(R.id.button2);
		name = (EditText) findViewById(R.id.editText1);
		output1 = (TextView) findViewById(R.id.textView1);
		output2 = (TextView) findViewById(R.id.textView2);
		tf1 = Typeface.createFromAsset(getAssets(), "type1.ttf");
		tf2 = Typeface.createFromAsset(getAssets(), "type2.ttf");
		greet.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				String username = name.getText().toString();
				if (username.trim().length() != 0) {
					output1.setTypeface(tf1);
					output2.setTextColor(Color.BLUE);
					output1.setText("Welcome" + username);
					output2.setText("Welcome" + username);
				} else {
					output1.setText("  ");
					output2.setText("  ");
					Toast.makeText(getApplicationContext(), "empty",
							Toast.LENGTH_SHORT).show();
				}
			}
		});
		cf.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (name.getText().toString().trim().length() != 0) {
					if (font == 0) {
						output1.setTypeface(tf2);
						font = 1;
					} else {
						output1.setTypeface(tf1);
						font = 0;
					}

					output1.setText("Welcome" + name.getText().toString());
				}
			}
		});
		cc.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (name.getText().toString().trim().length() != 0) {
					if (color == 0) {
						output2.setTextColor(Color.RED);
						color = 1;
					} else {
						output2.setTextColor(Color.BLUE);
						color = 0;
					}
					output2.setText("Welcome" + name.getText().toString());
				}
			}
		});
	}

}
