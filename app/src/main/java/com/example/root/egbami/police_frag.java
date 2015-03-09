package com.example.root.egbami;


import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class police_frag extends Fragment implements View.OnClickListener{

    TextView txt; TextView adama; TextView awka; TextView bauchi; TextView bay; TextView benue; TextView borno;
    TextView cross; TextView delta; TextView ebny; TextView edo; TextView ekiti; TextView enugu; TextView gombe;
    TextView imo; TextView jigawa; TextView kaduna; TextView kano; TextView katsina; TextView kebbi; TextView kogi;
    TextView kwara; TextView lagos; TextView nasa; TextView niger; TextView ogun; TextView ondo; TextView osun;
    TextView oyo; TextView platu; TextView river; TextView sokoto; TextView taraba; TextView gobe;
    public police_frag() {
        // Required empty public constructor
    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.police, container, false);
        txt = (TextView) view.findViewById(R.id.abia_);
        adama = (TextView) view.findViewById(R.id.adama_);
        awka = (TextView) view.findViewById(R.id.awka_);
        bauchi = (TextView) view.findViewById(R.id.bauchi_);
        bay = (TextView) view.findViewById(R.id.bay_);
        benue = (TextView) view.findViewById(R.id.benue_);
        borno = (TextView) view.findViewById(R.id.borno_);
        cross = (TextView) view.findViewById(R.id.cross_);
        delta = (TextView) view.findViewById(R.id.delta_);
        ebny = (TextView) view.findViewById(R.id.ebony_);
        edo = (TextView) view.findViewById(R.id.edo_);
        ekiti = (TextView) view.findViewById(R.id.ekiti_);
        enugu = (TextView) view.findViewById(R.id.enugu_);
        gombe = (TextView) view.findViewById(R.id.gombe_);
        imo = (TextView) view.findViewById(R.id.imo_);
        jigawa = (TextView) view.findViewById(R.id.jigawa_);
        kaduna = (TextView) view.findViewById(R.id.kaduna_);
        kano = (TextView) view.findViewById(R.id.kano_);
        katsina = (TextView) view.findViewById(R.id.katsina_);
        kebbi = (TextView) view.findViewById(R.id.kebbi_);
        kogi = (TextView) view.findViewById(R.id.kogi_);
        kwara = (TextView) view.findViewById(R.id.kwara_);
        lagos = (TextView) view.findViewById(R.id.lagos_);
        nasa = (TextView) view.findViewById(R.id.nasa_);
        niger = (TextView) view.findViewById(R.id.niger_);
        ogun = (TextView) view.findViewById(R.id.ogun_);
        ondo = (TextView) view.findViewById(R.id.ondo_);
        osun = (TextView) view.findViewById(R.id.osun_);
        oyo = (TextView) view.findViewById(R.id.oyo_);
        platu = (TextView) view.findViewById(R.id.plateu_);
        river = (TextView) view.findViewById(R.id.river_);
        sokoto = (TextView) view.findViewById(R.id.sokoto_);
        taraba = (TextView) view.findViewById(R.id.taraba_);
        gobe = (TextView) view.findViewById(R.id.gombe_);
        adama = (TextView) view.findViewById(R.id.adama_);
        awka = (TextView) view.findViewById(R.id.awka);
        txt = (TextView) view.findViewById(R.id.abia_);
        adama = (TextView) view.findViewById(R.id.adama_);
        awka = (TextView) view.findViewById(R.id.awka);

        txt.setOnClickListener(this);

        kano.setOnClickListener(this);
        adama.setOnClickListener(this);
        katsina.setOnClickListener(this);
        awka.setOnClickListener(this);
        kebbi.setOnClickListener(this);
        bauchi.setOnClickListener(this);
        kogi.setOnClickListener(this);
        bay.setOnClickListener(this);
        kwara.setOnClickListener(this);
        benue.setOnClickListener(this);
        borno.setOnClickListener(this);
        cross.setOnClickListener(this);
        delta.setOnClickListener(this);
        ebny.setOnClickListener(this);
        edo.setOnClickListener(this);
        ekiti.setOnClickListener(this);
        enugu.setOnClickListener(this);
        gobe.setOnClickListener(this);
        imo.setOnClickListener(this);
        jigawa.setOnClickListener(this);
        kaduna.setOnClickListener(this);

        lagos.setOnClickListener(this);
        nasa.setOnClickListener(this);
        niger.setOnClickListener(this);
        ogun.setOnClickListener(this);
        ondo.setOnClickListener(this);
        osun.setOnClickListener(this);
        oyo.setOnClickListener(this);

        platu.setOnClickListener(this);
        river.setOnClickListener(this);
        sokoto.setOnClickListener(this);
        taraba.setOnClickListener(this);
        gobe.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.abia_) {
            Intent mynumber = new Intent(Intent.ACTION_CALL);
            mynumber.setData(Uri.parse("tel:"+txt.getText().toString()));
 
            startActivity(mynumber);
        }
        else if (v.getId() == R.id.adama_) {
            Intent mynumber = new Intent(Intent.ACTION_CALL);
            mynumber.setData(Uri.parse("tel:"+adama.getText().toString()));
 
            startActivity(mynumber);
        }
        else if (v.getId() == R.id.awka_) {
            Intent mynumber = new Intent(Intent.ACTION_CALL);
            mynumber.setData(Uri.parse("tel:"+awka.getText().toString()));
 
            startActivity(mynumber);
        }
        else if (v.getId() == R.id.bauchi_) {
            Intent mynumber = new Intent(Intent.ACTION_CALL);
            mynumber.setData(Uri.parse("tel:"+bauchi.getText().toString()));
 
            startActivity(mynumber);
        }
        else if (v.getId() == R.id.bay_) {
            Intent mynumber = new Intent(Intent.ACTION_CALL);
            mynumber.setData(Uri.parse("tel:"+bay.getText().toString()));
 
            startActivity(mynumber);
        }
        else if (v.getId() == R.id.benue_) {
            Intent mynumber = new Intent(Intent.ACTION_CALL);
            mynumber.setData(Uri.parse("tel:"+benue.getText().toString()));
 
            startActivity(mynumber);
        }
        else if (v.getId() == R.id.borno_) {
            Intent mynumber = new Intent(Intent.ACTION_CALL);
            mynumber.setData(Uri.parse("tel:"+borno.getText().toString()));
 
            startActivity(mynumber);
        }
        else if (v.getId() == R.id.cross_) {
            Intent mynumber = new Intent(Intent.ACTION_CALL);
            mynumber.setData(Uri.parse("tel:"+cross.getText().toString()));
 
            startActivity(mynumber);
        }
        else if (v.getId() == R.id.delta_) {
            Intent mynumber = new Intent(Intent.ACTION_CALL);
            mynumber.setData(Uri.parse("tel:"+delta.getText().toString()));
 
            startActivity(mynumber);
        }
        else if (v.getId() == R.id.ebony_) {
            Intent mynumber = new Intent(Intent.ACTION_CALL);
            mynumber.setData(Uri.parse("tel:"+ebny.getText().toString()));
 
            startActivity(mynumber);
        }
        else if (v.getId() == R.id.edo_) {
            Intent mynumber = new Intent(Intent.ACTION_CALL);
            mynumber.setData(Uri.parse("tel:"+edo.getText().toString()));
 
            startActivity(mynumber);
        }
        else if (v.getId() == R.id.ekiti_) {
            Intent mynumber = new Intent(Intent.ACTION_CALL);
            mynumber.setData(Uri.parse("tel:"+ekiti.getText().toString()));
 
            startActivity(mynumber);
        }
        else if (v.getId() == R.id.enugu_) {
            Intent mynumber = new Intent(Intent.ACTION_CALL);
            mynumber.setData(Uri.parse("tel:"+enugu.getText().toString()));
 
            startActivity(mynumber);
        }
        else if (v.getId() == R.id.gombe_) {
            Intent mynumber = new Intent(Intent.ACTION_CALL);
            mynumber.setData(Uri.parse("tel:"+gobe.getText().toString()));
 
            startActivity(mynumber);
        }
        else if (v.getId() == R.id.imo_) {
            Intent mynumber = new Intent(Intent.ACTION_CALL);
            mynumber.setData(Uri.parse("tel:"+imo.getText().toString()));
 
            startActivity(mynumber);
        }
        else if (v.getId() == R.id.jigawa_) {
            Intent mynumber = new Intent(Intent.ACTION_CALL);
            mynumber.setData(Uri.parse("tel:"+jigawa.getText().toString()));
 
            startActivity(mynumber);
        }
        else if (v.getId() == R.id.kaduna_) {
            Intent mynumber = new Intent(Intent.ACTION_CALL);
            mynumber.setData(Uri.parse("tel:"+kaduna.getText().toString()));
 
            startActivity(mynumber);
        }
        else if (v.getId() == R.id.kano_) {
            Intent mynumber = new Intent(Intent.ACTION_CALL);
            mynumber.setData(Uri.parse("tel:"+kano.getText().toString()));
 
            startActivity(mynumber);
        }
        else if (v.getId() == R.id.katsina_) {
            Intent mynumber = new Intent(Intent.ACTION_CALL);
            mynumber.setData(Uri.parse("tel:"+katsina.getText().toString()));
 
            startActivity(mynumber);
        }
        else if (v.getId() == R.id.kebbi_) {
            Intent mynumber = new Intent(Intent.ACTION_CALL);
            mynumber.setData(Uri.parse("tel:"+kebbi.getText().toString()));
 
            startActivity(mynumber);
        }
        else if (v.getId() == R.id.kogi_) {
            Intent mynumber = new Intent(Intent.ACTION_CALL);
            mynumber.setData(Uri.parse("tel:"+kogi.getText().toString()));
 
            startActivity(mynumber);
        }
        else if (v.getId() == R.id.kwara_) {
            Intent mynumber = new Intent(Intent.ACTION_CALL);
            mynumber.setData(Uri.parse("tel:"+kwara.getText().toString()));
 
            startActivity(mynumber);
        }
        else if (v.getId() == R.id.lagos_) {
            Intent mynumber = new Intent(Intent.ACTION_CALL);
            mynumber.setData(Uri.parse("tel:"+lagos.getText().toString()));
 
            startActivity(mynumber);
        }
        else if (v.getId() == R.id.nasa_) {
            Intent mynumber = new Intent(Intent.ACTION_CALL);
            mynumber.setData(Uri.parse("tel:"+nasa.getText().toString()));
 
            startActivity(mynumber);
        }
        else if (v.getId() == R.id.niger_) {
            Intent mynumber = new Intent(Intent.ACTION_CALL);
            mynumber.setData(Uri.parse("tel:"+niger.getText().toString()));
 
            startActivity(mynumber);
        }
        else if (v.getId() == R.id.ogun_) {
            Intent mynumber = new Intent(Intent.ACTION_CALL);
            mynumber.setData(Uri.parse("tel:"+ogun.getText().toString()));
 
            startActivity(mynumber);
        }
        else if (v.getId() == R.id.ondo_) {
            Intent mynumber = new Intent(Intent.ACTION_CALL);
            mynumber.setData(Uri.parse("tel:"+ondo.getText().toString()));
 
            startActivity(mynumber);
        }
        else if (v.getId() == R.id.osun_) {
            Intent mynumber = new Intent(Intent.ACTION_CALL);
            mynumber.setData(Uri.parse("tel:"+osun.getText().toString()));
 
            startActivity(mynumber);
        }
        else if (v.getId() == R.id.oyo_) {
            Intent mynumber = new Intent(Intent.ACTION_CALL);
            mynumber.setData(Uri.parse("tel:"+oyo.getText().toString()));
 
            startActivity(mynumber);
        }

        else if (v.getId() == R.id.plateu_) {
            Intent mynumber = new Intent(Intent.ACTION_CALL);
            mynumber.setData(Uri.parse("tel:"+platu.getText().toString()));
 
            startActivity(mynumber);
        }
        else if (v.getId() == R.id.river_) {
            Intent mynumber = new Intent(Intent.ACTION_CALL);
            mynumber.setData(Uri.parse("tel:"+river.getText().toString()));
 
            startActivity(mynumber);
        }
        else if (v.getId() == R.id.sokoto_) {
            Intent mynumber = new Intent(Intent.ACTION_CALL);
            mynumber.setData(Uri.parse("tel:"+sokoto.getText().toString()));
 
            startActivity(mynumber);
        }
        else if (v.getId() == R.id.taraba_) {
            Intent mynumber = new Intent(Intent.ACTION_CALL);
            mynumber.setData(Uri.parse("tel:"+taraba.getText().toString()));
 
            startActivity(mynumber);
        }
        else if (v.getId() == R.id.gombe_) {
            Intent mynumber = new Intent(Intent.ACTION_CALL);
            mynumber.setData(Uri.parse("tel:"+gombe.getText().toString()));
 
            startActivity(mynumber);
        }
    }
}
