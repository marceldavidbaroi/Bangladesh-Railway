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

public class Register extends AppCompatActivity {

    static Register INSTANCE;
    String name;
    String phoneNumberS;
    String Password;
    String ConfirmPasswordS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        INSTANCE=this;

        super.onCreate(savedInstanceState);
        //remove action bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_register);
        //navigation button
        TextView home  = findViewById(R.id.home_vec);
        TextView eticket  = findViewById(R.id.ticket_vec);
        TextView user  = findViewById(R.id.user_vec);

        //navigation button workings
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, booking.class);
                startActivity(intent);
            }
        });

        eticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, Eticket.class);
                startActivity(intent);
            }
        });

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, About.class);
                startActivity(intent);
            }
        });


        EditText fullNAme = findViewById(R.id.Rname_et);
        EditText phoneNumber = findViewById(R.id.Rphone_et);
        EditText password = findViewById(R.id.Rpass_et);
        EditText ConfirmPassword = findViewById(R.id.Rconfpass_et);

        Button btn = findViewById(R.id.register_btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 name = fullNAme.getText().toString();
                 phoneNumberS = phoneNumber.getText().toString();
                 Password = password.getText().toString();
                 ConfirmPasswordS = ConfirmPassword.getText().toString();

                if(Password.equals(ConfirmPasswordS)){
                    Intent intent = new Intent(Register.this, booking.class);
                    //intent.putExtra("Phone",phoneNumberS);
                    //intent.putExtra("Name",name);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(Register.this,"Wrong password",Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    public static Register getActivityInstance()
    {
        return INSTANCE;
    }

    public String getData2()
    {
        return this.name;
    }
    public String getData3()
    {
        return this.phoneNumberS;
    }
    public String getDataPass()
    {
        return this.Password;
    }

}