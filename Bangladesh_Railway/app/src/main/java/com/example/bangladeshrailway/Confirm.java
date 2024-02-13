package com.example.bangladeshrailway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class Confirm extends AppCompatActivity {

    static Confirm INSTANCE;
    String P;
    String F;
    String T;
    String D;
    String C;
    String Tr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        INSTANCE=this;
        super.onCreate(savedInstanceState);
        //remove action bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_confirm);

        //navigation button
        TextView home  = findViewById(R.id.home_vec);
        TextView eticket  = findViewById(R.id.ticket_vec);
        TextView user  = findViewById(R.id.user_vec);

        //navigation button workings
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Confirm.this, booking.class);
                startActivity(intent);
            }
        });

        eticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Confirm.this, Eticket.class);
                startActivity(intent);
            }
        });

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Confirm.this, About.class);
                startActivity(intent);
            }
        });


        Button btn = findViewById(R.id.confirm_btn);

        TextView phone = findViewById(R.id.TPhone2_tv);
        TextView form = findViewById(R.id.Tfrom2_tv);
        TextView to = findViewById(R.id.Tto2_tv);
        TextView date = findViewById(R.id.TDFJ2_tv);
        TextView Class = findViewById(R.id.Tclass2_tv);
        TextView time = findViewById(R.id.Ttime2_tv);
        TextView train = findViewById(R.id.Ttrain2_tv);


        Intent all_intent = getIntent();
       //exception
         P = Register.getActivityInstance().getData3();
        phone.setText(P);

         F = all_intent.getStringExtra("From");
        form.setText(F);
         T = all_intent.getStringExtra("To");
        to.setText(T);
         D = all_intent.getStringExtra("Date");
        date.setText(D);
         C = all_intent.getStringExtra("Class");
        Class.setText(C);
       // String T = all_intent.getStringExtra("Date");
       // phone.setText(T);
         Tr = all_intent.getStringExtra("Train");
        train.setText(Tr);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Confirm.this, Payment.class);
                startActivity(intent);
            }
        });


    }

    // to use data in other activity without intent
    //using static method
    public static Confirm getActivityInstance()
    {
        return INSTANCE;
    }

    public String CgetDataP()
    {
        return this.P;
    }
    public String CgetDataF()
    {
        return this.F;
    }
    public String CgetDataT()
    {
        return this.T;
    }
    public String CgetDataD()
    {
        return this.D;
    }
    public String CgetDataC()
    {
        return this.C;
    }
    public String CgetDataTr()
    {
        return this.Tr;
    }
}