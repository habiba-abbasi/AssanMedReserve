package com.hackathon18.maverick.ui.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
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
import com.hackathon18.maverick.databinding.ActivityTransferBinding;
import com.hackathon18.maverick.model.User;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class TransferActivity extends Activity {
ActivityTransferBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_transfer);
        System.out.println("how are you>");






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

        binding.btSendCredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = getIntent().getExtras();
                String Username=bundle.getString("USER");
                String Cnic=bundle.getString("NIC");
                String Password=bundle.getString("PASSWORD");
                String Credits=bundle.getString("CREDITS");
                EditText amountText=(EditText)findViewById(R.id.etTransfer_AmountOfCredit);
                int amount=Integer.parseInt(amountText.getText().toString());
                int currentAmount=Integer.parseInt(Credits);
                String cred;
                if(currentAmount<amount){
                     cred = Credits;
                    Toast.makeText(TransferActivity.this, "You have insufficient credits to transfer",
                            Toast.LENGTH_LONG).show();
                }
                else {
                    Credits = String.valueOf(currentAmount - amount);
                     cred = Credits;
                }
                Intent intent=new Intent(getApplicationContext(),WalletActivity.class);
                intent.putExtra("USER",Username);
                intent.putExtra("NIC",Cnic);
                intent.putExtra("PASSWORD", Password);
                intent.putExtra("CREDITS",cred);
                startActivity(intent);

            }
        });
    }
}
