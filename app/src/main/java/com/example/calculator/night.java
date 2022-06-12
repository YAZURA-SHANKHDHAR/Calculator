package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class night extends AppCompatActivity {

    Button day;
    TextView process, rad;
    EditText result;
    String preprocess ;
    String prvnum = "0";
    String nnum = "0";
    String op = "+";
    String sf = "sin";
    boolean sp = false;
    boolean Op = true;
    boolean deg = true;
    boolean oper = false;
    boolean trigop = false;
    ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.night);

        rad = findViewById(R.id.deg);
        result = findViewById(R.id.result);
        process = findViewById(R.id.process);
    }


    public void numEvnt(View view) {
        preprocess = process.getText().toString();
        if (Op){
            result.setText("");
        }
        Op = false;
        oper = false;
        String num = result.getText().toString();
        switch (view.getId()){
            case R.id.btn0:
                num += "0";
                process.setText(preprocess + "0");
                break;

            case R.id.btn1:
                num += "1";
                process.setText(preprocess + "1");
                break;

            case R.id.btn2:
                num += "2";
                process.setText(preprocess + "2");
                break;

            case R.id.btn3:
                num += "3";
                process.setText(preprocess + "3");
                break;

            case R.id.btn4:
                num += "4";
                process.setText(preprocess + "4");
                break;

            case R.id.btn5:
                num += "5";
                process.setText(preprocess + "5");
                break;

            case R.id.btn6:
                num += "6";
                process.setText(preprocess + "6");
                break;

            case R.id.btn7:
                num += "7";
                process.setText(preprocess + "7");
                break;

            case R.id.btn8:
                num += "8";
                process.setText(preprocess + "8");
                break;

            case R.id.btn9:
                num += "9";
                process.setText(preprocess + "9");
                break;

            case R.id.dot:
                num += ".";
                process.setText(preprocess + ".");
                break;

        }

        result.setText(num);
    }


    public void operator(View view) {
        if(oper){
            process.setText(process.getText().toString().substring(0, process.getText().toString().length()-1));
        }

        if(sp){
            process.setText(process.getText().toString() + ")");
        }

        double res = 0.0;
        prvnum = result.getText().toString();

        if (sp){
            switch (sf){
                case "sin":
                    prvnum = Double.toString(Math.sin(Math.toRadians(Double.parseDouble(prvnum))));
                    break;
                case "cos":
                    prvnum = Double.toString(Math.cos(Math.toRadians(Double.parseDouble(prvnum))));
                    break;
                case "tan":
                    prvnum = Double.toString(Math.tan(Math.toRadians(Double.parseDouble(prvnum))));
                    break;
                case "log":
                    prvnum = Double.toString(Math.log10(Double.parseDouble(prvnum)));
                    break;
                case "ln=":
                    prvnum = Double.toString(Math.log(Double.parseDouble(prvnum)));
                    break;
                case "sqrt":
                    prvnum = Double.toString(Math.sqrt(Double.parseDouble(prvnum)));
                    break;
            }
        }
        sp = false;

        Op = true;
        if(!oper) {
            switch (op) {
                case "+":
                    res = Double.parseDouble(nnum) + Double.parseDouble(prvnum);
                    nnum = Double.toString(Math.round(res * 100000) / 100000.0);
                    break;
                case "-":
                    res = Double.parseDouble(nnum) - Double.parseDouble(prvnum);
                    nnum = Double.toString(Math.round(res * 10000) / 10000.0);
                    break;
                case "*":
                    res = Double.parseDouble(nnum) * Double.parseDouble(prvnum);
                    nnum = Double.toString(Math.round(res * 10000) / 10000.0);
                    break;
                case "/":
                    res = Double.parseDouble(nnum) / Double.parseDouble(prvnum);
                    nnum = Double.toString(Math.round(res * 10000) / 10000.0);
                    break;
            }
            result.setText(Double.toString(Math.round(res*10000)/10000.0));
        }

        switch (view.getId()){
            case R.id.divide:
                op = "/";
                process.setText(process.getText().toString() + "/");
                break;
            case R.id.plus:
                op = "+";
                process.setText(process.getText().toString() + "+");
                break;
            case R.id.minus:
                op = "-";
                process.setText(process.getText().toString() + "-");
                break;
            case R.id.multiply:
                op = "*";
                process.setText(process.getText().toString() + "×");
                break;
        }
        oper = true;
    }


    public void equal(View view) {
        if(sp){
            process.setText(process.getText().toString() + ")");
        }

        String newnum = result.getText().toString();
        if (sp){
            switch (sf){
                case "sin":
                    newnum = Double.toString(Math.sin(Math.toRadians(Double.parseDouble(newnum))));
                    break;
                case "cos":
                    newnum = Double.toString(Math.cos(Math.toRadians(Double.parseDouble(newnum))));
                    break;
                case "tan":
                    newnum = Double.toString(Math.tan(Math.toRadians(Double.parseDouble(newnum))));
                    break;
                case "log":
                    newnum = Double.toString(Math.log10(Double.parseDouble(newnum)));
                    break;
                case "ln":
                    newnum = Double.toString(Math.log(Double.parseDouble(newnum)));
                    break;
                case "sqrt":
                    newnum = Double.toString(Math.sqrt(Double.parseDouble(newnum)));
                    break;
            }
        }
        sp = false;
        double res = 0.0;
        switch (op){
            case "+":
                res = Double.parseDouble(nnum) + Double.parseDouble(newnum);
                break;
            case "-":
                res = Double.parseDouble(nnum) - Double.parseDouble(newnum);
                break;
            case "*":
                res = Double.parseDouble(nnum) * Double.parseDouble(newnum);
                break;
            case "/":
                res = Double.parseDouble(nnum) / Double.parseDouble(newnum);
                break;
        }
        String eq = process.getText().toString();
        process.setText(eq+"=");
        result.setText(Double.toString(Math.round(res*10000)/10000.0));

        oper = true;
    }


    public void clear(View view) {
        Op = true;
        sp = false;
        result.setText("0.0");
        process.setText("");
        prvnum = "0";
        nnum = "0";
        op = "+";
        preprocess = "0";
    }


    public void special(@NonNull View view) {

        sp = true;
        Op = true;

        switch (view.getId()) {
            case R.id.sin:
                sf = "sin";
                process.setText(process.getText().toString() + "sin(");
                break;
            case R.id.cos:
                sf = "cos";
                process.setText(process.getText().toString() + "cos(");
                break;
            case R.id.tan:
                sf = "tan";
                process.setText(process.getText().toString() + "tan(");
                break;
            case R.id.log:
                sf = "log";
                process.setText(process.getText().toString() + "log(");
                break;
            case R.id.ln:
                sf = "ln";
                process.setText(process.getText().toString() + "ln(");
                break;
            case R.id.sq:
                sf = "sqrt";
                process.setText(process.getText().toString() + "√(");
                break;
        }

    }

    public void convert(View view) {
        if (deg) {
            result.setText(Double.toString(Math.round(Math.toRadians(Double.parseDouble(result.getText().toString()))*10000)/10000.0));
            deg = false;
            rad.setText("Rad");
        }
        else{
            result.setText(Double.toString(Math.round(Math.toDegrees(Double.parseDouble(result.getText().toString()))*10000)/10000.0));
            deg = true;
            rad.setText("Deg");
        }
    }


    public void day(View view) {
        day = findViewById(R.id.day);
        day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openmainactivity();
            }
        });
    }

    private void openmainactivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}