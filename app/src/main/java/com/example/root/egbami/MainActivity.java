package com.example.root.egbami;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    //    private ImageButton start;
    private TextView start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        start = (ImageButton) findViewById(R.id.start_button);

        start = (TextView) findViewById(R.id.start);

        start.setOnClickListener(this);


        try
        {
            Intent intent = new Intent(MainActivity.this, com.example.root.egbami.select_action.class);
            startActivity(intent);

            Thread.sleep(3000);
        }
        catch(Exception e)
        {
            Log.d("EGAMI", e.getMessage());
        }


        start = (TextView) findViewById(R.id.start);
        start.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.start)
        {
            Intent intent = new Intent(this, select_action.class);
            startActivity(intent);
        }

    }



//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }


}
