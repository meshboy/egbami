package com.example.root.egbami;


import android.app.ListActivity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by root on 2/20/15.
 */
public class list_contact extends ActionBarActivity implements android.view.View.OnClickListener
{

    Button add;
    Button fetchAll;
    TextView contactview;

    @Override
    public void onClick(View view) {
        if (view== findViewById(R.id.btnAdd)){

            Intent intent = new Intent(this, edit_contact.class);
            intent.putExtra("contact",0);
            startActivity(intent);

        }

//        if (view.getId() == R.id)
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts);

        add = (Button) findViewById(R.id.btnAdd);

        fetchAll = (Button) findViewById(R.id.fetchAll);

        add.setOnClickListener(this);
        fetchAll.setOnClickListener(this);

        AnimationDrawable draw = (AnimationDrawable)fetchAll.getCompoundDrawables()[0];
        draw.start();

        view();
    }

    public void view ()
    {

        dataRepo repo = new dataRepo(this);

        ArrayList<HashMap<String, String>> contactList =  repo.getContactList();
        if(contactList.size()!=0) {
            ListView lv = (ListView) findViewById(R.id.list_view);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                    contactview = (TextView) view.findViewById(R.id.contact_id);
                    String contactId = contactview.getText().toString();
                    Intent objIndent = new Intent(getApplicationContext(), edit_contact.class);
                    objIndent.putExtra("contact", Integer.parseInt( contactId));
                    startActivity(objIndent);
                }
            });
            ListAdapter adapter = new SimpleAdapter( list_contact.this,contactList, R.layout.view_contacts_entry, new String[] { "id","name"}, new int[] {R.id.contact_id, R.id.contact_name});
            lv.setAdapter(adapter);
        }else{
            Toast.makeText(this,"No Contact added!",Toast.LENGTH_SHORT).show();
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
