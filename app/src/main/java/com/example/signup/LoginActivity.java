package com.example.signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity {

    EditText emailText, passwordText;
    String rEmail, rPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login);

        emailText = findViewById(R.id.Email1);
        passwordText = findViewById(R.id.Password1);

        rEmail = getIntent().getStringExtra("email");
        rPassword = getIntent().getStringExtra("password");
    }

    public void login(View view) {

        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        if (rEmail.equals(email) && rPassword.equals(password)) {

//            Intent j = new Intent(this, InstantParseResult.Success.class);
//            startActivity(j);
            Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
        } else {

            Toast.makeText(this,
                    "Invalid credentials",
                    Toast.LENGTH_SHORT).show();
        }
    }
}