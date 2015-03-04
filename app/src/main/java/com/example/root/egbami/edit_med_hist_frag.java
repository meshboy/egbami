package com.example.root.egbami;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class edit_med_hist_frag extends Fragment implements View.OnClickListener{


    EditText name, allergy, bldgrp, med_cond;
    RadioGroup natnty, diabetic, insurance, medication;
    RadioButton nija, other, dia_yes, dia_no,  yesIn, noIn, yesMed, noMed;
    Button delete, save;
    int history_id =0;
    private String nation_value, diabetic_value, insurace_value, medication_value;


    public edit_med_hist_frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.edit_med_history, container, false);

        name = (EditText) view.findViewById(R.id.med_name);
        allergy = (EditText) view.findViewById(R.id.allergy);
        bldgrp = (EditText) view.findViewById(R.id.bldgrp);
        med_cond = (EditText) view.findViewById(R.id.med_con);

        natnty = (RadioGroup) view.findViewById(R.id.nationgrp_med);
        int selectNation = natnty.getCheckedRadioButtonId();
        nija = (RadioButton) view.findViewById(selectNation);
        other = (RadioButton) view.findViewById(R.id.other);


        diabetic = (RadioGroup) view.findViewById(R.id.diabetic_group);
        int selectDiabetic = diabetic.getCheckedRadioButtonId();
        dia_yes = (RadioButton) view.findViewById(selectDiabetic);
        dia_no =(RadioButton) view.findViewById(R.id.dia_no);


        insurance = (RadioGroup) view.findViewById(R.id.med_ins);
        int select_insurance = insurance.getCheckedRadioButtonId();
        yesIn = (RadioButton) view.findViewById(R.id.yesIn);
        noIn = (RadioButton) view.findViewById(select_insurance);

        medication = (RadioGroup) view.findViewById(R.id.medication);
        int select_medication = medication.getCheckedRadioButtonId();
        yesMed = (RadioButton) view.findViewById(R.id.medon_yes);
        noMed = (RadioButton) view.findViewById(select_medication);

//
//        delete = (Button) view.findViewById(R.id.med_delete);
        save = (Button) view.findViewById(R.id.med_save);

//        delete.setOnClickListener(this);
        save.setOnClickListener(this);



        return view;
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.med_save)
        {
            dataRepo repo = new dataRepo(getActivity());
            med_hist history = new med_hist();

            history.med_allergy = allergy.getText().toString();
            history.med_name = name.getText().toString();
            history.med_bloodGrp = bldgrp.getText().toString();
            history.med_condition = med_cond.getText().toString();

            //get nationality

            if (other.isChecked())
            {
                history.med_nationality = "others";
            }else{
                history.med_nationality = nija.getText().toString();
            }


            //get diabetic

            if (dia_yes.isChecked())
            {
                history.med_diabetic = "yes";
            }else{
                history.med_diabetic = dia_no.getText().toString();
            }

            //get insuarce
            if (yesIn.isChecked())
            {
                history.med_insurance = "yes";
            }else{
                history.med_insurance = noIn.getText().toString();
            }

            //get medication
            if(yesMed.isChecked())
            {
                history.med_medication = "yes";
            }else{
                history.med_medication = noMed.getText().toString();
            }


            //save data
            history.med_id = history_id;

            if (history_id ==0)
            {
                history_id = repo.insertMedHistory(history);
                Toast.makeText(getActivity(), "Saved successfully" , Toast.LENGTH_SHORT).show();
            }

            else {
                repo.updateMed(history);
                Toast.makeText(getActivity(), "updated successfully", Toast.LENGTH_SHORT).show();
            }

        }

//        if (v.getId() == R.id.med_delete)
//        {
//            dataRepo repo = new dataRepo(getActivity());
//
//            medical_history history = new medical_history();
//
//            repo.deleteMed(history_id);
//            Toast.makeText(getActivity(), "Deleted successfully", Toast.LENGTH_SHORT).show();
//
//
//        }

    }


    public void view()
    {
//        contact_id =0;
//
//        Intent intent = getIntent();
//
//        contact_id = intent.getIntExtra("contact", 0);
//
//        dataRepo getContactData = new dataRepo(this);
//
//        contactProfile contact = new contactProfile();
//
//        contact = getContactData.getContactById(contact_id);
//
//        name.setText(contact.contactName);
//        phone.setText(contact.contactPhone);
//        email.setText(contact.contactEmail);

        history_id =0;

        dataRepo repo = new dataRepo(getActivity());

        med_hist history = new med_hist();

        history = repo.getHistoryId();

        name.setText(history.med_name);
        allergy.setText(history.med_allergy);
        med_cond.setText(history.med_condition);
        bldgrp.setText(history.med_bloodGrp);

        Toast.makeText(getActivity(), history.med_nationality, Toast.LENGTH_SHORT).show();

        if(!(history.med_nationality == nija.getText().toString()))
        {
            other.setChecked(true);
        }

        if (!(history.med_diabetic == "No"))
        {
            dia_yes.setChecked(true);
        }

        if(!(history.med_insurance == "No"))
        {
            yesIn.setChecked(true);
        }

        if(!(history.med_medication == "No"))
        {
            yesMed.setChecked(true);
        }





    }


}
