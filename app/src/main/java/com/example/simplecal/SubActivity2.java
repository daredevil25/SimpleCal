package com.example.simplecal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class SubActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);

        TextView textEquation = findViewById(R.id.textEquationSub);
        TextView textResult = findViewById(R.id.textResultSub);

        String equation = getIntent().getStringExtra("equation");
        Double result = getIntent().getDoubleExtra("result",0);
        String formattedRes = result.toString();
        formattedRes = formattedRes.contains(".") ? formattedRes.replaceAll("0*$","").replaceAll("\\.$","") : formattedRes;
        textEquation.setText(equation);
        textResult.setText("= "+ formattedRes);
    }
}
