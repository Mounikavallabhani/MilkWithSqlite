package com.example.admin.arkamilkproject.fragmentsdata;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.admin.arkamilkproject.Adopter.CustomAdapterMilk;
import com.example.admin.arkamilkproject.Adopter.DashBoardViewPagerAdopter;


import com.example.admin.arkamilkproject.Adopter.StoreRecyclerviewAdopter;
import com.example.admin.arkamilkproject.MyDbHandler;
import com.example.admin.arkamilkproject.R;
import com.example.admin.arkamilkproject.app.DashBoard;
import com.example.admin.arkamilkproject.app.ProductActivity;
import com.example.admin.arkamilkproject.app.Registration;
import com.example.admin.arkamilkproject.interfacesdata.ItemClickListener;
import com.example.admin.arkamilkproject.model.ModelMilk;
import com.example.admin.arkamilkproject.model.Products;
import com.example.admin.arkamilkproject.model.StoreModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class Store  extends Fragment  {

    private static final Integer[] images = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    private ArrayList<Integer> imageArray = new ArrayList<Integer>();
    private static ViewPager mPager;
    private static int currentPage = 0;
    private Intent i;
    View view;
    String aname,aimage,p_c_id,category_status;
    Products products;
    MyDbHandler dbHandler;




    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    ArrayList<StoreModel> storeModel;
    StoreRecyclerviewAdopter storeRecyclerviewAdopter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      view =inflater.inflate(R.layout.fragment_store,container,false);
        dbHandler = new MyDbHandler(getActivity(), null, null, 1);
      init();

      DashboardData();
        return view;
    }

    private void init() {
        for (int i = 0; i < images.length; i++)
            imageArray.add(images[i]);

        mPager = (ViewPager)view.findViewById(R.id.pager);
        mPager.setAdapter(new DashBoardViewPagerAdopter(getActivity(), imageArray));
    //    CircleIndicator indicator = (CircleIndicator)view.findViewById(R.id.indicator);
    //    indicator.setViewPager(mPager);

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == images.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 2500, 2500);

    }

    public void DashboardData(){

        recyclerView=(RecyclerView)view.findViewById(R.id.recyclerview);
        linearLayoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        recyclerView=(RecyclerView)view.findViewById(R.id.recyclerview);
        linearLayoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

//        storeModel=new ArrayList<>();
//        storeModel.add(new StoreModel("Dairy",R.drawable.milk_64));
//        storeModel.add(new StoreModel("Curd",R.drawable.curd_64));
//        storeModel.add(new StoreModel("Bakery",R.drawable.bakery_64));
//        storeModel.add(new StoreModel("Pooja",R.drawable.lamp_64));


//        recyclerView.setAdapter(new StoreRecyclerviewAdopter(getActivity(),storeModel));

        Allproducts();
    }
    public void Allproducts() {

        RequestQueue rq = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                "https://milk365.in/api/get_product_categories",
                new Response.Listener<String>() {

                    public void onResponse(String response) {

                        try {
                            //     Toast.makeText(getActivity()," "+response,Toast.LENGTH_LONG).show();
                            JSONArray jsonObject1=new JSONArray(response);
                            System.out.println("ohhk"+jsonObject1);
                            storeModel=new ArrayList<>();
                            //storeModel=new ArrayList<>();

                            for (int i=0;i<jsonObject1.length();i++) {
                                JSONObject jsonObject=jsonObject1.optJSONObject(i);
                                p_c_id=jsonObject.getString("p_c_id");
                                aname=jsonObject.getString("product_category");
                                aimage=jsonObject.getString("image_url");
                                category_status=jsonObject.getString("category_status");

                                products=new Products(p_c_id,aname,aimage,category_status);
                                dbHandler.addProduct(products);




                                storeModel.add(new StoreModel(aname,aimage));
                                recyclerView.setAdapter(new StoreRecyclerviewAdopter(getActivity(),storeModel,dbHandler));

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





                return params;
            }
        };
        rq.add(stringRequest);
    }




}
