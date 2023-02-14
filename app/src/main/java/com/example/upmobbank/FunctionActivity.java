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
import android.widget.Toast;

public class FunctionActivity extends AppCompatActivity {

    private Button buttonShowBalanceUA, buttonShowBalanceUS, buttonShowBalanceEU;
    private Switch switchlock;
    private Button buttonUASendMoney, buttonSetings;

    private boolean permision = true;

    private BalanceUaFragment balanceUaFragment = new BalanceUaFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function);

        buttonShowBalanceUA = findViewById(R.id.buttonShowBalanceUA);
        buttonShowBalanceUS = findViewById(R.id.buttonShowBalanceUS);
        buttonShowBalanceEU = findViewById(R.id.buttonShowBalanceEU);

        switchlock = findViewById(R.id.switchLock);
        buttonUASendMoney = findViewById(R.id.buttonUASendMoney);
        buttonSetings = findViewById(R.id.buttonSetings);


        buttonShowBalanceUA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNewFragment(balanceUaFragment);
            }
        });

        buttonShowBalanceUS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BalanceUsFragment balanceUsFragment = new BalanceUsFragment();
                setNewFragment(balanceUsFragment);
            }
        });

        buttonShowBalanceEU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BalanceEuFragment balanceEuFragment = new BalanceEuFragment();
                setNewFragment(balanceEuFragment);
            }
        });

        setNewFragment(balanceUaFragment);
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

    private void setNewFragment(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayoutForShowBalance, fragment);
        ft.addToBackStack(null);
        ft.commit();
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