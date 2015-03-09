package com.example.root.egbami;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class fire_frag extends Fragment implements View.OnClickListener{

    TextView fireone; TextView firetwo; TextView firethree;

    public fire_frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fire, container, false);

        fireone = (TextView) view.findViewById(R.id.fireone);
        firetwo = (TextView) view.findViewById(R.id.firetwo);
        firethree = (TextView) view.findViewById(R.id.firethree);

        fireone.setOnClickListener(this);
        firetwo.setOnClickListener(this);
        firethree.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.fireone){
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + fireone.getText().toString()));
            startActivity(intent);
        }
        else if(v.getId() == R.id.firetwo){
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + firetwo.getText().toString()));
            startActivity(intent);

        }
        else if(v.getId() == R.id.firethree){
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + firethree.getText().toString()));
            startActivity(intent);
        }
    }
}
