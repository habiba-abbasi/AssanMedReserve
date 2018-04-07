package com.hackathon18.maverick.ui.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import com.hackathon18.maverick.R;
import com.hackathon18.maverick.databinding.ActivityLoginBinding;
import com.hackathon18.maverick.model.User;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class LoginActivity extends Activity {

    ActivityLoginBinding binding;
     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         binding= DataBindingUtil.setContentView(this, R.layout.activity_login);


         binding.btLoginLogin.setOnClickListener(new View.OnClickListener(){

             @Override
             public void onClick(View v){

                 EditText vi=((EditText)findViewById(R.id.etLoginUsername));
                 String Username=vi.getText().toString();
                 String Cnic="4220167368479";
                 String Password= binding.etLoginPassword.getText().toString();
                 User currentUser=new User (Username,Cnic,Password);
                 String Credits=String.valueOf(currentUser.creditsOfPreviousUser());

                 Intent intent = new Intent(getApplicationContext(),WalletActivity.class);
                 intent.putExtra("USER",Username);
                 intent.putExtra("NIC",Cnic);
                 intent.putExtra("PASSWORD", Password);
                 intent.putExtra("CREDITS",Credits);
                 startActivity(intent);
             }

         });
         binding.backBt.setOnClickListener(new View.OnClickListener(){

             @Override
             public void onClick(View v){

                 onBackPressed();

             }

         });
     }
}
