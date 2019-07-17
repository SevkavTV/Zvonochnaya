package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    int countSecond;
    TextView textSecond;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textSecond = (TextView) findViewById(R.id.textSecond);
        Button twice = (Button) findViewById(R.id.buttonTwice);
        Button back = (Button) findViewById(R.id.buttonBack);
        Bundle extras = getIntent().getExtras();
        countSecond = extras.getInt("COUNT");
        textSecond.setText("" + countSecond);
        twice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countSecond *= 2;
                textSecond.setText("" + countSecond);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBack = new Intent();
                intentBack.putExtra("RESULT_MULTIPLY", countSecond);
                setResult(RESULT_OK, intentBack);
                finish();
            }
        });
    }
}
