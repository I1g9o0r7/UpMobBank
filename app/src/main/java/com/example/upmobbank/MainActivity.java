package com.example.upmobbank;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class MainActivity extends AppCompatActivity {
    public static Account acc;

    private EditText editTextPhone;
    private EditText editTextPass;
    private Button buttonEnter;
    private Button buttonRegist;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPhone = findViewById(R.id.editTextPhone);
        editTextPass = findViewById(R.id.editTextPass);
        buttonEnter = findViewById(R.id.buttonEnter);
        buttonRegist = findViewById(R.id.buttonRegist);
        editTextPhone.setText("0");
        editTextPass.setText("0");



        buttonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editTextPhone.getText().toString().equals("123")){
//                    showAlertInfo("номер телефона неверный");
                    Toast.makeText(getBaseContext(), "Номер телефона неверный", Toast.LENGTH_SHORT).show();
                } else {
                    goToFunctionActivity(view);
                }

                RegistrationActivity.bithDate = new GregorianCalendar();
                RegistrationActivity.bithDate.set(Calendar.DAY_OF_MONTH, 28);
                RegistrationActivity.bithDate.set(Calendar.MONTH, 3);
                RegistrationActivity.bithDate.set(Calendar.YEAR, 2001);
                acc = new Account(1234123412341234l,"147" , "123" , "Igor", "Bilou", RegistrationActivity.bithDate, 111111, 222222, 333333);

                //goConnectToDB();














            }
        });

        buttonRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToRegistrationActivity(view);
            }
        });
    }

    private void goConnectToDB() {
        new DBUpMobBank(this, editTextPhone.getText().toString(), editTextPass.getText().toString()).execute();
    }

//    private void errorPhone(String text){
//        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
//    }

//    private void showAlertInfo(String text){
//        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//        builder.setTitle("Error").setMessage(text);
//        AlertDialog alert = builder.create();
//        alert.show();
//    }
    public void goToFunctionActivity(View activ){
        Intent intentToFunAct = new Intent(this, FunctionActivity.class);
        startActivity(intentToFunAct);
    }

    public void goToRegistrationActivity(View activ){
        Intent intentToRegAct = new Intent(this, RegistrationActivity.class);
        startActivity(intentToRegAct);
    }

}