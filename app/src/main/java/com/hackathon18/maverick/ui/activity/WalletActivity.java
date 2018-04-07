package com.hackathon18.maverick.ui.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
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
import android.widget.TextView;
import android.widget.Toast;

import com.hackathon18.maverick.R;
import com.hackathon18.maverick.databinding.ActivityWalletBinding;
import com.hackathon18.maverick.model.User;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class WalletActivity extends Activity {
    ActivityWalletBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_wallet);
        Bundle bundle = getIntent().getExtras();
        final String Username=bundle.getString("USER");
        final String Cnic=bundle.getString("NIC");
        final String Password=bundle.getString("PASSWORD");
        final String Credits=bundle.getString("CREDITS");
        final User currentUser=new User (Username,Cnic,Password,Credits);


        TextView Name=(TextView) findViewById(R.id.tvUsername);
        Name.setText(Username);

        TextView BalanceAmount=(TextView) findViewById(R.id.tvBalanceAmount);
        BalanceAmount.setText("CURRENT CREDIT : "+Credits+" PKR");

        binding.btShare.setOnClickListener(
             new View.OnClickListener(){

                 @Override
                 public void onClick(View view) {
                     Intent intent=new Intent(getApplicationContext(),ShareActivity.class);
                     intent.putExtra("USER",Username);
                     intent.putExtra("NIC",Cnic);
                     intent.putExtra("PASSWORD", Password);
                     intent.putExtra("CREDITS",Credits);
                     startActivity(intent);
                 }
             }

        );
        binding.btTransfer.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                         if (currentUser.canTransfer()) {
                             Intent intent = new Intent(getApplicationContext(), TransferActivity.class);
                             intent.putExtra("USER", Username);
                             intent.putExtra("NIC", Cnic);
                             intent.putExtra("PASSWORD", Password);
                             intent.putExtra("CREDITS", Credits);
                             startActivity(intent);
                         }
                         else{
                             Toast.makeText(WalletActivity.this, "You have insufficient credits to share",
                                     Toast.LENGTH_LONG).show();
                         }
                    }
                }

        );

        binding.btTopup.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent= new Intent(getApplicationContext(),TopUpActivity.class);
                        intent.putExtra("USER",Username);
                        intent.putExtra("NIC",Cnic);
                        intent.putExtra("PASSWORD", Password);
                        intent.putExtra("CREDITS",Credits);
                        startActivity(intent);
                    }
                }

        );

        binding.btDsVoucher.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent= new Intent(getApplicationContext(),DiscountVoucherActivity.class);
                        intent.putExtra("USER",Username);
                        intent.putExtra("NIC",Cnic);
                        intent.putExtra("PASSWORD", Password);
                        intent.putExtra("CREDITS",Credits);
                        startActivity(intent);
                    }
                }

        );


    }
}
