package com.example.upmobbank;

import android.text.Editable;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class Account {
    private long codeAcc;
    private String phone;
    private String password;
    private String firstName, lastName;

    private Calendar bithDate;

    private double balanceUA, balanceUS, balanceEU;

    public long getCodeAcc() {
        return codeAcc;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Calendar getBithDate() {
        return bithDate;
    }

    public double getBalanceUA() {
        return balanceUA;
    }

    public double getBalanceUS() {
        return balanceUS;
    }

    public double getBalanceEU() {
        return balanceEU;
    }


    // For enter account
    public Account(long codeAcc, String phone, String password, String firstName, String lastName, Calendar bithDate, double balanceUA, double balanceUS, double balanceEU) {
        this.codeAcc = codeAcc;
        this.phone = phone;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bithDate = bithDate;
        this.balanceUA = balanceUA;
        this.balanceUS = balanceUS;
        this.balanceEU = balanceEU;

    }

    // For Created Account
    public Account(String phone, String password, String firstName, String lastName, Calendar bithDate) { //long codeAcc,
        this.codeAcc = 1;
        this.phone = phone;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bithDate = bithDate;
        this.balanceUA = 1000;
        this.balanceUS = 1000;
        this.balanceEU = 1000;

    }
}
