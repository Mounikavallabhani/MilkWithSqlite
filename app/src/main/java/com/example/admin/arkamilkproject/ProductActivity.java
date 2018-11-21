package com.example.admin.arkamilkproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {
    public CustomAdapter adapter;
    public CustomAdapterMilk adapterMilk;
    RecyclerView recyclerView,recyclerView2;
    GridLayoutManager gridLayoutManager,gridLayoutManager1;
    ArrayList<Model>list;
    ArrayList<ModelMilk>productlist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        recyclerView=findViewById(R.id.recyclerview1);
        recyclerView2=findViewById(R.id.recyclerview2);

        list=new ArrayList<>();
        list.add(new Model("Hertage"));
        list.add(new Model("Hertage"));
        list.add(new Model("Hertage"));
        list.add(new Model("Hertage"));
        list.add(new Model("Hertage"));
        list.add(new Model("Hertage"));

        productlist=new ArrayList<>();
        productlist.add(new ModelMilk(R.drawable.products,"Heritage","500ml","25"));
        productlist.add(new ModelMilk(R.drawable.products,"Heritage","500ml","25"));
        productlist.add(new ModelMilk(R.drawable.products,"Heritage","500ml","25"));
        productlist.add(new ModelMilk(R.drawable.products,"Heritage","500ml","25"));
        productlist.add(new ModelMilk(R.drawable.products,"Heritage","500ml","25"));


        gridLayoutManager=new GridLayoutManager(ProductActivity.this,3);
        gridLayoutManager1=new GridLayoutManager(ProductActivity.this,1);

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView2.setLayoutManager(gridLayoutManager1);

        adapter = new CustomAdapter(getApplicationContext(),list);
        adapterMilk=new CustomAdapterMilk(getApplicationContext(),productlist);
        recyclerView.setAdapter(adapter);
        recyclerView2.setAdapter(adapterMilk);

    }
}
