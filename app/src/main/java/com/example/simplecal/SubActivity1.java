package com.example.simplecal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class SubActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);

        TextView textEquation = findViewById(R.id.textEquationAdd);
        TextView textResult = findViewById(R.id.textResultAdd);

        String equation = getIntent().getStringExtra("equation");
        Double result = getIntent().getDoubleExtra("result",0);
        String formattedRes = result.toString();
        formattedRes = formattedRes.contains(".") ? formattedRes.replaceAll("0*$","").replaceAll("\\.$","") : formattedRes;
        textEquation.setText(equation);
        textResult.setText("= "+ formattedRes);
    }
}