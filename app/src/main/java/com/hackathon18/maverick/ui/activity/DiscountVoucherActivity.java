package com.hackathon18.maverick.ui.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

import com.hackathon18.maverick.R;
import com.hackathon18.maverick.databinding.ActivityDiscountVoucherBinding;
import com.hackathon18.maverick.model.User;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class DiscountVoucherActivity extends Activity {
ActivityDiscountVoucherBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_discount_voucher);
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
                intent.putExtra("USER",Username);
                intent.putExtra("NIC",Cnic);
                intent.putExtra("PASSWORD", Password);
                intent.putExtra("CREDITS",Credits);
                startActivity(intent);

            }
        });
        binding.btDiscountVoucherDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),WalletActivity.class);
                intent.putExtra("USER",Username);
                intent.putExtra("NIC",Cnic);
                intent.putExtra("PASSWORD", Password);
                intent.putExtra("CREDITS",Credits);
                startActivity(intent);

            }
        });
    }
}
