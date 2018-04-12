package com.nalasivam.dbconnection;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	Button add,display;
	EditText name,phone;
	SQLiteDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		add = (Button) findViewById(R.id.button1);
		display = (Button) findViewById(R.id.button2);
		name = (EditText) findViewById(R.id.editText1);
		phone = (EditText) findViewById(R.id.editText2);
		db = openOrCreateDatabase("detail", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS context(name VARCHAR,phone VARCHAR);");
		add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				db.execSQL("INSERT INTO context VALUES ('"+name.getText().toString()+"','"+phone.getText().toString()+"')");
			}
		});
		display.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
}
