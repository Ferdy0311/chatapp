package com.ferdy.chatapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.ferdy.chatapp.Activity.LoginActivity;
import com.ferdy.chatapp.Activity.MainActivity;

public class SplashScreen extends AppCompatActivity implements Animation.AnimationListener {
    Animation anim;
    TextView text;
    UserSession session;
    private SharedPreferences preferences;

    @Override
    public void onCreate(Bundle savedState){
        super.onCreate(savedState);
        setContentView(R.layout.activity_splash);
        text = (TextView) findViewById(R.id.activity_splashText);
        anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        anim.setAnimationListener(this);
        text.startAnimation(anim);

        session = new UserSession(getApplicationContext());
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

        if (session.isUserLoggedIn() != true){
            startActivity(new Intent(this, LoginActivity.class));
        }else{
            startActivity(new Intent(this, MainActivity.class));
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }


}
