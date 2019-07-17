package com.example.second;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text;
    FragmentManager fm;
    boolean isFirstFragment = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.textView);
        Button change = (Button) findViewById(R.id.button);
        FrameLayout frame = (FrameLayout) findViewById(R.id.frame);
        fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.frame, new FirstFragment()).commit();
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFirstFragment){
                    text.setText("Second Fragment");
                    fm.beginTransaction().replace(R.id.frame,
                            new SecondFragment()).commit();
                    isFirstFragment = false;
                }else{
                    text.setText("First Fragment");
                    fm.beginTransaction().replace(R.id.frame,
                            new FirstFragment()).commit();
                    isFirstFragment = true;
                }
            }
        });
    }
}
