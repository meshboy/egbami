package com.example.root.egbami;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class edit_contact extends Fragment implements View.OnClickListener{

    private EditText name;
    private EditText phone;
    private EditText email;
    private Button save;
    private Button delete;
    private Button exit;


    private int contact_id =0 ;

    View view;

    public edit_contact() {
        // Required empty public constructor
    }

    public static edit_contact newInstance(Bundle os)
    {
        edit_contact fragment = new edit_contact();

        fragment.setArguments(os);

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.edit_contacts, container, false);

        name = (EditText) view.findViewById(R.id.edit_name);
        phone = (EditText) view.findViewById(R.id.edit_phone);
        email = (EditText) view.findViewById(R.id.edit_email);

        save = (Button) view.findViewById(R.id.contact_save);
        delete = (Button) view.findViewById(R.id.contact_del);






        save.setOnClickListener(this);
        delete.setOnClickListener(this);


//        contact_id =0;

//        Intent intent = getIntent();
//
//        contact_id = intent.getIntExtra("contact", 0);

       try{
           Bundle re = getArguments();
           contact_id = re.getInt("contact", 0);
       }
       catch (Exception e)
       {
//           Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
       }

        dataRepo getContactData = new dataRepo(getActivity());

        contactProfile contact = new contactProfile();

        contact = getContactData.getContactById(contact_id);

        name.setText(contact.contactName);
        phone.setText(contact.contactPhone);
        email.setText(contact.contactEmail);





        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == (R.id.contact_save)) {

            dataRepo getContactData = new dataRepo(getActivity());

            contactProfile contact = new contactProfile();

            if (!((name.getText().toString().length() <= 0)&&(email.getText().toString().length() <=0)))
            {
                contact.contactName = name.getText().toString();
                contact.contactEmail = email.getText().toString();
                contact.contactPhone = phone.getText().toString();

                contact.contatcId = contact_id;

                if (contact_id == 0) {
                    contact_id = getContactData.insertContact(contact);
                    Toast.makeText(getActivity(), "New Contact has been added", Toast.LENGTH_SHORT).show();
                    getFragmentManager().beginTransaction().add(R.id.container, new list_contact()).addToBackStack(null).commit();
                }
//            else {
//                getContactData.updateContact(contact);
//                Toast.makeText(getActivity(), "Contact has been updated", Toast.LENGTH_SHORT).show();
//
//            }
            }
            else
            {
                Toast.makeText(getActivity(), "Name and Phone field cant be empty", Toast.LENGTH_SHORT).show();
            }


        }
        if (v.getId() == (R.id.contact_del))
        {
            dataRepo getContactData = new dataRepo(getActivity());

            contactProfile contact = new contactProfile();

            getContactData.deleteContact(contact_id);
            Toast.makeText(getActivity(), "Contact has been deleted", Toast.LENGTH_SHORT).show();
//            getActivity().finish();

            getFragmentManager().beginTransaction().add(R.id.container, new list_contact()).commit();

        }


    }



}
