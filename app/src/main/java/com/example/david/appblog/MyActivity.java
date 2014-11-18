package com.example.david.appblog;

import android.app.Activity;
import android.app.ListActivity;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.david.appblog.R;

import java.io.IOException;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class MyActivity extends ListActivity {

    protected String [] mBlogPostTitles;
    ArrayAdapter<String> adaptader;
    protected TextView textView;
    final static int NUMBER_OF_POSTS = 20;
    final static String TAG=MyActivity.class.getSimpleName();
    final static String URL_JSON = "http://itvocationalteacher.blogspot.com/feeds/posts/default?alt=json";
    protected URL blogFeedUrl;
    protected HttpURLConnection connection;
    int code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        Resources resources = getResources();

        GetBlogPostTask getBlogPostTask = new GetBlogPostTask();
       /* adaptader = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mBlogPostTitles);
        setListAdapter(adaptader);
          if(mBlogPostTitles != null) {
              adaptader = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mBlogPostTitles);
              setListAdapter(adaptader);
          }*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    class GetBlogPostTask extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] params) {
            int responseCode=-1;
            Log.e(TAG,"code"+responseCode);

            try {
                blogFeedUrl = new URL(URL_JSON);
                connection=(HttpURLConnection)blogFeedUrl.openConnection();
                connection.connect();
                responseCode = connection.getResponseCode();

                Log.i(TAG,"Code: " + code);
            }catch(MalformedURLException e){
                Log.e(TAG, "exception caught:", e);
            }catch(IOException e1){
                Log.e(TAG,"exception io caught", e1);
            }catch(Exception e){
                Log.e(TAG,"exception caught", e);
            }
            Log.e(TAG,"code"+responseCode);
            return "code"+responseCode;


        }
    }
}
