package com.example.upmobbank;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegistrationActivity extends AppCompatActivity {
    private Button buttonCreateAcc;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        buttonCreateAcc = findViewById(R.id.buttonCreateAcount);

        buttonCreateAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToFunctionActivity(view);
            }
        });

    }

    public void goToFunctionActivity(View activ){
        Intent intentToFunAct = new Intent(this, FunctionActivity.class);
        startActivity(intentToFunAct);
    }

}