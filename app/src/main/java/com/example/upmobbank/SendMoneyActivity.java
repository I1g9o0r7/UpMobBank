package com.example.upmobbank;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class SendMoneyActivity extends AppCompatActivity {

    private Spinner spinnerCurrencyСhoice, spinnerMethodsSendChoice;
    private TextView textViewAmountOfMoney;
    private EditText editTextMethodSendMoney;
    private String[] currency = { "UA", "US", "EU"};

    private String[] methodsSend = { "Phone", "Card"};

    private String currencyItem, methodsSendItem;

    private Button button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_money);

        spinnerCurrencyСhoice = findViewById(R.id.spinnerCurrencyСhoice);
        spinnerMethodsSendChoice = findViewById(R.id.spinnerMethodSendСhoice);
        button = findViewById(R.id.buttonSendMoney);
        editTextMethodSendMoney = findViewById(R.id.editTextMethodSendMoney);
        textViewAmountOfMoney = findViewById(R.id.textViewAmountOfMoney);

        choiceCurrency();
        choiceMethodSend();



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                System.out.println("-----------------------------------------------------" + spinnerCurrencyСhoice.getSelectedItem().toString());
//                System.out.println("-----------------------------------------------------" + spinnerMethodsSendChoice.getSelectedItem().toString());
            }
        });

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Получаем выбранный объект
                String item = (String)parent.getItemAtPosition(position);

                if(item.equals("UA"))
                    textViewAmountOfMoney.setText("" + MainActivity.acc.getBalanceUA());
                if(item.equals("US"))
                    textViewAmountOfMoney.setText("" + MainActivity.acc.getBalanceUS());
                if(item.equals("EU"))
                    textViewAmountOfMoney.setText("" + MainActivity.acc.getBalanceEU());


                //editTextMethodSendMoney.setHint(item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinnerCurrencyСhoice.setOnItemSelectedListener(itemSelectedListener);


    }



    private void choiceCurrency() {
        ArrayAdapter<String> adapterCurrency = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, currency);
        adapterCurrency.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCurrencyСhoice.setAdapter(adapterCurrency);
    }
    private void choiceMethodSend() {
        ArrayAdapter<String> adapterMethodsSend = new ArrayAdapter(this, android.R.layout.simple_spinner_item, methodsSend);
        adapterMethodsSend.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMethodsSendChoice.setAdapter(adapterMethodsSend);
    }
}