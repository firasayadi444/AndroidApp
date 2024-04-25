package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private TextView registerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Database db = new Database(getApplicationContext(),"healthcare",null,1);

        // Find views by their IDs
        usernameEditText = findViewById(R.id.editTextloginusername);
        passwordEditText = findViewById(R.id.editTextloginpassword);
        loginButton = findViewById(R.id.buttonlogin);
        registerTextView = findViewById(R.id.register);

        // Set onClickListener for loginButton
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform login authentication here
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Example: Check if username and password are empty
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please enter username and password", Toast.LENGTH_SHORT).show();
                } else {
                      if (db.checkUser(username,password)){
                // Local storage or small cookies
                          SharedPreferences sharedPreferences = getSharedPreferences("loginDetails", Context.MODE_PRIVATE);
                          SharedPreferences.Editor editor = sharedPreferences.edit();
                          editor.putString("username",username);
                          editor.apply();

                          Toast.makeText(LoginActivity.this, "Login succes", Toast.LENGTH_SHORT).show();
                          startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                      }
                      else {
                          Toast.makeText(LoginActivity.this, "Invalid Login or password ", Toast.LENGTH_SHORT).show();
                      }
                }
            }
        });

        // Set onClickListener for registerTextView
        registerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start RegisterActivity when registerTextView is clicked
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

}}
