package com.nalasivam.ex2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

	Button n1, n2, n3, n4, n5, n6, n7, n8, n9, n0, bdel, bdiv, bmul, bsub,
			badd, bequal;
	TextView expression, answer;
	int num1 = 0, num2 = 0, flag = 0;
	String exp = "";
	char prevoperator;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		expression = (TextView) findViewById(R.id.expresion);
		answer = (TextView) findViewById(R.id.answer);
		n1 = (Button) findViewById(R.id.n1);
		n2 = (Button) findViewById(R.id.n2);
		n3 = (Button) findViewById(R.id.n3);
		n4 = (Button) findViewById(R.id.n4);
		n5 = (Button) findViewById(R.id.n5);
		n6 = (Button) findViewById(R.id.n6);
		n7 = (Button) findViewById(R.id.n7);
		n8 = (Button) findViewById(R.id.n8);
		n9 = (Button) findViewById(R.id.n9);
		n0 = (Button) findViewById(R.id.n0);
		bdel = (Button) findViewById(R.id.del);
		bdiv = (Button) findViewById(R.id.bdiv);
		bmul = (Button) findViewById(R.id.bmul);
		bsub = (Button) findViewById(R.id.bsub);
		badd = (Button) findViewById(R.id.badd);
		bequal = (Button) findViewById(R.id.beql);
		n1.setOnClickListener(this);
		n2.setOnClickListener(this);
		n3.setOnClickListener(this);
		n4.setOnClickListener(this);
		n5.setOnClickListener(this);
		n6.setOnClickListener(this);
		n7.setOnClickListener(this);
		n8.setOnClickListener(this);
		n9.setOnClickListener(this);
		n0.setOnClickListener(this);
		bdel.setOnClickListener(this);
		bdiv.setOnClickListener(this);
		bmul.setOnClickListener(this);
		bsub.setOnClickListener(this);
		badd.setOnClickListener(this);
		bequal.setOnClickListener(this);
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

	void numberClicked(int n) {

		exp += n;
		num2 *= 10;
		num2 += n;
		expression.setText(exp);
	}

	void operatorClicked(char operator) {
		if (flag == 0) {
			num1 = num2;
			flag = 1;
		}
		prevoperator = operator;
		num2 = 0;
		answer.setText(String.valueOf(num1));
		exp += operator;
		expression.setText(exp);
	}

	public void opration() {
		if (flag == 1) {
			switch (prevoperator) {
			case '*':
				num1 *= num2;
				break;
			case '/':
				num1 /= num2;
				break;
			case '+':
				num1 += num2;
				break;
			case '-':
				num1 -= num2;
				break;
			}
		}
		answer.setText(String.valueOf(num1));
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.n1:
			numberClicked(1);
			opration();
			break;
		case R.id.n2:
			numberClicked(2);
			opration();
			break;
		case R.id.n3:
			numberClicked(3);
			opration();
			break;
		case R.id.n4:
			numberClicked(4);
			opration();
			break;
		case R.id.n5:
			numberClicked(5);
			opration();
			break;
		case R.id.n6:
			numberClicked(6);
			opration();
			break;
		case R.id.n7:
			numberClicked(7);
			opration();
			break;
		case R.id.n8:
			numberClicked(8);
			opration();
			break;
		case R.id.n9:
			numberClicked(9);
			opration();
			break;
		case R.id.n0:
			numberClicked(0);
			opration();
			break;
		case R.id.bmul:
			operatorClicked('*');
			break;
		case R.id.bdiv:
			operatorClicked('/');
			break;
		case R.id.badd:
			operatorClicked('+');

			break;
		case R.id.bsub:
			operatorClicked('-');

			break;
		case R.id.beql:
			exp = String.valueOf(num1);
			expression.setText(exp);
			answer.setText("");
			num2 = 0;
			// flag = 0;
			break;
		case R.id.del:
			exp = "";
			expression.setText(exp);
			answer.setText("");
			num2 = 0;
			flag = 0;
			num1 = 0;
		default:
			break;
		}

	}
}
