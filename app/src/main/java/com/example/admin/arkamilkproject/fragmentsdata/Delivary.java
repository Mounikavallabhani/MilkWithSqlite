package com.example.admin.arkamilkproject.fragmentsdata;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.admin.arkamilkproject.R;
import com.example.admin.arkamilkproject.app.CheckOut;
import com.example.admin.arkamilkproject.app.DashBoard;
import com.example.admin.arkamilkproject.app.Registration;
import com.example.admin.arkamilkproject.app.Subscription;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;


import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Delivary   extends Fragment {
    LinearLayout vstartdate, venddate;
    public DatePickerDialog fromDatePickerDialog;
    public DatePickerDialog toDatePickerDialog;
    private SimpleDateFormat dateFormatter;
    Button vbutton;
    TextView vstartdatetext, venddatetext;

    public Delivary() {
        // Required empty public constructor
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_delivary,container,false);
        vstartdate =view.findViewById(R.id.vstartdate);
        venddate = view.findViewById(R.id.venddate);
        vbutton =view.findViewById(R.id.vbutton);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        vstartdatetext =view.findViewById(R.id.vstartdatetext);
        venddatetext = view.findViewById(R.id.venddatetext);
        getStartDate();
        getEndDate();
        vstartdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fromDatePickerDialog.show();
                fromDatePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());

            }
        });
        venddate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toDatePickerDialog.show();
                fromDatePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());

            }
        });
        vbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vstartdatetext.getText().toString().isEmpty())
                {
                    vstartdatetext.requestFocus();
                    vstartdatetext.setError("please Enter Date");
                }
                if(venddatetext.getText().toString().isEmpty())
                {
                    venddatetext.requestFocus();
                    venddatetext.setError("please Enter Date");

                }
                else {
                    isDateAfter(vstartdatetext.getText().toString(), venddatetext.getText().toString());
                    Toast.makeText(getActivity(), "Your Vacation Period is set", Toast.LENGTH_SHORT).show();
                    Registration();
                }

            }
        });



        return view;
    }
    private void getStartDate() {
        final Calendar newCalendar = Calendar.getInstance();
        fromDatePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            //fromDatePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();


                newDate.set(year, monthOfYear+1, dayOfMonth+0);
                vstartdatetext.setText(dateFormatter.format(newDate.getTime()));
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }

    public void getEndDate() {
        Calendar newCalendar = Calendar.getInstance();
        toDatePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear+1, dayOfMonth+0);
                venddatetext.setText(dateFormatter.format(newDate.getTime()));

            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }

    public void isDateAfter(String startDate, String endDate) {
        try {
            Date date1 = dateFormatter.parse(endDate);
            Date startingDate = dateFormatter.parse(startDate);


            if (date1.after(startingDate)) {
                Toast.makeText(getActivity(), "Date is Valid", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(getActivity(), "End Date is before StartDate", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void Registration() {

        RequestQueue rq = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                "https://milk365.in/api/set_vacation",
                /* "http://carshuru.com/tst/grephor/register.php",*/
                new Response.Listener<String>() {

                    public void onResponse(String response) {

                        try {

                            JSONObject jsonObject1=new JSONObject(response);
                            Toast.makeText(getActivity(), "hai"+jsonObject1, Toast.LENGTH_SHORT).show();




                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    };
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError arg0) {
                // TODO Auto-generated method stub
                //   pd.hide();
            }
        })

        {
            @Override
            public Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                   params.put("sstart",vstartdatetext.toString());
                   params.put("send",venddatetext.toString());
                   params.put("remarks","haii");
                   params.put("userid","155");


                return params;
            }
        };
        rq.add(stringRequest);
    }
}
