package com.example.bangladeshrailway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class Thankyou extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //remove action bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_thankyou);

        TextView pMethod = findViewById(R.id.payment_display);
        Button btn = findViewById(R.id.back_btn);

        Intent all_intent = getIntent();
        String F = all_intent.getStringExtra("pmet");
        pMethod.setText("Payment done by "+F);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Thankyou.this, booking.class);
                startActivity(intent);
            }
        });


    }
}