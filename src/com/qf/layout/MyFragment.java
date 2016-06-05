package com.qf.layout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class MyFragment extends Fragment {
	private OnInterface mInterface;
	private EditText et;
	private String v;
	public void setInterface(OnInterface mInterface,String v) {
		this.mInterface = mInterface;
		this.v = v;
	}
	interface OnInterface{
		void onSetOnInterface(String data);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.calculetor_main,null);
		et = (EditText) view.findViewById(R.id.et);
		if (v!=null) {
			et.setText(v);
		}
		
		((Button)view.findViewById(R.id.button1)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String str = et.getText().toString();
				if (str!=null&&!str.equals("")) {
//					Toast.makeText(getActivity(), str, 1).show();
					mInterface.onSetOnInterface(str);
				}
			}
		});
		
		return view;
	}
	
}
