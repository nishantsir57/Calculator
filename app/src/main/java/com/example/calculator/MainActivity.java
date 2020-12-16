package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, plus, minus, multi, div, equal;
    TextView t1;
    String s="";
    char symbol=0;
    String num1="", num2="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculator();
    }
    void calculator()
    {
        b0=findViewById(R.id.b0);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        b6=findViewById(R.id.b6);
        b7=findViewById(R.id.b7);
        b8=findViewById(R.id.b8);
        b9=findViewById(R.id.b9);
        plus=findViewById(R.id.plus);
        minus=findViewById(R.id.minus);
        multi=findViewById(R.id.multi);
        div=findViewById(R.id.div);
        equal=findViewById(R.id.equal);
        t1=findViewById(R.id.t1);
        b0.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        s = t1.getText().toString();
                        s+="0";
                        t1.setText(s);
                    }
                }
        );
        b1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        s = t1.getText().toString();
                        s+="1";
                        t1.setText(s);
                    }
                }
        );
        b2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        s = t1.getText().toString();
                        s+="2";
                        t1.setText(s);
                    }
                }
        );
        b3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        s = t1.getText().toString();
                        s+="3";
                        t1.setText(s);
                    }
                }
        );
        b4.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        s = t1.getText().toString();
                        s+="4";
                        t1.setText(s);
                    }
                }
        );
        b5.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        s = t1.getText().toString();
                        s+="5";
                        t1.setText(s);
                    }
                }
        );
        b6.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        s = t1.getText().toString();
                        s+="6";
                        t1.setText(s);
                    }
                }
        );
        b7.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        s = t1.getText().toString();
                        s+="7";
                        t1.setText(s);
                    }
                }
        );
        b8.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        s = t1.getText().toString();
                        s+="8";
                        t1.setText(s);
                    }
                }
        );
        b9.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        s = t1.getText().toString();
                        s+="9";
                        t1.setText(s);
                    }
                }
        );
        plus.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        s = t1.getText().toString();
                        if (symbol != 0) {
                            num2=s;
                            s=calculate(num1, num2, symbol);
                            symbol=0;
                        }
                        else
                        {
                            symbol='+';
                            num1=s;
                            s="";
                        }
                        t1.setText(s);
                    }
                }
        );
        minus.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        s = t1.getText().toString();
                        if (symbol != 0) {
                            num2=s;
                            s=calculate(num1, num2, symbol);
                            symbol=0;
                        }
                        else
                        {
                            num1=s;
                            s="";
                            symbol='-';
                        }
                        t1.setText(s);
                    }
                }
        );
        multi.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        s = t1.getText().toString();
                        if (symbol != 0) {
                            num2=s;
                            s=calculate(num1, num2, symbol);
                            symbol=0;
                        }
                        else
                        {
                            num1=s;
                            s="";
                            symbol='*';
                        }
                        t1.setText(s);
                    }
                }
        );
        div.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        s = t1.getText().toString();
                        if (symbol != 0) {
                            num2=s;
                            s=calculate(num1, num2, symbol);
                            symbol=0;
                        }
                        else
                        {
                            num1=s;
                            symbol='/';
                            s="";
                        }
                        t1.setText(s);
                    }
                }
        );
        equal.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        s = t1.getText().toString();
                        if (symbol != 0) {
                            num2 = s;
                            s = calculate(num1, num2, symbol);
                            symbol = 0;
                        }
                        t1.setText(s);
                        Timer timer = new Timer();
                        timer.schedule(
                                new TimerTask() {
                                    @Override
                                    public void run() {
                                        t1.setText("");
                                        num1="";
                                        num2="";
                                        symbol=0;
                                    }
                                }
                       ,10000 );
                        //t1.setText("");
                    }
                }
        );
    }
    String calculate(String num1, String num2, char symbol)
    {
       String s="";
       switch(symbol){
           case '+':
               s=(Double.parseDouble(num1)+Double.parseDouble(num2))+"";
               break;
           case '-':
               s=(Double.parseDouble(num1)-Double.parseDouble(num2))+"";
               break;
           case '*':
               s=(Double.parseDouble(num1)*Double.parseDouble(num2))+"";
               break;
           case '/':
               s=(Double.parseDouble(num1)/Double.parseDouble(num2))+"";
               break;
       }

        return s;
    }
}