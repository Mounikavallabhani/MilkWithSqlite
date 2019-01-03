package com.example.admin.arkamilkproject.app;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.arkamilkproject.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Subscription extends AppCompatActivity  {
    LinearLayout startdate, enddate;
    public DatePickerDialog fromDatePickerDialog;
    public DatePickerDialog toDatePickerDialog;
    private SimpleDateFormat dateFormatter;
    Button confirmsbs;
    TextView startdatetext, enddatetext;
    CheckBox alternativeday,everyday;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscription);
        startdate = findViewById(R.id.startdate);
        enddate = findViewById(R.id.enddate);
        confirmsbs = findViewById(R.id.confirmsbs);
        alternativeday=findViewById(R.id.alternativeday);
        everyday=findViewById(R.id.everyday);
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        startdatetext = findViewById(R.id.startdatetext);
        enddatetext = findViewById(R.id.enddatetext);
        getStartDate();
        getEndDate();


        startdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fromDatePickerDialog.show();
                fromDatePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                }
        });
        enddate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toDatePickerDialog.show();
                toDatePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());

            }
        });
        confirmsbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(startdatetext.getText().toString().isEmpty())
                {
                    startdatetext.requestFocus();
                    startdatetext.setError("Enter date");
                }
                else if(enddatetext.getText().toString().isEmpty())
                {
                    enddatetext.requestFocus();
                    enddatetext.setError("Enter date");
                }
                else if(everyday.isChecked()||alternativeday.isChecked()) {

                    isDateAfter(startdatetext.getText().toString(), enddatetext.getText().toString());
                    Intent intent = new Intent(Subscription.this, CheckOut.class);
                    sharedPreferences=getSharedPreferences("scheduledetails",Context.MODE_PRIVATE);
                    editor=sharedPreferences.edit();
                    editor.putString("startdate",startdatetext.toString());
                    editor.putString("enddate",enddatetext.toString());
                    editor.apply();
                    editor.commit();

                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(Subscription.this, " Select The Days", Toast.LENGTH_SHORT).show();
                }

            }
        });


        everyday.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    alternativeday.setChecked(false);



                }
            }
        });
        alternativeday.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    everyday.setChecked(false);



                }
            }
        });
    }



    private void getStartDate() {
        Calendar newCalendar = Calendar.getInstance();
        fromDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear+1, dayOfMonth+0);
                startdatetext.setText(dateFormatter.format(newDate.getTime()));
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }

    public void getEndDate() {
        Calendar newCalendar = Calendar.getInstance();
        toDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear+1, dayOfMonth+0);
                enddatetext.setText(dateFormatter.format(newDate.getTime()));

            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }

    public void isDateAfter(String startDate, String endDate) {
        try {
            Date date1 = dateFormatter.parse(endDate);
            Date startingDate = dateFormatter.parse(startDate);


            if (date1.after(startingDate)) {
                Toast.makeText(Subscription.this, "Date is Valid", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(Subscription.this, "End Date is before StartDate", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}
