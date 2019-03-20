package com.example.ctbd.mysharepreference;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.SharedPreferences;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btn = findViewById(R.id.button);

        Button regbutton = findViewById(R.id.reg_button);

        final EditText emailText = findViewById(R.id.email_edit);
        final EditText passText = findViewById(R.id.password_edit);
        final SharedPreferences pref = this.getSharedPreferences("TestApp",Activity.MODE_PRIVATE);

        btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String pass = passText.getText().toString();
            String email = emailText.getText().toString();

            Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
            startActivity(intent);
            pref.edit().putBoolean("is_USER_IN",true).apply();
        }
    });

    // register click
    regbutton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
            startActivity(intent);
            //pref.edit().putBoolean("is_USER_IN",false).apply();
        }
    });


    }
}
