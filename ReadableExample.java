package com.o.some;

import android.content.pm.*;
import android.app.*;
import android.os.*;
import android.content.*;
class ReadableExample extends Activity{
	public void onCreate(Bundle p1){
	super.onCreate(p1);
	try {
	Context mcontext = createPackageContext("com.o.haanah", CONTEXT_IGNORE_SECURITY);

	SharedPreferences msharedpreferences = mcontext.getSharedPreferences("content", MODE_WORLD_READABLE);
	String counttent = msharedpreferences.getString("content", "");

	} catch (PackageManager.NameNotFoundException e) {
	e.printStackTrace();
	}
	}
}
