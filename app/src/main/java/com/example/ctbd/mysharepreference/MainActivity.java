package com.example.ctbd.mysharepreference;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        SharedPreferences pref = this.getSharedPreferences("TestApp",Activity.MODE_PRIVATE);

        boolean isLoggedin = pref.getBoolean("is_LOGGED_IN",false);
        boolean isUserLoggedin = pref.getBoolean("is_USER_IN",false);

        if(isLoggedin)
        {
            if(isUserLoggedin) // if user logged in
            {
                Intent i = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(i);
                finish();
            }
            else
            {
                Intent i = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(i);
                finish();
            }

        }
        else
        {
            Intent i = new Intent(MainActivity.this,SplashActivity.class);
            startActivity(i);
            finish();
        }

    }
}
