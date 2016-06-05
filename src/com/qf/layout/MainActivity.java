package com.qf.layout;

import com.qf.layout.MyFragment.OnInterface;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

	private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv = (TextView) findViewById(R.id.tv);
		Intent intent = getIntent();
	//intent chuanzhi ssssssssssssaaaaaaaaaaaaaaaa
		findViewById(R.id.pref).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this,PreferenceActivity.class));
			}
		});
		FragmentManager manager = getSupportFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
		MyFragment fragment = new MyFragment();
		
		transaction.replace(R.id.ll, fragment);
		transaction.commit();

			fragment.setInterface(new OnInterface() {

				@Override
				public void onSetOnInterface(String s) {
					// 在一个字符串中找到第一个只出现一次的字符。如输入abaccdeff，则输出b。
					// String s = "abddjrmacs";
					Toast.makeText(MainActivity.this, s, 1).show();
					char[] ch = s.toCharArray();
					StringBuilder builder = new StringBuilder();
					for (int i = 1; i < ch.length; i++) {
						String str = s.substring(i);
						if (!str.contains(ch[i - 1] + "")) {
							// Log.i("=======", ch[i-1]+"");
							builder.append(ch[i - 1]);
							break;
						}
					}
					tv.setText(builder.toString());
				}
			},intent.getStringExtra("v"));

	}

}
