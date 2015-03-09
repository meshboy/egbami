package com.example.root.egbami;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.telephony.SmsManager;
import android.widget.Toast;

/**
 * Created by root on 3/6/15.
 */
public class messageClass extends Activity
{
    public  void sendmessage(String number, String text)
    {
        String sent = "Message sent";
        String deliver = "Message delivered";


        PendingIntent sendIntent = PendingIntent.getBroadcast(getApplication(), 0, new Intent(sent), 0);
        PendingIntent deliverIntent = PendingIntent.getBroadcast(getApplication(), 0, new Intent(deliver), 0);

        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                switch (getResultCode())
                {
                    case Activity.RESULT_OK:
                        Toast.makeText(getApplicationContext(), "Message Sent", Toast.LENGTH_SHORT).show();
                        break;

                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                        Toast.makeText(getApplicationContext(), "Generic Failure", Toast.LENGTH_SHORT).show();
                        break;

                    case SmsManager.RESULT_ERROR_NO_SERVICE:
                        Toast.makeText(getApplicationContext(), "No Service", Toast.LENGTH_SHORT).show();
                        break;


                }

            }
        }, new IntentFilter(sent));


        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                switch(getResultCode())
                {

                    case Activity.RESULT_OK:
                        Toast.makeText(getApplicationContext(), "Message Delivered", Toast.LENGTH_SHORT).show();
                        break;

                    case Activity.RESULT_CANCELED:
                        Toast.makeText(getApplicationContext(), "Result Cancelled", Toast.LENGTH_SHORT).show();
                        break;


                }
            }
        }, new IntentFilter(deliver));


        //import sms class
        SmsManager smsManager = SmsManager.getDefault();

        //destionation, scAddres, , text, sentIntent, deliveryIntent

        smsManager.sendTextMessage(number, null, text, sendIntent, deliverIntent);

    }


}
