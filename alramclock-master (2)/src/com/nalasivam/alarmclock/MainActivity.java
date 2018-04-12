package com.nalasivam.alarmclock;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import java.util.Calendar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;


public class MainActivity extends Activity {
	Button click;
	TimePicker tp;
	Calendar cal;
	AlarmManager alarmmanager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        click = (Button) findViewById(R.id.button1);
        tp = (TimePicker) findViewById(R.id.timePicker1);
        cal = Calendar.getInstance();
        click.setOnClickListener(new View.OnClickListener() {
        
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				int hour = cal.get(Calendar.HOUR_OF_DAY);
				int minute = cal.get(Calendar.MINUTE);
				int hour2 = tp.getCurrentHour();
				int minute2 = tp.getCurrentMinute();
				int current_time = (hour*3600)+(minute*60);
				int set_time = (hour2*3600)+(minute2*60);
				int time_in_sec;
				if(set_time == current_time){
					Toast.makeText(getApplicationContext(),"Invalid entry", Toast.LENGTH_SHORT).show();
				}else{
				if(set_time >= current_time)
					time_in_sec = set_time - current_time;
				else
					time_in_sec = (86400 - current_time) + set_time;
					
				Toast.makeText(getApplicationContext(),"Alarm on", Toast.LENGTH_SHORT).show();
				
				Intent alramIntent = new Intent(MainActivity.this, AlarmStart.class);
		        PendingIntent pin = PendingIntent.getBroadcast(getApplicationContext(), 1, alramIntent,PendingIntent.FLAG_ONE_SHOT);
		        alarmmanager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
		        alarmmanager.set(AlarmManager.RTC_WAKEUP, 1000*3, pin);
				}
		        
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
