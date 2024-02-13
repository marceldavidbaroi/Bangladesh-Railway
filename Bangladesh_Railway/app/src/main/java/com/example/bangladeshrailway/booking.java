package com.example.bangladeshrailway;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class booking extends AppCompatActivity {

    Calendar myCalender;
    EditText DOJ;
    String[] class_list1;
    String[] train_list1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //remove action bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_booking);

        //navigation button
        TextView home  = findViewById(R.id.home_vec);
        TextView eticket  = findViewById(R.id.ticket_vec);
        TextView user  = findViewById(R.id.user_vec);

        //navigation button workings
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(booking.this, booking.class);
                startActivity(intent);
            }
        });

        eticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(booking.this, Eticket.class);
                startActivity(intent);
            }
        });

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(booking.this, About.class);
                startActivity(intent);
            }
        });


//activity
        EditText from = findViewById(R.id.Bfrom_et);
        EditText to = findViewById(R.id.Bto_et);
         DOJ = findViewById(R.id.BDOJ_et);
         myCalender = Calendar.getInstance();
        Spinner class_spinner = findViewById(R.id.class_spinner);
        Spinner train_spinner = findViewById(R.id.train_spinner);

        Button btn = findViewById(R.id.submit_btn);



        //accessing array
        class_list1 = getResources().getStringArray(R.array.class_list);
        train_list1 = getResources().getStringArray(R.array.train_list);


        //class
        ArrayAdapter<String> arrayAdapter_class = new ArrayAdapter<String>(this,R.layout.sample_view,R.id.tv_sample_view,class_list1);
        class_spinner.setAdapter(arrayAdapter_class);

        //train
        ArrayAdapter<String> arrayAdapter_train = new ArrayAdapter<String>(this,R.layout.sample_view,R.id.tv_sample_view,train_list1);
        train_spinner.setAdapter(arrayAdapter_train);


        //Date picker
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalender.set(Calendar.YEAR,year);
                myCalender.set(Calendar.MONTH,month);
                myCalender.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                updateLabel();
            }
        };

        DOJ.setOnClickListener(view-> {
            new DatePickerDialog
            (booking.this, date, myCalender.get(Calendar.YEAR), myCalender.get(Calendar.MONTH), myCalender.get(Calendar.DAY_OF_MONTH))
                    .show();
        });




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String From = from.getText().toString();
                String To = to.getText().toString();
                String class_value = class_spinner.getSelectedItem().toString();
                String train_value = train_spinner.getSelectedItem().toString();
                String date = DOJ.getText().toString();
                Intent booking_intent = new Intent(booking.this, Confirm.class);
                booking_intent.putExtra("From",From);
                booking_intent.putExtra("To",To);
                booking_intent.putExtra("Class",class_value);
                booking_intent.putExtra("Train",train_value);
                booking_intent.putExtra("Date",date);
                startActivity(booking_intent);

            }
        });

    }




    private void updateLabel() {
        String myFormat = "MM/dd/yy EEEE";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        DOJ.setText(dateFormat.format(myCalender.getTime()));



    }
}