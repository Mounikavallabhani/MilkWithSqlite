package com.example.admin.arkamilkproject.app;

import android.content.Intent;
import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import com.example.admin.arkamilkproject.R;
import com.example.admin.arkamilkproject.app.DashBoard;
import com.example.admin.arkamilkproject.app.Login;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration extends AppCompatActivity {
    TextView login ;
    Button register;
    EditText regemailid,regname,regnumber,regpassword,regconfirmpass;
    boolean temp=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        login=(TextView)findViewById(R.id.login);
        regemailid=findViewById(R.id.regemailid);
        regname=findViewById(R.id.regname);
        regnumber=findViewById(R.id.regnumber);
        regpassword=findViewById( R.id.regpassword);
        regconfirmpass=findViewById(R.id.regconfirmpass );

        register=findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = regemailid.getText().toString().trim();

                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

// onClick of button perform this simplest code.

                if(regname.getText().toString().isEmpty())
                {
                    regname.requestFocus();
                    regname.setError(" Enter Name");
                }
                else if(regnumber.length()!=10)
                {
                    regnumber.requestFocus();
                    regnumber.setError(" Enter Proper Mobile Number");

                }
                else if(regpassword.getText().toString().isEmpty())
                {
                    regpassword.requestFocus();
                    regpassword.setError(" Enter Password");
                }
              /*  if(newPassword.getText().toString().length()<8 &&!isValidPassword(newPassword.getText().toString())){
                    System.out.println("Not Valid");
                }else{
                    System.out.println("Valid");
                }*/

                else if(regpassword.getText().toString().length()<8 &&!isValidPassword(regpassword.getText().toString())){
                    regpassword.requestFocus();
                    regpassword.setError("Password Should be 8 Cherecters");
                }
                else if(regconfirmpass.getText().toString().isEmpty())
                {
                    regconfirmpass.requestFocus();
                    regconfirmpass.setError(" Enter Password");
                }
                else if(!regconfirmpass .getText().toString().equals(regpassword.getText().toString())){
                    Toast.makeText(Registration.this,"Password Not matching",Toast.LENGTH_SHORT).show();
                    // temp=false;
                }
                else if (email.matches(emailPattern)) {
                    Registration();
             //       Toast.makeText(getApplicationContext(),"valid email address",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Invalid email address", Toast.LENGTH_SHORT).show();
                }
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Registration.this,Login.class);
                startActivity(intent);
            }
        });


    }
    protected void Registration() {

        RequestQueue rq = Volley.newRequestQueue(Registration.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                "https://milk365.in/api/register",
                /* "http://carshuru.com/tst/grephor/register.php",*/
                new Response.Listener<String>() {

                    public void onResponse(String response) {

                        try {
                              Toast.makeText(Registration.this," "+response,Toast.LENGTH_LONG).show();
                            JSONObject jsonObject1=new JSONObject(response);
                            String message=jsonObject1.getString("message");
                            Toast.makeText(Registration.this,""+message,Toast.LENGTH_LONG).show();
                            if(message.equals("Email Already Exist")){
                                regemailid.requestFocus();
                                regemailid.setError("This Mail alredy Exist");
                            }else if(message.equals("Phone Number Already Exist")){
                                regnumber.requestFocus();
                                regnumber.setError("This Phone Number alredy Exist");

                            }else {
                                    Intent intent = new Intent(Registration.this, DashBoard.class);
                                    regemailid.setText("");
                                    regname.setText("");
                                    regnumber.setText("");
                                    regpassword.setText("");
                                    regconfirmpass.setText("");
                                    startActivity(intent);
                                }

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

                params.put("fname",regname.getText().toString());
                params.put("email",regemailid.getText().toString());
                params.put("mobile",regnumber.getText().toString());
                params.put("pass",regpassword.getText().toString());


                return params;
            }
        };
        rq.add(stringRequest);
    }
    public static boolean isValidPassword(final String password) {

        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }
}
