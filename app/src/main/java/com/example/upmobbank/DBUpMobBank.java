package com.example.upmobbank;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUpMobBank {
    private final String HOST = "localhost"; // http://127.0.0.1/openserver/phpmyadmin/index.php?route=/sql&db=dbUpMobBank&table=Accounts&pos=0
    private final String PORT = "3306";
    private final String DB_NAME = "dbUpMobBank";
    private final String LOGIN = "root";
    private final String PASS = "";

    private Connection dbConnection;

    private Connection getDBConn() throws ClassCastException, SQLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        String conn = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME;
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

        dbConnection = DriverManager.getConnection(conn, LOGIN, PASS);

        return dbConnection;
    }
}
