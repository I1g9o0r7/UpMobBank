package com.example.upmobbank;

//import java.lang.reflect.InvocationTargetException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class DBUpMobBank {
//    private final String HOST = "localhost"; // http://127.0.0.1/openserver/phpmyadmin/index.php?route=/sql&db=dbUpMobBank&table=Accounts&pos=0
//    private final String PORT = "3306";
//    private final String DB_NAME = "dbUpMobBank";
//    private final String LOGIN = "root";
//    private final String PASS = "";
//
//    private Connection dbConnection;
//
//    private Connection getDBConn() throws ClassCastException, SQLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
//        String conn = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME;
//        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
//
//        dbConnection = DriverManager.getConnection(conn, LOGIN, PASS);
//
//        return dbConnection;
//    }
//}


import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class DBUpMobBank extends AsyncTask{
    private Context context;

    public DBUpMobBank(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(Object[] objects) {

        try{


            String username = (String)objects[0];
            String password = (String)objects[1];

            String link="http://myphpmysqlweb.hostei.com/loginpost.php";
            String data  = URLEncoder.encode("phone", "UTF-8") + "=" +
                    URLEncoder.encode(username, "UTF-8");
            data += "&" + URLEncoder.encode("password", "UTF-8") + "=" +
                    URLEncoder.encode(password, "UTF-8");

            URL url = new URL(link);
            URLConnection conn = url.openConnection();

            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

            wr.write( data );
            wr.flush();

            BufferedReader reader = new BufferedReader(new
                    InputStreamReader(conn.getInputStream()));

            StringBuilder sb = new StringBuilder();
            String line = null;

            // Read Server Response
            while((line = reader.readLine()) != null) {
                sb.append(line);
                break;
            }

            return sb.toString();



        } catch(Exception e){
            return new String("Exception: " + e.getMessage());
        }

    }
    protected void onPreExecute(){
    }

}


