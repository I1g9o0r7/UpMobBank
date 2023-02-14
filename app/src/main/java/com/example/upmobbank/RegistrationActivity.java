package com.example.upmobbank;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class RegistrationActivity extends AppCompatActivity {


    private Button buttonCreateAcc;
    public static Calendar bithDate;

    private EditText editTextForFirstName, editTextForLastName, editTextForPhone, editTextForPassword;
    private Spinner spinnerDay, spinnerMonth, spinnerYear;
    private String[] months, days, years;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        buttonCreateAcc = findViewById(R.id.buttonCreateAcount);
        spinnerDay = findViewById(R.id.spinnerInputDay);
        spinnerMonth = findViewById(R.id.spinnerInputMonth);
        spinnerYear = findViewById(R.id.spinnerInputYears);

        editTextForFirstName = findViewById(R.id.editTextForFirstName);
        editTextForLastName = findViewById(R.id.editTextForLastName);

        editTextForPhone = findViewById(R.id.editTextForPhone);
        editTextForPassword = findViewById(R.id.editTextForPassword);

        days = new String[31];
        years = new String[47];
        months = new String[12];


        for(int i = 1; i <= 31; i++)
            days[i-1] = "" + i;

        for(int i = 0; i < 47; i++)
            years[i] = "" + (2007-i);

        for(int i = 1; i <= 12; i++)
            months[i-1] = "" + i;

        //months = new DateFormatSymbols().getMonths();

        buttonCreateAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if("" + editTextForPhone.getText() == ""){
                    Toast.makeText(getBaseContext(), "Phone field is empty", Toast.LENGTH_SHORT).show();
                } else if("" + editTextForPassword.getText() == ""){
                    Toast.makeText(getBaseContext(), "Password field is empty", Toast.LENGTH_SHORT).show();
                } else if("" +editTextForFirstName.getText() == ""){
                    Toast.makeText(getBaseContext(), "First name field is empty", Toast.LENGTH_SHORT).show();
                } else if("" +editTextForLastName.getText() == ""){
                    Toast.makeText(getBaseContext(), "Last name field is empty", Toast.LENGTH_SHORT).show();
                } else{
                    bithDate = new GregorianCalendar();
                    bithDate.set(Calendar.DAY_OF_MONTH, Integer.parseInt(spinnerDay.getSelectedItem().toString()));
                    bithDate.set(Calendar.MONTH, Integer.parseInt(spinnerMonth.getSelectedItem().toString()));
                    bithDate.set(Calendar.YEAR, Integer.parseInt(spinnerYear.getSelectedItem().toString()));
                    MainActivity.acc = new Account("" + editTextForPhone.getText(), "" + editTextForPassword.getText(), "" + editTextForFirstName.getText(), "" + editTextForLastName.getText(), bithDate);

                    goToFunctionActivity(view);
                }

                //System.out.println("----------------------------------------------------------------------" + editTextForPhone.getText());

                //bithDate.setMonth(Integer.parseInt(spinnerMonth.getSelectedItem().toString()));

//                System.out.println(("" + editTextForPhone.getText()));
                //System.out.println("-------------------" + MainActivity.acc.getPhone() + "\n" + MainActivity.acc.getPassword());

            }
        });

        choiceDay();
        choiceMonth();
        choiceYear();

    }

    private void choiceDay() {
        ArrayAdapter<String> adapterCurrency = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, days);
        adapterCurrency.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDay.setAdapter(adapterCurrency);
    }

    private void choiceMonth() {
        ArrayAdapter<String> adapterCurrency = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, months);
        adapterCurrency.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMonth.setAdapter(adapterCurrency);
    }

    private void choiceYear() {
        ArrayAdapter<String> adapterCurrency = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, years);
        adapterCurrency.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerYear.setAdapter(adapterCurrency);
    }

    public void goToFunctionActivity(View activ){
        Intent intentToFunAct = new Intent(this, FunctionActivity.class);
        startActivity(intentToFunAct);
    }
    public void goToRegistrationActivity(View activ){
        Intent intentToRegAct = new Intent(this, RegistrationActivity.class);
        startActivity(intentToRegAct);
    }

}