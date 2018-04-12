package com.storage.sdcard;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	EditText input;
	Button add, viewButton;
	TextView outputTextView;
	File file;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        input = (EditText) findViewById(R.id.editText1);
        add = (Button) findViewById(R.id.button1);
        viewButton = (Button) findViewById(R.id.button2);
        outputTextView = (TextView) findViewById(R.id.textView2);
        File external_sd_card_directiry = Environment.getExternalStorageDirectory();
        file = new File(external_sd_card_directiry,"p12.txt");
        
        viewButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				

		        BufferedReader reader = null;
				try {
					reader = new BufferedReader(new FileReader(file));
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				String data = "";
				String currentData = " ";
				try {
					 while(currentData!=null){
						 
						 data = data + currentData + "\n";
						 currentData = reader.readLine();
					 }
					 
					 outputTextView.setText(data);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
        
        add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			BufferedWriter writer = null;
			try {
				writer = new BufferedWriter(new FileWriter(file));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				try {
					writer.append(input.getText().toString() + "\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			
		});
        
       
        		
    }
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
            Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }
}
