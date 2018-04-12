package com.nalasivam.exs3;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends Activity {
	Bitmap bg;
	ImageView i;
	Canvas canvas;
	Paint paint;
	Button click;
	Spinner list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		click = (Button) findViewById(R.id.button1);
		list = (Spinner) findViewById(R.id.spinner1);
		click.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				bg = Bitmap.createBitmap(600, 600, Bitmap.Config.ARGB_8888);
				ImageView i = (ImageView) findViewById(R.id.imageView1);
				i.setBackgroundDrawable(new BitmapDrawable(bg));
				canvas = new Canvas(bg);
				paint = new Paint();
				paint.setColor(Color.BLUE);
				// TODO Auto-generated method stub
				String selected = String.valueOf(list.getSelectedItem());
				if (selected.equals("Elipse"))
					canvas.drawCircle(300, 300, 150, paint);
				else if (selected.equals("Rectangle"))
					canvas.drawRect(100, 150, 450, 450, paint);
				else
					canvas.drawRect(200, 200, 400, 500, paint);

			}
		});

	}

}
