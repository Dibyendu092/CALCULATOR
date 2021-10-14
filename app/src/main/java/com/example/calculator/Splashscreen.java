package com.example.calculator;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class Splashscreen extends AppCompatActivity {

    TextView a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        a = findViewById(R.id.txt1);
        getSupportActionBar().hide();
        Thread thread = new Thread(new Runnable() {//this code is totaly for splash screen delay
            @Override
            public void run() {
                try {
                    sleep(4000);
                    finish();
                    Intent i = new Intent(Splashscreen.this, MainActivity.class);//connect splash and main activity
                    startActivity(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        Animation myanimation = AnimationUtils.loadAnimation(Splashscreen.this,R.anim.animation1);
        a.startAnimation(myanimation);
    }
}