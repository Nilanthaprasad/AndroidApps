package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    Button btnAdd, btnSub, btn1, btn2, btn3,
            btn4, btn5, btn6, btn7, btn8, btn9,btn0, btnResult;
    TextView tvDisplay;
    boolean shouldClear;
    int op1, op2, result;

    String operation="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSubstract);
        btn0 = findViewById(R.id.btnZero);
        btn1 = findViewById(R.id.btnOne);
        btn2 = findViewById(R.id.btnTwo);
        btn3 = findViewById(R.id.btnThree);
        btn4 = findViewById(R.id.btnFour);
        btn5 = findViewById(R.id.btnFive);
        btn6 = findViewById(R.id.btnSix);
        btn7 = findViewById(R.id.btnSeven);
        btn8 = findViewById(R.id.btnEight);
        btn9 = findViewById(R.id.btnNine);
        btnResult = findViewById(R.id.btnResult);

        tvDisplay = findViewById(R.id.tvDisplay);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeDisplayValue("1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeDisplayValue("2");
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeDisplayValue("0");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeDisplayValue("3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeDisplayValue("4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeDisplayValue("5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeDisplayValue("6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeDisplayValue("7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeDisplayValue("8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeDisplayValue("9");
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!operation.equals("+")) {
                    operation = "+";
                    op1 = Integer.parseInt(getDisplayValue());
                }
                else {
                    op2 = Integer.parseInt(getDisplayValue());
                    result = op1 + op2;
                    setDisplayValue(String.valueOf(result));
                }
            }
        });

    }

    private String getDisplayValue()
    {
        return tvDisplay.getText().toString();
    }

    private void setDisplayValue(String text)
    {
        tvDisplay.setText(text);
    }

    private void changeDisplayValue(String text)
    {
        if(getDisplayValue().equals("0"))
        {
            setDisplayValue(text);
        }
        else if(operation.isEmpty())
        {
            setDisplayValue(getDisplayValue() + text);
        }
        else
        {
            if(shouldClear) {
                setDisplayValue(getDisplayValue() + text);
            }
        }
    }


}