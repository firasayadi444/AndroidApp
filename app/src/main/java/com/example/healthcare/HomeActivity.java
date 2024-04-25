package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        // Find the TextView where you want to display the username
        TextView textViewUsername = findViewById(R.id.textViewUsername);

        // Retrieve the username from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("loginDetails", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");

        // Display the retrieved username in the TextView
        textViewUsername.setText("Welcome, " + username);
    }
}