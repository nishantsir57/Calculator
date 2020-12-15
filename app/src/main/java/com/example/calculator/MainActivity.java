package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, plus, minus, multi, div, equal;
    TextView t1;
    String s="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                        s+="+";
                        t1.setText(s);
                    }
                }
        );
        minus.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        s = t1.getText().toString();
                        s+="-";
                        t1.setText(s);
                    }
                }
        );
        multi.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        s = t1.getText().toString();
                        s+="*";
                        t1.setText(s);
                    }
                }
        );
        div.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        s = t1.getText().toString();
                        s+="/";
                        t1.setText(s);
                    }
                }
        );
        equal.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        s = t1.getText().toString();
                        s=calculate(s);//524+238-121
                        t1.setText(s);
                    }
                }
        );
    }
    String calculate(String s)
    {
        String num[]=s.split("[+*/-//]");
        String op[]=s.split("[0-9]");
        List<String> l1= Arrays.asList(num);
        List<String> l2=Arrays.asList(op);
        long ans=0;
        for(int i=0;i<op.length;i++) {//[123+25/5-1]=[127+127/5-1]
            if(l2.get(i).equals("/"))
            {
                double n=(Double.parseDouble(l1.get(i))/Double.parseDouble(l1.get(i+1)));
                l1.remove(i);
                l1.remove(i+1);
                l2.remove(i);
                l1.set(i, n+"");
            }
        }
        for(int i=0;i<op.length;i++) {//[123+25/5-1]=[127+127/5-1]
            if(l2.get(i).equals("*"))
            {
                double n=(Double.parseDouble(l1.get(i))*Double.parseDouble(l1.get(i+1)));
                l1.remove(i);
                l1.remove(i+1);
                l2.remove(i);
                l1.set(i, n+"");
            }
        }
        for(int i=0;i<op.length;i++) {//[123+25/5-1]=[127+127/5-1]
            if(l2.get(i).equals("+"))
            {
                double n=(Double.parseDouble(l1.get(i))+Double.parseDouble(l1.get(i+1)));
                l1.remove(i);
                l1.remove(i+1);
                l2.remove(i);
                l1.set(i, n+"");
            }
        }
        for(int i=0;i<op.length;i++) {//[123+25/5-1]=[127+127/5-1]
            if(l2.get(i).equals("-"))
            {
                double n=(Double.parseDouble(l1.get(i))-Double.parseDouble(l1.get(i+1)));
                l1.remove(i);
                l1.remove(i+1);
                l2.remove(i);
                l1.set(i, n+"");
            }
        }
        return "";
    }
}