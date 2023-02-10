package com.example.upmobbank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FunctionActivity extends AppCompatActivity {

    private Button buttonShowBalanceUA, buttonShowBalanceUS, buttonShowBalanceEU;
    private BalanceUaFragment balanceUaFragment = new BalanceUaFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function);


        buttonShowBalanceUA = findViewById(R.id.buttonShowBalanceUA);
        buttonShowBalanceUS = findViewById(R.id.buttonShowBalanceUS);
        buttonShowBalanceEU = findViewById(R.id.buttonShowBalanceEU);

        setNewFragment(balanceUaFragment);

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

    }

    private void setNewFragment(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayoutForShowBalance, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }



}