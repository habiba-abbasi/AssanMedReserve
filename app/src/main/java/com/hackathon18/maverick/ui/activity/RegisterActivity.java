package com.hackathon18.maverick.ui.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.hackathon18.maverick.R;
import com.hackathon18.maverick.databinding.ActivityRegisterBinding;
import com.hackathon18.maverick.model.User;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class RegisterActivity extends Activity {
    ActivityRegisterBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_register);



        binding.btRegister.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                EditText vi=((EditText)findViewById(R.id.etRegisterUsername));
                String Username=vi.getText().toString();
                Log.v("Name", "Name: "+Username);
                String Cnic=binding.etRegisterCNIC.getText().toString();
                String Password= binding.etRegisterPassword.getText().toString();
                User currentUser=new User (Username,Cnic,Password);
                String Credits=String.valueOf(currentUser.creditsOfNewUser());

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
               /* Intent intent=new Intent(getApplicationContext(),CategoryActivity.class);
                startActivity(intent);*/
                onBackPressed();

            }

        });
//        binding.homeBt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(getApplicationContext(),WalletActivity.class);
//                startActivity(intent);
//
//            }
//        });
    }
}
