package com.gdgbangla.motiur.test;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {

                SharedPreferences  sharedPreferences = getSharedPreferences(Config.FLAG, Context.MODE_PRIVATE);

                if(sharedPreferences.getBoolean(Config.FLAG,true)){
                    //we need to finish it here
                    finish();
                    startActivity(new Intent(MainActivity.this,MyIntro.class));

                    SharedPreferences.Editor e=sharedPreferences.edit();

                    e.putBoolean(Config.FLAG,false);

                    e.apply();
                }
            }
        });
        t.start();
    }
}

/*
1. Add Dependency
2. Add Layouts
3. Create 2 New Classes
https://www.simplifiedcoding.net/intro-screen-slider-android-tutorial/
 */