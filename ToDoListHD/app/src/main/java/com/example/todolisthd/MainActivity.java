package com.example.todolisthd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String usernameHD, passwordHD;
    Button btnLogin;
    EditText etUsername, etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameHD = "chadra";
        passwordHD = "pala";
        etUsername = findViewById(R.id.etLoginUsername);
        etPassword = findViewById(R.id.etLoginPassword);

        btnLogin = findViewById(R.id.btnSignIn);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etPassword.getText().toString().equals(passwordHD) &&
                        etUsername.getText().toString().equals(usernameHD)  )
                {
                    Intent i = new Intent(getApplicationContext(), ToDoListCustom.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Invalid Credentiols", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}