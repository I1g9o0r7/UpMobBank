package com.example.upmobbank;

import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class DBUpMobBank extends AsyncTask<String, Void, String> {

    private Context context;
    private String phone;
    private String pass;

    public DBUpMobBank(Context context, String phone, String pass) {
        this.context = context;
        this.phone = phone;
        this.pass = pass;
    }


    @Override
    protected String doInBackground(String... arg0) {

        try {


            String link="http://localhost/php/connectToDB.php";
            String  data  = URLEncoder.encode("phone", "UTF-8") + "=" + URLEncoder.encode(phone, "UTF-8");
                    data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8");

            URL url = new URL(link);
            URLConnection conn = url.openConnection();

            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

            wr.write( data );
            wr.flush();


            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            StringBuilder sb = new StringBuilder();
            String line = null;

            // Read Server Response
            while((line = reader.readLine()) != null) {
                System.out.println("----------------------------------------------------" + line); //------------------------------------------------------------------------
                sb.append(line);
                break;
            }

            return sb.toString();






        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void onPostExecute(String result) {

        System.out.println("----------------------------------------------------------------------"+result);
        super.onPostExecute(result);
    }
}

























//    private Context context;
//
//    public DBUpMobBank(Context context) {
//        this.context = context;
//    }
//
//    @Override
//    protected String doInBackground(Object[] objects) {
//
//        try{
//
//            String phone = (String)objects[0];
//            String password = (String)objects[1];
//
//            String link="http://localhost/php/connectToDB.php";
//            String data  = URLEncoder.encode("phone", "UTF-8") + "=" +
//                    URLEncoder.encode(phone, "UTF-8");
//            data += "&" + URLEncoder.encode("password", "UTF-8") + "=" +
//                    URLEncoder.encode(password, "UTF-8");
//
//            URL url = new URL(link);
//            URLConnection conn = url.openConnection();
//
//            conn.setDoOutput(true);
//            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
//
//            wr.write( data );
//            wr.flush();
//
//            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//
//            StringBuilder sb = new StringBuilder();
//            String line = null;
//
//            // Read Server Response
//            while((line = reader.readLine()) != null) {
//                System.out.println("----------------------------------------------------" + line); //------------------------------------------------------------------------
//                sb.append(line);
//                //break;
//            }
//
//            return sb.toString();
//
//        } catch(Exception e){
//            return new String("Exception: " + e.getMessage());
//        }
//
//    }
//    protected void onPreExecute(){
//    }



