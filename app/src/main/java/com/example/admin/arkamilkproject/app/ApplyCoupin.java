package com.example.admin.arkamilkproject.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

public class ApplyCoupin extends AppCompatActivity {
    EditText coupontext;
    Button coupon;
    String user_coupon_id,user_ids, user_coupon_code,coupon_date;
    TextView nocoupon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_coupin);
        coupon=findViewById(R.id.coupon);
        coupontext=findViewById(R.id.coupontext);
        nocoupon=findViewById(R.id.nocoupon);
        Registration();


        coupon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ApplyCoupin.this, " Successfully Apply Coupon", Toast.LENGTH_SHORT).show();



            }
        });
    }
    protected void Registration() {

        RequestQueue rq = Volley.newRequestQueue(ApplyCoupin.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                "https://milk365.in/api/get_user_coupons",
                /* "http://carshuru.com/tst/grephor/register.php",*/
                new Response.Listener<String>() {

                    public void onResponse(String response) {

                        try {
                            JSONArray jsonObject=new JSONArray(response);
                            for (int i=0;i<jsonObject.length();i++) {
                                JSONObject jsonObject1 = jsonObject.optJSONObject(i);
                                Toast.makeText(ApplyCoupin.this, "" + jsonObject1, Toast.LENGTH_SHORT).show();
                                user_coupon_id = jsonObject1.getString("user_coupon_id");
                                user_ids = jsonObject1.getString("user_ids");
                                user_coupon_code = jsonObject1.getString("user_coupon_code");
                                coupon_date = jsonObject1.getString("coupon_date");
                                coupontext.setText(user_coupon_code);
                                Toast.makeText(ApplyCoupin.this, "text" + coupontext, Toast.LENGTH_SHORT).show();
                                if (coupontext.getText().toString().isEmpty()) {
                                    nocoupon.setVisibility(View.VISIBLE);

                                    Toast.makeText(ApplyCoupin.this, " Present No Coupons For You", Toast.LENGTH_SHORT).show();
                                } else {
                                    nocoupon.setVisibility(View.INVISIBLE);



                                }
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    };
                },new Response.ErrorListener() {

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
                params.put("userid","163");

                return params;
            }
        };
        rq.add(stringRequest);
    }
}
