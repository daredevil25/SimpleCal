package com.example.simplecal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAdd = findViewById(R.id.btn_add);
        Button btnSub = findViewById(R.id.btn_sub);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!validateInput()){
                    switchToAdd();
                }
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!validateInput()){
                    switchToSub();
                }
            }
        });
    }

    private boolean validateInput(){
        EditText input1 = findViewById(R.id.input1);
        EditText input2 = findViewById(R.id.input2);

        boolean hasError = false;
        if (input1.length()==0) {
            hasError = true;
            input1.setError("Required!");
        }
        if (input2.length()==0) {
            hasError = true;
            input2.setError("Required!");
        }
        return hasError;
    }

    private void switchToAdd(){
        EditText input1 = findViewById(R.id.input1);
        EditText input2 = findViewById(R.id.input2);
        String text1 = input1.getText().toString();
        String text2 = input2.getText().toString();

        Intent intent = new Intent(this, SubActivity1.class);
        intent.putExtra("equation", text1 + " + " + text2);
        intent.putExtra("result", Double.valueOf(text1) + Double.valueOf(text2));
        startActivity(intent);
    }

    private void switchToSub(){
        EditText input1 = findViewById(R.id.input1);
        EditText input2 = findViewById(R.id.input2);
        String text1 = input1.getText().toString();
        String text2 = input2.getText().toString();

        Intent intent = new Intent(this, SubActivity2.class);
        intent.putExtra("equation", text1 + " - " + text2);
        intent.putExtra("result", Double.valueOf(text1) - Double.valueOf(text2));
        startActivity(intent);
    }
}