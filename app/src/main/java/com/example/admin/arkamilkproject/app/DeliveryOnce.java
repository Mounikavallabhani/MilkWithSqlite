package com.example.admin.arkamilkproject.app;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.arkamilkproject.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DeliveryOnce extends AppCompatActivity {
    LinearLayout deliverydate;
    public DatePickerDialog toDatePickerDialog;
    private SimpleDateFormat dateFormatter;
    TextView deliverydatetext;
    Button confirmorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deliveryonce);
        deliverydate=findViewById(R.id.deliverydate);
        confirmorder=findViewById(R.id.confirmorder);
        confirmorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(DeliveryOnce.this,CheckOut.class);
                startActivity(intent);
            }
        });
        deliverydatetext=findViewById(R.id.deliverydatetext);
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        getDelivery();
        deliverydate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toDatePickerDialog.show();

            }
        });

    }
    public void getDelivery () {
        Calendar newCalendar = Calendar.getInstance();
        toDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                deliverydatetext.setText(dateFormatter.format(newDate.getTime()));
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }

}
