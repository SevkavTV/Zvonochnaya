package com.example.adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    ListView lv;
    String[] als;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.textView);
        lv = (ListView) findViewById(R.id.listView);
        als = new String [12];
        als[0] = "Serg"; als[1] ="Mary"; als[2] ="Lucy";
        als[3] = "Max"; als[4] = "Mark"; als[5] = "Andrew";
        als[6] ="George"; als[7] ="Pete"; als[8] ="John";
        als[9] ="Vlad"; als[10] ="Paul"; als[11] = "Bob";
        ArrayAdapter<String> ad = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, als);
        lv.setAdapter(ad);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                tv.setText(als[position]);
            }
        });
    }
}
