package com.example.upmobbank;

import java.util.Date;

public class Account {
    private long codeAcc;
    private String phone;
    private String password;
    private String firstName, lastName;

    private Date bithDate;

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

    public Date getBithDate() {
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

    public Account(long codeAcc, String phone, String password, String firstName, String lastName, Date bithDate, double balanceUA, double balanceUS, double balanceEU) {
        this.codeAcc = codeAcc;
        this.phone = phone;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bithDate = bithDate;
        this.balanceUA = balanceUA;
        this.balanceUS = balanceUS;
        this.balanceEU = balanceEU;

//        bithDate





    }
}
