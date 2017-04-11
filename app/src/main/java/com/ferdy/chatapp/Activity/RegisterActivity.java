package com.ferdy.chatapp.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ferdy.chatapp.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Button registerButton;
    EditText txtUsername, txtPassword, txtEmail;

    @Override
    public void onCreate(Bundle savedState){
        super.onCreate(savedState);
        setContentView(R.layout.activity_register);

        txtUsername = (EditText) findViewById(R.id.activity_usernameRegister);
        txtPassword = (EditText) findViewById(R.id.activity_passwordRegister);
        txtEmail = (EditText) findViewById(R.id.activity_emailRegister);
        registerButton = (Button) findViewById(R.id.activity_registerButtonRegister);

        sharedPreferences = getApplicationContext().getSharedPreferences("Reg", 0);
        editor = sharedPreferences.edit();

        registerButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String name = txtUsername.getText().toString();
        String password = txtPassword.getText().toString();
        String email = txtEmail.getText().toString();

        if(name.length() <= 0){
            Toast.makeText(this, "Enter username", Toast.LENGTH_SHORT).show();
        } else if (password.length() <= 0) {
            Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT).show();
        } else if (email.length() <= 0){
            Toast.makeText(this, "Enter email", Toast.LENGTH_SHORT).show();
        } else {
            editor.putString("Name", name);
            editor.putString("txtPassword", password);
            editor.putString("Email", email);
            editor.commit();

            startActivity(new Intent(this, LoginActivity.class));
        }
    }
}
