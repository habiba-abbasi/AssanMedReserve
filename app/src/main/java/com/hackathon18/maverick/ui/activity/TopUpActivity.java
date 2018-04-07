package com.hackathon18.maverick.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.hackathon18.maverick.R;
import com.hackathon18.maverick.databinding.ActivityTopUpBinding;
import com.hackathon18.maverick.model.User;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class TopUpActivity extends Activity {

    ActivityTopUpBinding binding;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    binding=DataBindingUtil.setContentView(this,R.layout.activity_top_up);
        Bundle bundle = getIntent().getExtras();
        final String Username=bundle.getString("USER");
        final String Cnic=bundle.getString("NIC");
        final String Password=bundle.getString("PASSWORD");
        final String Credits=bundle.getString("CREDITS");
        final User currentUser=new User (Username,Cnic,Password,Credits);



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

        binding.btCreditCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),CreditCard1Activity.class);
                intent.putExtra("USER",Username);
                intent.putExtra("NIC",Cnic);
                intent.putExtra("PASSWORD", Password);
                intent.putExtra("CREDITS",Credits);
                startActivity(intent);
            }
        });
    }


}
