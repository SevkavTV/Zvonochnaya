package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int count = 0;
    TextView text;
    int secondActivityID = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.textView);
        Button plus = (Button) findViewById(R.id.buttonPlus);
        Button minus = (Button) findViewById(R.id.buttonMinus);
        Button forward = (Button) findViewById(R.id.buttonForward);
//      text.setText("Hello Android");
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        forward.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonPlus:
                text.setText("" + ++count);
                break;
            case R.id.buttonMinus:
                text.setText("" + --count);
                break;
            case R.id.buttonForward:
                Intent i = new Intent(this, SecondActivity.class);
                i.putExtra("COUNT", count);
                startActivityForResult(i, secondActivityID);
                break;
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == secondActivityID) {
                Bundle extras = data.getExtras();
                count = extras.getInt("RESULT_MULTIPLY");
                text.setText("" + count);
            }
        }
    }
}