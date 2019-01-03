package com.example.admin.arkamilkproject.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.EditText;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    TextView signup;
    Button login;
    LinearLayout loginlayout;
    EditText lemail,lpassword,regname;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String register_id,register_name,register_email,register_mobile;
    TextView forgetpwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        lemail=(EditText)findViewById(R.id.lemail);
        lpassword=(EditText)findViewById(R.id.lpassword);
        signup=(TextView)findViewById(R.id.Signup);
        forgetpwd=findViewById(R.id.forgetpwd);
        login=findViewById(R.id.login);
        loginlayout=findViewById(R.id.loginlayout);
        sharedPreferences = getSharedPreferences("logindetails", Context.MODE_PRIVATE);
        int resId = R.anim.layoutslidebottom;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(Login.this, resId);
        loginlayout.setLayoutAnimation(animation);
        forgetpwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,ForgetPassword.class);
                startActivity(intent);

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = lemail.getText().toString().trim();

                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


                  if(lpassword.getText().toString().isEmpty()){
                      lpassword.requestFocus();
                      lpassword.setError("Enter Password ");
                  }
                  if (email.matches(emailPattern)||email.length()==10) {
                 //    LoginValidation();
                      Intent intent = new Intent(Login.this, DashBoard.class);
                      startActivity(intent);
                }else {
                      lemail.requestFocus();
                      lemail.setError("Enter Proper details ");

                  }
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Login.this,Registration.class);
                startActivity(intent);
            }
        });
    }

  /*  public void  LoginValidation(){

        RequestQueue rq = Volley.newRequestQueue(Login.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                "https://milk365.in/api/login",
                *//* "http://carshuru.com/tst/grephor/register.php",*//*
                new Response.Listener<String>() {

                    public void onResponse(String response) {


                        try {
                            JSONObject jsonObject1=new JSONObject(response);
                            String message=jsonObject1.getString("message");
                           System.out.println("Narasimha:"+response);
                            Intent intent = new Intent(Login.this, DashBoard.class);
                            startActivity(intent);

                         *//*   if(message.equals("User Not Valid")){
                                Toast.makeText(Login.this,"Please Enter Correct Details" ,Toast.LENGTH_LONG).show();

                                lemail.setText("");
                                lpassword.setText("");

                            }else {

                                sharedPreferences=getSharedPreferences("logindetails",Context.MODE_PRIVATE);

                                JSONArray jsonArray=new JSONArray("data");

                                System.out.println("Narasimha:"+response);
                                for(int i=0;i<jsonArray.length();i++){
                                    JSONObject jsonObject=jsonArray.getJSONObject(i);
                                    register_id=jsonObject.getString("register_id");
                                    register_name=jsonObject.getString("register_name");
                                    register_email=jsonObject.getString("register_email");
                                    register_mobile=jsonObject.getString("register_mobile");
                                }

                                SharedPreferences.Editor editor = sharedPreferences.edit();


                                editor.putString("register_id",register_id);
                                editor.putString("register_email",register_email);
                                editor.putString("register_name",register_name);
                                editor.putString("register_mobile",register_mobile);

                                editor.apply();
                                editor.commit();


                                Toast.makeText(Login.this,"Suceessfully Login" ,Toast.LENGTH_LONG).show();
*//*
                         //   }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
           //               Toast.makeText(Login.this,"oddd "+response,Toast.LENGTH_LONG).show();
       //        System.out.println("Narasimha"+response);



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

                params.put(" email",lemail.getText().toString());
                params.put("password",lpassword.getText().toString());


                return params;
            }
        };
        rq.add(stringRequest);
    }*/

}
