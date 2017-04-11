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
import com.ferdy.chatapp.UserSession;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button loginButton, registerButton;
    private static final String PREFER_NAME = "Reg";
    EditText txtUsername, txtPassword;

    UserSession session;

    private SharedPreferences sharedPreferences;



    @Override
    public void onCreate(Bundle savedState){
        super.onCreate(savedState);
        setContentView(R.layout.activity_login);

        loginButton = (Button) findViewById(R.id.activity_buttonLogin);
        loginButton.setOnClickListener(this);

        registerButton = (Button) findViewById(R.id.activity_buttonRegister);
        registerButton.setOnClickListener(this);

        session = new UserSession(getApplicationContext());

        txtUsername = (EditText) findViewById(R.id.activity_usernameLogin);
        txtPassword = (EditText) findViewById(R.id.activity_passwordLogin);

        Toast.makeText(getApplicationContext(),"User Login Status: " + session.isUserLoggedIn(),Toast.LENGTH_LONG).show();

        sharedPreferences = getSharedPreferences(PREFER_NAME, MODE_PRIVATE);



    }

    @Override
    public void onClick(View view) {

        if(view == loginButton) {

            String userName = txtUsername.getText().toString();
            String password = txtPassword.getText().toString();

            if(userName.trim().length() > 0 && password.trim().length() > 0){
                String uName = null;
                String uPassword = null;

                if(sharedPreferences.contains("Name")){
                    uName = sharedPreferences.getString("Name", "");
                }

                if (sharedPreferences.contains("txtPassword")){
                    uPassword = sharedPreferences.getString("txtPassword", "");
                }

                if(userName.equals(uName) && password.equals(uPassword)) {
                    session.createUserLoginSession(uName, uPassword);

                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(i);

                    finish();

                }else {
                    Toast.makeText(getApplicationContext(),"Username & Password doesnt match", Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(getApplicationContext(), "Please enter username & password", Toast.LENGTH_SHORT).show();
            }



        }else if(view == registerButton){
            startActivity(new Intent(this, RegisterActivity.class));
        }
    }


}
