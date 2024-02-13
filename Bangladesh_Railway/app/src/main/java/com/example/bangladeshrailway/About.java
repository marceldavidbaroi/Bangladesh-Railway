package com.example.bangladeshrailway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //remove action bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_about);

        //navigation button
        TextView home  = findViewById(R.id.home_vec);
        TextView eticket  = findViewById(R.id.ticket_vec);
        TextView user  = findViewById(R.id.user_vec);

       //navigation button workings
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(About.this, booking.class);
                startActivity(intent);
            }
        });

        eticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(About.this, Eticket.class);
                startActivity(intent);
            }
        });

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(About.this, About.class);
                startActivity(intent);
            }
        });


        TextView name = findViewById(R.id.name);
        TextView phone = findViewById(R.id.phone);
        Button logout = findViewById(R.id.logout_btn);

        String N = Register.getActivityInstance().getData2();
        name.setText(N);
        String P = Register.getActivityInstance().getData3();
        phone.setText(P);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(About.this,Log.class);
                startActivity(intent);
            }
        });

    }
}