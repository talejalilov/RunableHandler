package com.example.runablehandler;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.MessageQueue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Runnable runnable;
    Handler handler;
    Button start,stop;
    TextView textView;

    int number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);
        textView = findViewById(R.id.textView);




        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler = new Handler();

                runnable = new Runnable() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void run() {
                        textView.setText("Your Time: " +number);
                        number++;
                        textView.setText("Your Time: " +number);


                        handler.postDelayed(runnable,1000);
                    }
                };
                handler.post(runnable);
                start.setEnabled(false);

            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                start.setEnabled(true);

                handler.removeCallbacks(runnable);
                number = 0;
                textView.setText("Your Time: " + number);
            }
        });

    }
}