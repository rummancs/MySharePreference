package com.example.ctbd.mysharepreference;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final SharedPreferences pref = this.getSharedPreferences("TestApp",Activity.MODE_PRIVATE);
        final boolean isUserin = pref.getBoolean("is_USER_IN",false);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(isUserin)
                {
                    pref.edit().putBoolean("is_USER_IN",true).apply();
                    Intent i = new Intent(SplashActivity.this,HomeActivity.class);
                    startActivity(i);
                    finish();
                }
                else
                {
                    Intent i = new Intent(SplashActivity.this,LoginActivity.class);
                    startActivity(i);
                    finish();
                }


            }
        },5000);
    }
}
