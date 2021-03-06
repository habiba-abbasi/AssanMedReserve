package com.hackathon18.maverick.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hackathon18.maverick.R;
import com.hackathon18.maverick.databinding.ActivitySplashBinding;

import me.anwarshahriar.calligrapher.Calligrapher;

public class SplashActivity extends Activity {

    ActivitySplashBinding binding;

    public static  int SPLASH_TIME_OUT=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_splash);
       // calligrapher =new Calligrapher(this);
        //calligrapher.setFont(this,"Roboto-Thin.ttf",true);


         //Font styling
//        Calligrapher calligrapher=new Calligrapher(SplashActivity.this);
//        calligrapher.setFont(SplashActivity.this,"Roboto-Thin.ttf",true);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent= new Intent(SplashActivity.this,HomeActivity.class);
                startActivity(intent);

                //close the activity
                finish();
            }

        },SPLASH_TIME_OUT);
    }
}
