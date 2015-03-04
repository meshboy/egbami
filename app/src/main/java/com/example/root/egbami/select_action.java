package com.example.root.egbami;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by root on 2/20/15.
 */
public class select_action extends ActionBarActivity implements View.OnClickListener
{
    private ImageButton run;
    private ImageButton service;
    private ImageButton history;
    private ImageButton sos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_action);



        run = (ImageButton) findViewById(R.id.run);
//        run.setBackgroundColor(Color.TRANSPARENT);
        service = (ImageButton) findViewById(R.id.service);
        history = (ImageButton) findViewById(R.id.history);
        sos = (ImageButton) findViewById(R.id.sos);

        run.setOnClickListener(this);
        service.setOnClickListener(this);
        history.setOnClickListener(this);
        sos.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.run)
        {
            Intent intent = new Intent(this, com.example.root.egbami.list_contact.class);
            startActivity(intent);

        }

        if(v.getId() == R.id.service)
        {
            Intent intent = new Intent(this, emergency_tabs.class);
            startActivity(intent);
        }
        if(v.getId() == R.id.history)
        {
            Intent intent = new Intent(this, medical_hist_tabs.class);
            startActivity(intent);

        }
        if(v.getId() == R.id.run)
        {

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
            return true;
        }

        if (id == R.id.emer_serv) {
            return true;
        }
        if (id == R.id.med_history) {
            return true;
        }
        if (id == R.id.sos) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
