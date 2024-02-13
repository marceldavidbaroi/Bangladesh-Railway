package com.example.bangladeshrailway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Eticket extends AppCompatActivity {
    String P;
    String F;
    String T;
    String D;
    String C;
    String Tr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //remove action bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_eticket);

        //navigation button
        TextView home  = findViewById(R.id.home_vec);
        TextView eticket  = findViewById(R.id.ticket_vec);
        TextView user  = findViewById(R.id.user_vec);

        //navigation button workings
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Eticket.this, booking.class);
                startActivity(intent);
            }
        });

        eticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Eticket.this, Eticket.class);
                startActivity(intent);
            }
        });

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Eticket.this, About.class);
                startActivity(intent);
            }
        });


        Button btn = findViewById(R.id.print_btn);

        TextView phone = findViewById(R.id.TPhone2_tv);
        TextView form = findViewById(R.id.Tfrom2_tv);
        TextView to = findViewById(R.id.Tto2_tv);
        TextView date = findViewById(R.id.TDFJ2_tv);
        TextView Class = findViewById(R.id.Tclass2_tv);
       // TextView time = findViewById(R.id.Ttime2_tv);
        TextView train = findViewById(R.id.Ttrain2_tv);

        P = Confirm.getActivityInstance().CgetDataP();
        phone.setText(P);
        F = Confirm.getActivityInstance().CgetDataF();
        form.setText(F);
        T = Confirm.getActivityInstance().CgetDataT();
        to.setText(T);
        D = Confirm.getActivityInstance().CgetDataD();
        date.setText(D);
        C = Confirm.getActivityInstance().CgetDataC();
        Class.setText(C);
        Tr = Confirm.getActivityInstance().CgetDataTr();
        train.setText(Tr);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Eticket.this,"Printing Started",Toast.LENGTH_SHORT).show();
            }
        });

    }
}