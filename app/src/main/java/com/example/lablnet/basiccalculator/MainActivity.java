package com.example.lablnet.basiccalculator;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnMultiply, btnDivide, btnSubtract, btnAdd, btnEqual, btnClear;
    TextView txt;
    String input;
    long num;
    boolean userEnterOperator;
    String operatorEntered;
    boolean notFirstTime; //check whether user enter operator first time ,if user enter first time then do nothing

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parseId();
        setListner();
        input = "";
        num = 0;
        operatorEntered = null;
        notFirstTime = false;
    }

    public void parseId() {
        btn1 = (Button) findViewById(R.id.one);
        btn2 = (Button) findViewById(R.id.two);
        btn3 = (Button) findViewById(R.id.three);
        btn4 = (Button) findViewById(R.id.four);
        btn5 = (Button) findViewById(R.id.five);
        btn6 = (Button) findViewById(R.id.six);
        btn7 = (Button) findViewById(R.id.seven);
        btn8 = (Button) findViewById(R.id.eight);
        btn9 = (Button) findViewById(R.id.nine);
        btn0 = (Button) findViewById(R.id.zero);
        btnAdd = (Button) findViewById(R.id.plus);
        btnSubtract = (Button) findViewById(R.id.minus);
        btnDivide = (Button) findViewById(R.id.divide);
        btnMultiply = (Button) findViewById(R.id.multiply);
        btnEqual = (Button) findViewById(R.id.equal);
        btnClear = (Button) findViewById(R.id.C);
        txt = (TextView) findViewById(R.id.txt);
        txt.setTextSize(30);
        txt.setTypeface(Typeface.DEFAULT_BOLD);
    }

    public void setListner() {
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnSubtract.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.zero:
                enteredNumber(0);
                break;
            case R.id.one:
                enteredNumber(1);
                break;
            case R.id.two:
                enteredNumber(2);
                break;
            case R.id.three:
                enteredNumber(3);
                break;
            case R.id.four:
                enteredNumber(4);
                break;
            case R.id.five:
                enteredNumber(5);
                break;
            case R.id.six:
                enteredNumber(6);
                break;
            case R.id.seven:
                enteredNumber(7);
                break;
            case R.id.eight:
                enteredNumber(8);
                break;
            case R.id.nine:
                enteredNumber(9);
                break;
            case R.id.plus:
                enteredOperator("+");
                break;
            case R.id.minus:
                enteredOperator("-");
                break;
            case R.id.divide:
                enteredOperator("/");
                break;
            case R.id.multiply:
                enteredOperator("*");
                break;
            case R.id.equal:
                enteredOperator(operatorEntered);
                break;
            case R.id.C:
                clearScreen();
                break;
        }
    }

    public void enteredNumber(long num) {
        if (userEnterOperator) {
            input = "";
            userEnterOperator = false;
        }
        input =input+ Long.toString(num);
        txt.setText(String.valueOf((input)));
    }

    public void enteredOperator(String operator) {
        operatorEntered = operator;
        userEnterOperator = true;
        if (notFirstTime) {
            if (operator.equals("+")) {
                num = num + Long.parseLong(txt.getText().toString());
            } else if (operator.equals("-")) {
                num = num - Long.parseLong(txt.getText().toString());
            } else if (operator.equals("/")) {
                num =  num /  Long.parseLong(txt.getText().toString());
            } else if (operator.equals("*")) {
                num = num *  Long.parseLong(txt.getText().toString());
            }
        }
            else {
                num = Long.parseLong(txt.getText().toString());
            }
            notFirstTime = true;
            txt.setText(String.valueOf((int)num));
    }

    public void clearScreen() {
        txt.setText("");
        input = "";
        num = 0;
        notFirstTime = false;
    }
}
