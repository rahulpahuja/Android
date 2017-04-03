package com.rahul.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    //Time out Size in Milliseconds for the main Thread
    private static final int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //New Anonymous Handler for Time Delay
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Created an Intent to Start Another Activity
                Intent mainActivityStarterIntent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(mainActivityStarterIntent);

                //Finishes Current Activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
