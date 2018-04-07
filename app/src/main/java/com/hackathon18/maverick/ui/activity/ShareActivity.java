package com.hackathon18.maverick.ui.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.hackathon18.maverick.R;
import com.hackathon18.maverick.databinding.ActivityShareBinding;
import com.hackathon18.maverick.model.User;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class ShareActivity extends Activity {
    ActivityShareBinding binding;
    public static  int SPLASH_TIME_OUT=2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      binding= DataBindingUtil.setContentView(this,R.layout.activity_share);


        Bundle bundle = getIntent().getExtras();
        final String Username=bundle.getString("USER");
        final String Cnic=bundle.getString("NIC");
        final String Password=bundle.getString("PASSWORD");
        final String Credits=bundle.getString("CREDITS");

        binding.backBt.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                onBackPressed();

            }

        });
        binding.homeBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),WalletActivity.class);
                startActivity(intent);

            }
        });

        binding.btBroadCastMessage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        toast();
                        Intent intent=new Intent(getApplicationContext(),WalletActivity.class);
                        intent.putExtra("USER",Username);
                        intent.putExtra("NIC",Cnic);
                        intent.putExtra("PASSWORD", Password);
                        int temp=Integer.parseInt(Credits);
                        String creds=((EditText)findViewById(R.id.etAmountToBeShared)).getText().toString();
                        temp+=Integer.parseInt(creds);
                        creds=String.valueOf(temp);
                        intent.putExtra("CREDITS",creds);
                        startActivity(intent);

                        //close the activity
                        finish();
                    }

                },SPLASH_TIME_OUT);


            }
        });


    }
    public void toast(){
        Toast.makeText(ShareActivity.this, "Your funds have been shared",
                Toast.LENGTH_LONG).show();
    }
}
