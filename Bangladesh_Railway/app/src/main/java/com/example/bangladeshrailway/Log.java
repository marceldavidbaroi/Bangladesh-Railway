package com.example.bangladeshrailway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Log extends AppCompatActivity {


    static Log INSTANCE;
    String Phone;
    String PhoneLog;
    String passLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        INSTANCE=this;

        super.onCreate(savedInstanceState);
        //remove action bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_log);

        EditText phone = findViewById(R.id.logPhone_et);
        EditText password = findViewById(R.id.logPass_et);
        Button login = findViewById(R.id.log_btn);
        TextView Register2 = findViewById(R.id.register_tv);

         //PhoneLog = Register.getActivityInstance().getData3();
         //passLog = Register.getActivityInstance().getDataPass();
//keeps crashing if log and register is synchronize


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(password.getText().toString().equals("T") ){

                     Phone = phone.getText().toString();
                    Intent intent = new Intent(Log.this, booking.class);
                    //intent.putExtra("Phone",Phone);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(Log.this,"Wrong password",Toast.LENGTH_SHORT).show();
                }
            }
        });

        Register2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Log.this, Register.class);
                startActivity(intent);
            }
        });



    }

    // to use data in other activity without intent
    //using static method
    public static Log getActivityInstance()
    {
        return INSTANCE;
    }

    public String getData()
    {
        return this.Phone;
    }
}