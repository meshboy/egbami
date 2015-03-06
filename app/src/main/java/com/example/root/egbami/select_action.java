package com.example.root.egbami;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by root on 2/20/15.
 */
public class select_action extends ActionBarActivity implements View.OnClickListener

{
    private ImageButton speed_dial;
    private ImageButton service;
    private ImageButton record;
    private ImageButton sos;
    private ImageButton about;
    private ImageButton onPressed;
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_action);



        speed_dial = (ImageButton) findViewById(R.id.speed_dial);
        service = (ImageButton) findViewById(R.id.service);
        record = (ImageButton) findViewById(R.id.record);
        sos = (ImageButton) findViewById(R.id.sos);
        about = (ImageButton) findViewById(R.id.about);



        about.setOnClickListener(this);
        speed_dial.setOnClickListener(this);
        service.setOnClickListener(this);
        record.setOnClickListener(this);
        sos.setOnClickListener(this);




    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        Intent intent = new Intent(Intent.ACTION_MAIN);
//
//        intent.addCategory(Intent.CATEGORY_HOME);
//
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(intent);
//        finish();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.speed_dial) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new list_contact())
                    .commit();
        }

        if(v.getId() == R.id.service)
        {
            Intent intent = new Intent(this, emergency_tabs.class);
            startActivity(intent);
        }
        if(v.getId() == R.id.record)
        {
            getSupportFragmentManager().beginTransaction().add(R.id.container, new med_history_frag()).commit();
        }
        if(v.getId() == R.id.sos)
        {
            getSupportFragmentManager().beginTransaction().add(R.id.container, new sos()).commit();

        }

        if(v.getId() == R.id.about)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new sos()).commit();
        }

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
        if (id == R.id.emer_cont) {
             getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new list_contact())
                    .commit();
        }

        if (id == R.id.emer_serv) {
            Intent intent = new Intent(this, emergency_tabs.class);
            startActivity(intent);
        }
        if (id == R.id.med_history) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, new med_history_frag()).commit();
        }
        if (id == R.id.sos) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, new sos()).commit();
        }
        return super.onOptionsItemSelected(item);
    }
}
