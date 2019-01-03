package com.example.admin.arkamilkproject.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.admin.arkamilkproject.Adopter.OrderHestoryAdopter;
import com.example.admin.arkamilkproject.R;
import com.example.admin.arkamilkproject.model.OrderHestoryModel;

import java.util.ArrayList;

public class OrderHestory extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayout;
    OrderHestoryAdopter orderHestoryAdopter;
    ArrayList<OrderHestoryModel> orderHestoryModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_hestory);
        recyclerView=(RecyclerView)findViewById(R.id.orderhistroy);
        linearLayout=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayout);
        recyclerView.setHasFixedSize(true);

        orderHestoryModel=new ArrayList<>();
        orderHestoryModel.add(new OrderHestoryModel("Hertage","delivered at 27 now 2018 at 7;00AM"," 500ml milk packets","Total "+"\u20B9"+"  50.00"));
        orderHestoryModel.add(new OrderHestoryModel("Vijaya","delivered at 27 now 2018 at 7;00AM"," 500ml milk packets","Total "+"\u20B9"+"  50.00"));
        orderHestoryModel.add(new OrderHestoryModel("Amul","delivered at 27 now 2018 at 7;00AM"," 500ml milk packets","Total "+"\u20B9"+"  50.00"));
        orderHestoryModel.add(new OrderHestoryModel("Jersey","delivered at 27 now 2018 at 7;00AM"," 500ml milk packets","Total "+"\u20B9"+"  50.00"));
        orderHestoryModel.add(new OrderHestoryModel("Thirumala","delivered at 27 now 2018 at 7;00AM"," 500ml milk packets","Total "+"\u20B9"+"  50.00"));
          orderHestoryAdopter=new OrderHestoryAdopter(getApplicationContext(),orderHestoryModel);
        recyclerView.setAdapter(orderHestoryAdopter);
    }


}
