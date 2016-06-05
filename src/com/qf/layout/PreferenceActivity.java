package com.qf.layout;

import android.content.Intent;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceManager;

public class PreferenceActivity extends android.preference.PreferenceActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preference);
		PreferenceManager manager = getPreferenceManager();
		(manager.findPreference("listPref")).setOnPreferenceChangeListener(new OnPreferenceChangeListener() {
			
			@Override
			public boolean onPreferenceChange(Preference preference, Object newValue) {
				CharSequence[] entries = ((ListPreference)preference).getEntries();
				startActivity(new Intent(PreferenceActivity.this,MainActivity.class).putExtra("v",(String)newValue));
				return true;
			}
		});
	}
}
