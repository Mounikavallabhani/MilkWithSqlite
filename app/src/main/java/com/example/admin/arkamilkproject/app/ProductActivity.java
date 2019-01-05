package com.example.admin.arkamilkproject.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.admin.arkamilkproject.Adopter.CustomAdapter;
import com.example.admin.arkamilkproject.Adopter.CustomAdapterMilk;
import com.example.admin.arkamilkproject.model.Model;
import com.example.admin.arkamilkproject.model.ModelMilk;
import com.example.admin.arkamilkproject.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProductActivity extends AppCompatActivity {
    public CustomAdapter adapter;
    public CustomAdapterMilk adapterMilk;
    RecyclerView recyclerView,recyclerView2;
    GridLayoutManager gridLayoutManager,gridLayoutManager1;
    ArrayList<Model>list;
    ArrayList<ModelMilk>productlist;
    String name;
    String aname,aimage,acost,aml;
    String passedArg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        recyclerView=findViewById(R.id.recyclerview1);
        recyclerView2=findViewById(R.id.recyclerview2);
        int resId = R.anim.layout_animation_fall_down;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(ProductActivity.this, resId);
        recyclerView2.setLayoutAnimation(animation);
        passedArg = getIntent().getExtras().getString("catidone");

        itemName();
             m2();
    }
             public void itemName() {
//             list=new ArrayList<>();
//        list.add(new Model("Hertage"));
//        list.add(new Model("Amul"));
//        list.add(new Model("Thirumala"));
//        list.add(new Model("Vijaya"));
//        list.add(new Model("Jersey"));
//        list.add(new Model("Hertage"));


                 gridLayoutManager = new GridLayoutManager(ProductActivity.this, 3);
                 recyclerView.setLayoutManager(gridLayoutManager);
//                 adapter = new CustomAdapter(getApplicationContext(), list);
//                 recyclerView.setAdapter(adapter);
                 recyclerView.setHasFixedSize(true);
                 jsondata();
             }

             public  void m2(){
        recyclerView2=findViewById(R.id.recyclerview2);
//        productlist=new ArrayList<>();
//        productlist.add(new ModelMilk(R.drawable.milk,"Heritage","500ml","25.00"));
//        productlist.add(new ModelMilk(R.drawable.milk,"Amul","500ml","25.00"));
//        productlist.add(new ModelMilk(R.drawable.milk,"Thirumala","500ml","25.00"));
//        productlist.add(new ModelMilk(R.drawable.milk,"Vijaya","500ml","25.00"));
//        productlist.add(new ModelMilk(R.drawable.milk,"Jersey","500ml","25.00"));
//        productlist.add(new ModelMilk(R.drawable.milk,"Heritage","500ml","25.00"));
//        productlist.add(new ModelMilk(R.drawable.milk,"Amul","500ml","25.00"));
//        productlist.add(new ModelMilk(R.drawable.milk,"Thirumala","500ml","25.00"));
//        productlist.add(new ModelMilk(R.drawable.milk,"Vijaya","500ml","25.00"));
//        productlist.add(new ModelMilk(R.drawable.milk,"Jersey","500ml","25.00"));
        gridLayoutManager1=new GridLayoutManager(ProductActivity.this,1);
        recyclerView2.setLayoutManager(gridLayoutManager1);
//        adapterMilk=new CustomAdapterMilk(getApplicationContext(),productlist);
//        recyclerView2.setAdapter(adapterMilk);
        recyclerView2.setHasFixedSize(true);
                 Allproducts();


    }
    public void jsondata() {

        RequestQueue rq = Volley.newRequestQueue(ProductActivity.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                "https://milk365.in/api/get_subcategories_categorieid",
                new Response.Listener<String>() {

                    public void onResponse(String response) {

                        try {
                            //     Toast.makeText(getActivity()," "+response,Toast.LENGTH_LONG).show();
                            JSONArray jsonObject1=new JSONArray(response);
                            //System.out.println("ohhk"+jsonObject1);
                            list=new ArrayList<>();
                            //storeModel=new ArrayList<>();
                            String name,image;
                            for (int i=0;i<jsonObject1.length();i++) {
                                JSONObject jsonObject=jsonObject1.optJSONObject(i);
                                name=jsonObject.getString("sub_category");

                                list.add(new Model(name));

                                recyclerView.setAdapter(new CustomAdapter(getApplication(),list));

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
                 params.put("subcatid","6");



                return params;
            }
        };
        rq.add(stringRequest);
    }

    public void Allproducts() {

        RequestQueue rq = Volley.newRequestQueue(ProductActivity.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                "https://milk365.in/api/get_products_with_catid",
                new Response.Listener<String>() {

                    public void onResponse(String response) {

                        try {
                            //     Toast.makeText(getActivity()," "+response,Toast.LENGTH_LONG).show();
                            JSONArray jsonObject1=new JSONArray(response);
                            //System.out.println("ohhk"+jsonObject1);
                            productlist=new ArrayList<>();
                            //storeModel=new ArrayList<>();

                            for (int i=0;i<jsonObject1.length();i++) {
                                JSONObject jsonObject=jsonObject1.optJSONObject(i);
                                aname=jsonObject.getString("product_title");
                                aimage=jsonObject.getString("image_url");
                                acost=jsonObject.getString("product_price");
                                aml=jsonObject.getString("product_quantity");

                                productlist.add(new ModelMilk(aimage,aname,aml,acost));
                                adapterMilk=new CustomAdapterMilk(getApplicationContext(),productlist);

                                //recyclerView2.setAdapter(new CustomAdapterMilk(getApplication(),productlist));
                                recyclerView2.setAdapter(adapterMilk);

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
                params.put("catid",passedArg);




                return params;
            }
        };
        rq.add(stringRequest);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem search = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(search);
        search(searchView);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    private void search(SearchView searchView) {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                if (adapterMilk != null) adapterMilk.getFilter().filter(newText);
                return true;
            }
        });
    }
}
