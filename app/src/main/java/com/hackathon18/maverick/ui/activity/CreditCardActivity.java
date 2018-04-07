package com.hackathon18.maverick.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.hackathon18.maverick.R;
import com.hackathon18.maverick.databinding.ActivityCreditCardBinding;
import com.hackathon18.maverick.model.User;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class CreditCardActivity extends Activity {
    ActivityCreditCardBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_credit_card);

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

        binding.btCreditCardTopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = getIntent().getExtras();
                final String Username=bundle.getString("USER");
                final String Cnic=bundle.getString("NIC");
                final String Password=bundle.getString("PASSWORD");
                String Credits=bundle.getString("CREDITS");
                User currentUser=new User (Username,Cnic,Password,Credits);

                EditText amountText=(EditText)findViewById(R.id.etCreditCardAmount);
                int amount=Integer.parseInt(amountText.getText().toString());
                int currentAmount=Integer.parseInt(Credits);
                Credits=String.valueOf(currentAmount+amount);

                final String cred=Credits;

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

