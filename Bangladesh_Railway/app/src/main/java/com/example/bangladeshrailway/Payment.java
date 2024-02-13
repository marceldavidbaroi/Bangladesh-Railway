package com.example.bangladeshrailway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Payment extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //remove action bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_payment);

        RadioGroup radioGroup = findViewById(R.id.PaymentType);
        //navigation button
        TextView home  = findViewById(R.id.home_vec);
        TextView eticket  = findViewById(R.id.ticket_vec);
        TextView user  = findViewById(R.id.user_vec);

        //navigation button workings
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Payment.this, booking.class);
                startActivity(intent);
            }
        });

        eticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Payment.this, Eticket.class);
                startActivity(intent);
            }
        });

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Payment.this, About.class);
                startActivity(intent);
            }
        });


        Button select = findViewById(R.id.select_btn);

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int payment = radioGroup.getCheckedRadioButtonId();
                RadioButton pType = (RadioButton) findViewById(payment);
                String PaymentMethod =  pType.getText().toString();

                Intent intent = new Intent(Payment.this, Thankyou.class);
                intent.putExtra("pmet",PaymentMethod);
                startActivity(intent);
            }
        });



    }

}