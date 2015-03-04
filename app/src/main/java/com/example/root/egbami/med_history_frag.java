package com.example.root.egbami;


import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class med_history_frag extends Fragment {

    Button edit;
    private TextView name, natn, allergy, bldgrp, diabetic, med_cond, med_ins, on_med;
    private int history_id = 1;

    med_hist history;



    public med_history_frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.medical_history, container, false);


        name = (TextView) view.findViewById(R.id.name);
        natn = (TextView) view.findViewById(R.id.nationality);
        allergy = (TextView) view.findViewById(R.id.allergy);
        bldgrp = (TextView) view.findViewById(R.id.blood_group);
        diabetic = (TextView) view.findViewById(R.id.diabetic);
        med_cond = (TextView) view.findViewById(R.id.med_condition);
        med_ins = (TextView) view.findViewById(R.id.insurance);
        on_med = (TextView) view.findViewById(R.id.on_med);


        dataRepo repo = new dataRepo(getActivity());
        history = new med_hist();

        history = repo.getHistoryId();
        view();



        return view;



    }

    public void view ()
    {
        if (history != null)
        {
            name.setText(history.med_name);
            natn.setText(history.med_nationality);
            allergy.setText(history.med_allergy);
            bldgrp.setText(history.med_bloodGrp);
            diabetic.setText(history.med_diabetic);
            med_cond.setText(history.med_condition);
            med_ins.setText(history.med_insurance);
            on_med.setText(history.med_medication);

        }

    }





}
