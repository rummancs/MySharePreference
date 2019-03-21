package com.example.ctbd.mysharepreference;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button btn = findViewById(R.id.button);

        final EditText emailText = findViewById(R.id.r_email_edit);
        final EditText passText = findViewById(R.id.r_pass_edit);
        final SharedPreferences pref = this.getSharedPreferences("TestApp", Activity.MODE_PRIVATE);

        btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String pass = passText.getText().toString();
            String email = emailText.getText().toString();
            if(pass != null && !pass.trim().isEmpty() && email != null && !email.trim().isEmpty())
            {
                pref.edit().putBoolean("is_USER_IN",true).apply();
                pref.edit().putBoolean("is_LOGGED_IN",true).apply();
                Intent intent = new Intent(RegisterActivity.this,HomeActivity.class);
                startActivity(intent);
            }
            else
            {
                pref.edit().putBoolean("is_USER_IN",false).apply();
            }


        }
    });
    }
}
