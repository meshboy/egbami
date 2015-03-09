package com.example.root.egbami;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by root on 3/6/15.
 */
public class emailClass extends Activity
{
    public void sendEmail(String message, String address)
    {

        String subject = getResources().getString(R.string.emailEmergency);

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, address);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);
        emailIntent.setType(   "message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Email"));

    }
}
