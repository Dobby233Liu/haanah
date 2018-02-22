package com.o.haanah;

import android.app.*;
import android.os.*;
import android.content.*;
import android.widget.*;
import android.view.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		final TextView tv=(TextView)findViewById(R.id.shit);
	    if(get()!="null"){tv.setText(get());}
	tv.setOnClickListener(new View.OnClickListener(){

		@Override
		public void onClick(View p1)
		{
		final EditText editText = new EditText(MainActivity.this);
		AlertDialog.Builder inputDialog = 
        new AlertDialog.Builder(MainActivity.this);
		inputDialog.setTitle("insert").setView(editText);
		inputDialog.setPositiveButton("ok", 
        new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
            commit(editText.getText().toString());
			tv.setText(get());
			}
		}).setNeutralButton("oh reset",new DialogInterface.OnClickListener(){

			@Override
			public void onClick(DialogInterface p1, int p2)
			{
			commit("null");
			tv.setText(R.string.hello_world);
			}
		}).setNegativeButton("cancel",new DialogInterface.OnClickListener(){

			@Override
			public void onClick(DialogInterface p1, int p2)
			{
			// TODO: Implement this method
			}
		}).show();
		}
	});
	}
	public void commit(String pref){
	SharedPreferences sharedPreferences = getSharedPreferences("content", MODE_WORLD_READABLE);  
	SharedPreferences.Editor editor = sharedPreferences.edit();  
    editor.putString("content", pref);
    editor.commit(); 
	}
	public String get(){
	SharedPreferences sPres=getSharedPreferences("content",MODE_WORLD_READABLE);
    String str=sPres.getString("content","null");
    return str;
	}
}
