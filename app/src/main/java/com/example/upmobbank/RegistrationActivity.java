package com.example.upmobbank;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.text.DateFormatSymbols;

public class RegistrationActivity extends AppCompatActivity {
    private Button buttonCreateAcc;
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

        days = new String[31];
        years = new String[47];


        for(int i = 1; i <= 31; i++)
            days[i-1] = "" + i;

        for(int i = 0; i < 47; i++)
            years[i] = "" + (2007-i);

        months = new String[15];

        months = new DateFormatSymbols().getMonths();

        buttonCreateAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToFunctionActivity(view);
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

}