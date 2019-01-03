package com.example.admin.arkamilkproject.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.admin.arkamilkproject.Adopter.CustomAdapter;
import com.example.admin.arkamilkproject.R;
import com.example.admin.arkamilkproject.model.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CheckOut extends AppCompatActivity {
    Button checkdecrement,checkincrement;
    TextView checkadd;
    TextView t1,t2,t3,t4,t5;
    int count=1;
    SharedPreferences sharedPreferences;
    String  remid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        t1=(TextView)findViewById(R.id.t1);
        t2=(TextView)findViewById(R.id.t2);
        t3=(TextView)findViewById(R.id.t3);
        t4=(TextView)findViewById(R.id.t4);
        //t5=(TextView)findViewById(R.id.t5);
        checkdecrement=findViewById(R.id.checkdecrement);
        checkincrement=findViewById(R.id.checkincrement);
        checkadd=findViewById(R.id.checkadd);

        t1.setText("\u20B9"+" 25.00");
        t2.setText("\u20B9"+" 25.00");
        t3.setText("\u20B9"+" 0.00");
        t4.setText("\u20B9"+" 0.00");
        //t5.setText("\u20B9"+" 25.00");

        sharedPreferences = getSharedPreferences("productdetails", MODE_PRIVATE);

        final String uname = sharedPreferences.getString("increment", null);
        checkadd.setText(uname);





        checkincrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count= Integer.valueOf(uname);
                count++;
                checkadd.setText(String.valueOf(count));

            }
        });
        checkdecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (count > 1) {
                    count= Integer.valueOf(uname);
                    count--;
                    checkadd.setText(String.valueOf(count));
                }

            }
        });



    }
    public void jsondata() {

        RequestQueue rq = Volley.newRequestQueue(CheckOut.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                "https://milk365.in/api/get_subcategories_categorieid",
                new Response.Listener<String>() {

                    public void onResponse(String response) {

                        try {
                            //     Toast.makeText(getActivity()," "+response,Toast.LENGTH_LONG).show();
                            JSONArray jsonObject1=new JSONArray(response);





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
               params.put("user_id","108");
                params.put("gtotal","250");
                params.put("stotal","120");
                params.put("product_id","1");
                params.put("product_image","test");
                params.put("product_name","hertage");
                params.put("product_price","200");
                params.put("p_qty","1");
                params.put("delivery_type","online");
                params.put("start_date","2018-12-31");
                params.put("end_date","2018-12-31");
                params.put("recharge","10");
                params.put("extra_qty","5");
                params.put("weekends","5");
                params.put("order_type","paid");
                params.put("delivery_date","2017-12-31");




                return params;
            }
        };
        rq.add(stringRequest);
    }

}
