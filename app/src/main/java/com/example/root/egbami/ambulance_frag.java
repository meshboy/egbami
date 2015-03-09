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
public class ambulance_frag extends Fragment implements View.OnClickListener{
        TextView emergency;

    public ambulance_frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.ambulance, container, false);
        emergency = (TextView) view.findViewById(R.id.emergency);
        emergency.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.emergency){
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:"+emergency.getText().toString()));
            startActivity(intent);
        }

    }
}
