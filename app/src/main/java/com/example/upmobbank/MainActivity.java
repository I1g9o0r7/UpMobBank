package com.example.upmobbank;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

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


        buttonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editTextPhone.getText().toString().equals("123")){
                    showAlertInfo("номер телефона неверный");
                }
            }
        });

        buttonRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }


    private void errorPhone(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    private void showAlertInfo(String text){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Error").setMessage(text);


        AlertDialog alert = builder.create();
        alert.show();
    }


    public void goToRegistrationActivity(View activ){
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }













    @Override
    protected void onStart() {
        super.onStart();


    }

    @Override
    protected void onPause() {
        super.onPause();


    }

    @Override
    protected void onStop() {
        super.onStop();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();


    }
}