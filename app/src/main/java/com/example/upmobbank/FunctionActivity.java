package com.example.upmobbank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class FunctionActivity extends AppCompatActivity {

    private Switch switchlock;
    private Button buttonUASendMoney, buttonSetings;
    private TextView textViewUARates, textViewUSRates, textViewEURates, textViewCodeAcc, textViewUABalance, textViewUSBalance, textViewEUBalance;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function);

        switchlock = findViewById(R.id.switchLock);
        buttonUASendMoney = findViewById(R.id.buttonUASendMoney);
        buttonSetings = findViewById(R.id.buttonSetings);


        textViewCodeAcc = findViewById(R.id.textViewCodeAcc);
        textViewCodeAcc.setText("" + MainActivity.acc.getCodeAcc());

        textViewUABalance = findViewById(R.id.textViewUABalance);
        textViewUABalance.setText("" + MainActivity.acc.getBalanceUA());

        textViewUSBalance = findViewById(R.id.textViewUSBalance);
        textViewUSBalance.setText("" + MainActivity.acc.getBalanceUS());

        textViewEUBalance = findViewById(R.id.textViewEUBalance);
        textViewEUBalance.setText("" + MainActivity.acc.getBalanceEU());






//        textViewUABalance = findViewById(R.id.textViewUABalance);
//        textViewUABalance.setText("" + MainActivity.acc.getBalanceUA());

        setButtonFunctions();

        switchlock.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked == true){
                    Toast.makeText(getBaseContext(), "false", Toast.LENGTH_SHORT).show();
                    buttonUASendMoney.setOnClickListener(null);
                    buttonSetings.setOnClickListener(null);
                } else{
                    Toast.makeText(getBaseContext(), "true", Toast.LENGTH_SHORT).show();
                    setButtonFunctions();

                }
            }
        });



    }

    private void setButtonFunctions(){
        buttonUASendMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSendMoneyActivity(view);





            }
        });

        buttonSetings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToRegistrationActivity(view);




            }
        });
    }


    public void goToSendMoneyActivity(View activ){
        Intent intentToRegAct = new Intent(this, SendMoneyActivity.class);
        startActivity(intentToRegAct);
    }
    public void goToRegistrationActivity(View activ){
        Intent intentToRegAct = new Intent(this, RegistrationActivity.class);
        startActivity(intentToRegAct);
    }



}