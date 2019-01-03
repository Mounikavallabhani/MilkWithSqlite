package com.example.admin.arkamilkproject.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.admin.arkamilkproject.Adopter.AdapterDescription;
import com.example.admin.arkamilkproject.Adopter.CustomAdapterMilk;
import com.example.admin.arkamilkproject.R;
import com.example.admin.arkamilkproject.model.ModelDescriptionMilk;
import com.example.admin.arkamilkproject.model.ModelMilk;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Brands extends AppCompatActivity {
    public AdapterDescription adapterDescription;
    RecyclerView recyclerView3;
    GridLayoutManager gridLayoutManager3;
    ArrayList<ModelDescriptionMilk> descriptionlist;
    String aname,aimage,acost,aml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand);
        recyclerView3 = findViewById(R.id.recyclerview3);
        int resId = R.anim.layout_animation_fall_down;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(Brands.this, resId);
        recyclerView3.setLayoutAnimation(animation);
//        descriptionlist = new ArrayList<>();
//        descriptionlist.add(new ModelDescriptionMilk(R.drawable.haritage512, "Heritage", "500ml", "25.00"));
//        descriptionlist.add(new ModelDescriptionMilk(R.drawable.haritage512, "Heritage", "500ml", "25.00"));
//        descriptionlist.add(new ModelDescriptionMilk(R.drawable.haritage512, "Heritage", "500ml", "25.00"));
//        descriptionlist.add(new ModelDescriptionMilk(R.drawable.haritage512, "Heritage", "500ml", "25.00"));
//        descriptionlist.add(new ModelDescriptionMilk(R.drawable.haritage512, "Heritage", "500ml", "25.00"));
//        descriptionlist.add(new ModelDescriptionMilk(R.drawable.haritage512, "Heritage", "500ml", "25.00"));
//        descriptionlist.add(new ModelDescriptionMilk(R.drawable.haritage512, "Heritage", "500ml", "25.00"));
//        descriptionlist.add(new ModelDescriptionMilk(R.drawable.haritage512, "Heritage", "500ml", "25.00"));
//        descriptionlist.add(new ModelDescriptionMilk(R.drawable.haritage512, "Heritage", "500ml", "25.00"));
        //descriptionlist.add(new ModelDescriptionMilk(R.drawable.haritage512, "Heritage", "500ml", "25.00"));
//        descriptionlist.add(new ModelDescriptionMilk(R.drawable.haritage512, "Heritage", "500ml", "25.00"));
//        descriptionlist.add(new ModelDescriptionMilk(R.drawable.haritage512, "Heritage", "500ml", "25.00"));
//        descriptionlist.add(new ModelDescriptionMilk(R.drawable.haritage512, "Heritage", "500ml", "25.00"));
//        descriptionlist.add(new ModelDescriptionMilk(R.drawable.haritage512, "Heritage", "500ml", "25.00"));
//        descriptionlist.add(new ModelDescriptionMilk(R.drawable.haritage512, "Heritage", "500ml", "25.00"));
//        descriptionlist.add(new ModelDescriptionMilk(R.drawable.haritage512, "Heritage", "500ml", "25.00"));
//        descriptionlist.add(new ModelDescriptionMilk(R.drawable.haritage512, "Heritage", "500ml", "25.00"));
//        descriptionlist.add(new ModelDescriptionMilk(R.drawable.haritage512, "Heritage", "500ml", "25.00"));
//        descriptionlist.add(new ModelDescriptionMilk(R.drawable.haritage512, "Heritage", "500ml", "25.00"));
//        descriptionlist.add(new ModelDescriptionMilk(R.drawable.haritage512, "Heritage", "500ml", "25.00"));
        gridLayoutManager3 = new GridLayoutManager(Brands.this, 1);
        recyclerView3.setLayoutManager(gridLayoutManager3);
//        adapterDescription = new AdapterDescription(getApplicationContext(), descriptionlist);
//        recyclerView3.setAdapter(adapterDescription);
        recyclerView3.setHasFixedSize(true);
        Allproducts();
    }
    public void Allproducts() {

        RequestQueue rq = Volley.newRequestQueue(Brands.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                "https://milk365.in/api/get_products",
                new Response.Listener<String>() {

                    public void onResponse(String response) {

                        try {
                            //     Toast.makeText(getActivity()," "+response,Toast.LENGTH_LONG).show();
                            JSONArray jsonObject1=new JSONArray(response);
                            //System.out.println("ohhk"+jsonObject1);
                            descriptionlist = new ArrayList<>();
                            //storeModel=new ArrayList<>();

                            for (int i=0;i<jsonObject1.length();i++) {
                                JSONObject jsonObject=jsonObject1.optJSONObject(i);
                                aname=jsonObject.getString("product_title");
                                aimage=jsonObject.getString("image_url");
                                acost=jsonObject.getString("product_price");
                                aml=jsonObject.getString("product_quantity");

                                descriptionlist.add(new ModelDescriptionMilk(aimage,aname,aml,acost));
                                //adapterMilk=new CustomAdapterMilk(getApplicationContext(),productlist);

                                recyclerView3.setAdapter(new AdapterDescription(getApplication(),descriptionlist));

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
                params.put("catid","6");
                params.put("subcatid","1");
                return params;
            }
        };
        rq.add(stringRequest);
    }
}