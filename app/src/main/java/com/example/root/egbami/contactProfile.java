package com.example.root.egbami;

/**
 * Created by root on 2/19/15.
 */
public class contactProfile
{
    //contact table name
    public static String contact_TABLE ="emerg_contact";



    //column names

    public static String KEY_ID ="contact_id";
    public static String KEY_NAME ="contact_name";
    public static String KEY_EMAIL ="contact_email";
    public static String KEY_PHONE ="contact_phone";


    private int new_id;

    public String new_EMAIL;
    public String new_PHONE;


    //property that keeps data

    public String contactName;
    public String contactEmail;
    public String contactPhone;
    public int contatcId;

    public contactProfile()
    {

    }

    public contactProfile(int id, String email, String phone)
    {
        this.new_id = id;
        this.new_EMAIL = email;
        this.new_PHONE = phone;
    }




    public  void setKEY_ID (int id)
    {
        this.new_id = id;
    }
    public void setKEY_PHONE(String phone)
    {
        this.new_PHONE = phone;
    }

    public void setKEY_EMAIL(String email)
    {
        this.new_EMAIL = email;
    }

    public int getID()
    {
        return this.new_id;
    }

    public String getNew_EMAIL()
    {
        return this.new_EMAIL;
    }
    public String getNew_PHONE()
    {
        return  this.new_PHONE;
    }







}