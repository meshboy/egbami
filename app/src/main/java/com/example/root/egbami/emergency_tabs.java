package com.example.root.egbami;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.logging.Handler;
/**
 * Created by root on 3/2/15.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class emergency_tabs  extends ActionBarActivity implements
        android.support.v7.app.ActionBar.TabListener
{
    ViewPager viewpager;

    android.support.v7.app.ActionBar actionBar;


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emergency_view_layer);


        viewpager = (ViewPager) findViewById(R.id.emer_pager);


        FragmentManager fragManager =    getSupportFragmentManager();

        viewpager.setAdapter(new myClass(fragManager));
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        actionBar = getSupportActionBar();

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
//        actionBar.setBackgroundDrawable(new ColorDrawable(143));

        android.support.v7.app.ActionBar.Tab tab1;
        tab1 = actionBar.newTab();
        tab1.setText( "Police");

        tab1.setTabListener(this);

        android.support.v7.app.ActionBar.Tab tab2 = actionBar.newTab();
        tab2.setText("Fire");
        tab2.setTabListener(this);

        android.support.v7.app.ActionBar.Tab tab3 = actionBar.newTab();
        tab3.setText("Ambulance");
        tab3.setTabListener(this);

//        android.support.v7.app.ActionBar.Tab tab3 = actionBar.newTab();
//        tab3.setText("Tab 3");
//        tab3.setTabListener(this);

        actionBar.addTab(tab1);
        actionBar.addTab(tab2);
        actionBar.addTab(tab3);
//        actionBar.addTab(tab3);


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
//        if (id == R.id.emer_cont) {
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.container, new list_contact())
//                    .commit();
//        }
//
//        if (id == R.id.emer_serv) {
//            return true;
//        }
//        if (id == R.id.med_history) {
//            getSupportFragmentManager().beginTransaction().add(R.id.container, new med_history_frag()).commit();
//        }
//        if (id == R.id.sos) {
//            getSupportFragmentManager().beginTransaction().add(R.id.container, new sos()).commit();
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
    @Override
    public void onTabSelected(android.support.v7.app.ActionBar.Tab tab,
                              android.support.v4.app.FragmentTransaction fragmentTransaction) {

        viewpager.setCurrentItem( tab.getPosition());
//        Log.d(TAG, String.valueOf(tab.getPosition()));

    }

    @Override
    public void onTabUnselected(android.support.v7.app.ActionBar.Tab tab,
                                android.support.v4.app.FragmentTransaction fragmentTransaction) {

//        Log.d(TAG, String.valueOf(tab.getPosition()));



    }

    @Override
    public void onTabReselected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction
            fragmentTransaction) {

//        Log.d(TAG, String.valueOf(tab.getPosition()));

    }
//
//    @Override
//    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
//
//    }
//
//    @Override
//    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
//
//    }
//
//    @Override
//    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
//
//    }

//    @Override
//    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
//
//    }
//
//    @Override
//    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
//
//    }
//
//    @Override
//    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
//
//    }


}


class  myClass extends FragmentPagerAdapter{

    public myClass (FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment frag = null;

        if (position  == 0)
        {
            frag = new police_frag();
        }
        if (position == 1)
        {
            frag = new fire_frag();
        }
        if (position == 2)
        {
            frag = new ambulance_frag();
        }


        return frag;
    }

    @Override
    public int getCount() {
        return 3;
    }
}