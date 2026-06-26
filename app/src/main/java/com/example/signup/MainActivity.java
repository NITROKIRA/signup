package com.example.signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText emailText, passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        emailText = findViewById(R.id.Email);
        passwordText = findViewById(R.id.Password);
    }
    Pattern lowercase = Pattern.compile(".*[a-z].*$");
    Pattern uppercase = Pattern.compile(".*[A-Z].*$");
    Pattern number = Pattern.compile(".*[0-9].*$");
    Pattern SChar = Pattern.compile(".*[^a-zA-Z0-9].*$");

    private Boolean isValidPassword(String password) {

        if (password.length() < 8) {
            return false;
        }

        if (!lowercase.matcher(password).matches()) {
            return false;
        }

        if (!uppercase.matcher(password).matches()) {
            return false;
        }

        if (!number.matcher(password).matches()) {
            return false;
        }

        if (!SChar.matcher(password).matches()) {
            return false;
        }

        return true;
    }

    public void signup(View view) {

        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        if (!isValidPassword(password)) {
            Toast.makeText(this,
                    "Password does not match rules",
                    Toast.LENGTH_LONG).show();
            return;
        }

        Intent i = new Intent(this, LoginActivity.class);
        i.putExtra("email", email);
        i.putExtra("password", password);
        startActivity(i);
    }


}