package com.example.david.appblog;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import static android.widget.TextView.*;


public class MyActivity extends ListActivity {

protected String[] mAndroidNames;
private TextView textview;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        textview=(TextView) findViewById(R.id.textView1);
        Resources resources = getResources();
        mAndroidNames = resources.getStringArray(R.array.android_names);
        if (mAndroidNames != null) {


            textview.setVisibility(View.INVISIBLE);

        }

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,mAndroidNames);
        setListAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
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
