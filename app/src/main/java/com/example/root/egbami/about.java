package com.example.root.egbami;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * A simple {@link Fragment} subclass.
 */
public class about extends Fragment {


    public about() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.about, container, false);
        InputStream file = getResources().openRawResource(R.raw.about);
        try{
            TextView txtview = (TextView) view.findViewById(R.id.about);
            String strfile = InputStreamtoString(file);
            txtview.setText(strfile);

        }catch(Exception e){
            Toast toast = Toast.makeText(getActivity(),"File not readable",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }

        return view;
    }



    private String InputStreamtoString(InputStream filess) throws IOException{
        StringBuffer sbuffer = new StringBuffer();
        DataInputStream dataio = new DataInputStream(filess);
        String strline = null;

        while((strline = dataio.readLine()) != null){
            sbuffer.append((strline + "\n"));

        }
        dataio.close();
        filess.close();
        return sbuffer.toString();
    }


}
