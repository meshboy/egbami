package com.example.root.egbami;


import android.app.ActionBar;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class sos extends ActionBarActivity {

    private String mail="";
    private String num ="";

    private String message="";
    private String locateMe="";

    private ImageButton smsButton;
    private ImageButton emailButton;
    private EditText editLocation;

    private void updatewitnewLocation(Location location) {
        String latlongstring;


        String addstring = "No address found";


        if(location !=null){
            double lat = location.getLatitude();
            double lon = location.getLongitude();
            latlongstring ="Lat:" + lat + "\nLong:" + lon;

            double lats = location.getLatitude();
            double lons = location.getLongitude();
            Geocoder gc = new Geocoder(this, Locale.ENGLISH);
            try{
                List<Address> address = gc.getFromLocation(lats, lons, 1);
                StringBuilder sb = new StringBuilder();
                if(address.size() > 0){
                    Address myadd = address.get(0);
                    for(int i = 0; i<myadd.getMaxAddressLineIndex(); i++){
                        sb.append(myadd.getAddressLine(i)).append(" ");
//                        sb.append(myadd.getLocality()).append("\n");
                        //sb.append(myadd.getPostalCode()).append("\n");
                        sb.append(myadd.getCountryName()).append("\r");
                    }
                    addstring = sb.toString();
                }

            }
            catch(Exception e){

            }

        }else{
            latlongstring = "Address not available. Please check device.";
        }
        editLocation.setText("Please come to my aid. "+"\n"+"\n"+"\n" +"My current location is: "+ latlongstring + "\n"+"\n"+"\n"
                        + "Name of location: "+addstring
        );

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sos);


        smsButton = (ImageButton) findViewById(R.id.mesg);
        emailButton = (ImageButton) findViewById(R.id.email);
        editLocation = (EditText) findViewById(R.id.location);





        LocationManager locationmanager;
        String context = Context.LOCATION_SERVICE;
        locationmanager = (LocationManager) getSystemService(context);

        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(true);
        criteria.setPowerRequirement(Criteria.POWER_LOW);
        String providers = locationmanager.getBestProvider(criteria,true);
        String provider =locationmanager.GPS_PROVIDER;
        Location location = locationmanager.getLastKnownLocation(provider);
        updatewitnewLocation(location);
        locationmanager.requestLocationUpdates(providers, 2000,10, locationlistener);

//        Button sendNumber = (Button) findViewById(R.id.send_b);
//        Button sendMail = (Button) findViewById(R.id.send_a);

        try{
            dataRepo repo = new dataRepo(this);

            ArrayList<HashMap<String, String>> contactList =  repo.getphoneAndEmail();


            String[] replaceEmail = new String[contactList.size()];
            String[] replacePhone = new String[contactList.size()];
            String[] Myvalues = new String[contactList.size()];
            String[] Myvalues1 = new String[contactList.size()];
            String[] Myvalues2 = new String[contactList.size()];


            //extract mails and phone numbers
            for (int i=0; i<contactList.size(); i++)

            {
                replaceEmail[i]=contactList.get(i).toString().replace("email=", "");
                replacePhone[i] = replaceEmail[i];
            }

            for (int i=0; i<contactList.size(); i++)

            {
//               Log.d("VALUES", valueEmail[i]);
                replacePhone[i]=replaceEmail[i].toString().replace("phone=", "");
            }
            for (int i=0; i<contactList.size(); i++)

            {
                Myvalues[i] = replacePhone[i];
//

//               Log.d("VALUES", replacePhone[i]);
//                valueEmail[i]=contactList.get(i).toString().replace("phone=", "");
            }
            for (int i=0; i<contactList.size(); i++)

            {
                Myvalues1[i]=Myvalues[i].toString().replace("{", "");
//                replacePhone[i] = replaceEmail[i];
            }

            for (int i=0; i<contactList.size(); i++)

            {
                Myvalues2[i]=Myvalues1[i].toString().replace("}", "");

            }



            //get the numbers and emails from the extracted values
            for (String value: Myvalues2)

            {
                String [] s2 = value.split(",");


                for (String result: s2)
                {


                    if (result.matches("([a-z]|[0-9])+@+[a-z]+.com"))
                    {

                        mail = mail + result + " ";
                    }

                    else
                    {
//                        num = num + result + " ";
                        num = result;


                    }

                }

            }


        }

        catch (Exception e)
        {

        }

        //get message to send


        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.d("MAIL", arrayMails[0]);

                sendEmail(editLocation.getText().toString(), mail);
//                Log.d("mail", mail);

            }
        });

        smsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.d("MAIL", arrayMails[0]);
                try{
                    sendmsg(num, editLocation.getText().toString() );
                }
                catch(Exception e)
                {
                    Toast.makeText(getApplication(), "Add at least one contact in your speed dial", Toast.LENGTH_SHORT).show();
                }



            }
        });


}

    public void sendEmail(String message, String address)
    {
        String array[] = address.split(" ");

        String subject = getResources().getString(R.string.emailEmergency);

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, array);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);
        emailIntent.setType(   "message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Email"));

    }




    protected void sendmsg(String number, String text){

        String send = "Message sent";
        String deliver = "Message delivered";

        /**
         * A PendingIntent specifies an action to take in the future.
         * It lets you pass a future Intent to another application and allow that application
         * to execute that Intent as if it had the same permissions as your application, whether
         * or not your application is still around when the Intent is eventually invoked.It is a
         * token that you give to a foreign application which allows the foreign application to use
         * your application’s permissions to execute a predefined piece of code.
         */

        PendingIntent sendIntent = PendingIntent.getBroadcast(this, 0, new Intent(send), 0);
        PendingIntent deliverIntent = PendingIntent.getBroadcast(this, 0, new Intent(deliver), 0);

        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                switch(getResultCode())
                {
                    case Activity.RESULT_OK:
                        Toast.makeText(context, "Message sent", Toast.LENGTH_SHORT).show();
                        break;

                    case SmsManager.RESULT_ERROR_NO_SERVICE:
                        Toast.makeText(context, "No Service", Toast.LENGTH_SHORT).show();
                        break;

                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                        Toast.makeText(context, "Generic Failure", Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        }, new IntentFilter(send));

        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                switch (getResultCode())
                {
                    case Activity.RESULT_OK :
                        Toast.makeText(context, "Message Delivered", Toast.LENGTH_SHORT).show();
                        break;

                    case Activity.RESULT_CANCELED:
                        Toast.makeText(context, "Result cancelled", Toast.LENGTH_SHORT).show();
                        break;
                }


            }
        }, new IntentFilter(deliver));


        //import the sms class
        SmsManager sms = SmsManager.getDefault();
        //destionation, scAddres, , text, sentIntent, deliveryIntent

            sms.sendTextMessage(number, null, text, sendIntent, deliverIntent);

    }


    private final LocationListener locationlistener = new LocationListener() {

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onProviderEnabled(String provider) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onProviderDisabled(String provider) {
            updatewitnewLocation(null);
        }

        @Override
        public void onLocationChanged(Location location) {
            updatewitnewLocation(location);
        }
    };



//    public String  message ()
//    {
//        String value1 ="Please I am in trouble. ";
//
//        message = value1 + locateMe;
//
//        return message;
//    }
//
//




}
