package com.example.introslider.SplashSkrean;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.example.introslider.MainActivity2;
import com.example.introslider.R;

public class Theopeningscreen extends AppCompatActivity {
    private static int SPLASH_TIMER=5000;

    SharedPreferences onBoardingScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.theopen_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onBoardingScreen =getSharedPreferences("onBoardingScreen",MODE_PRIVATE);
                boolean isFirstTime =onBoardingScreen.getBoolean("firstTime",true);


                if (isFirstTime){

                    SharedPreferences.Editor editor=onBoardingScreen.edit();
                    editor.putBoolean("firstTime",false);
                    editor.commit();
                    Intent intent=new Intent(getApplicationContext(), SplachScreen.class);
                    startActivity(intent);
                    finish();
                }else {

                    Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                    startActivity(intent);
                    finish();

                }


            }
        },SPLASH_TIMER);


    }
}