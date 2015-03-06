package com.example.root.egbami;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
 * A simple {@link Fragment} subclass.
 */
public class list_contact extends Fragment implements View.OnClickListener {

    View view;
    private TextView contactview;


    ListView lv;
    private int contact_id =0;
    Button add;
    Button fetchAll;


    public list_contact() {
        // Required empty public constructor
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.btnAdd) {
            Bundle os = new Bundle();
            os.putInt("contact", 0);

            getFragmentManager().beginTransaction()
                    .add(R.id.container, new edit_contact())
                    .commit();
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.contacts, container, false);




        add = (Button) view.findViewById(R.id.btnAdd);

//        fetchAll = (Button) view.findViewById(R.id.fetchAll);

        add.setOnClickListener(this);
//        fetchAll.setOnClickListener(this);
//        contactview = (TextView) view.findViewById(R.id.contact_id);





//        lv = (ListView) view.findViewById(R.id.list_view);

      //  view();

        dataRepo repo = new dataRepo(getActivity());

        ArrayList<HashMap<String, String>> contactList =  repo.getContactList();
       try
       {
           if(contactList.size()!=0) {
               ListView lv = (ListView) view.findViewById(R.id.list_view);
               lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                   @Override
                   public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                       contactview = (TextView) view.findViewById(R.id.contact_id);
                       String contactId = contactview.getText().toString();

                       Bundle os = new Bundle();
                       os.putInt("contact", Integer.parseInt(contactId));

                       getFragmentManager().beginTransaction().add(R.id.container, edit_contact.newInstance(os)).commit();
                   }
               });
               ListAdapter adapter = new SimpleAdapter( getActivity(),contactList, R.layout.view_contacts_entry, new String[] { "id","name"}, new int[] {R.id.contact_id, R.id.contact_name});
               lv.setAdapter(adapter);
           }else{
               Toast.makeText(getActivity(),"No Contact added!",Toast.LENGTH_SHORT).show();
           }
       }
       catch(Exception e)
       {
           Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
       }


        return view;
    }



}
