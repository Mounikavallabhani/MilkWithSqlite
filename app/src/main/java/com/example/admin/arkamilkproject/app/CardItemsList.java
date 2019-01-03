package com.example.admin.arkamilkproject.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.admin.arkamilkproject.Adopter.CardItemsDataAdopter;
import com.example.admin.arkamilkproject.R;
import com.example.admin.arkamilkproject.model.CardItemsDataModel;

import java.util.ArrayList;

public class CardItemsList extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayout;
    ArrayList<CardItemsDataModel>cardItemsDataModels;
    CardItemsDataAdopter cardItemsDataAdopter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_items_list);

        recyclerView=(RecyclerView)findViewById(R.id.curditemsdata);
        linearLayout=new LinearLayoutManager(this);
        cardItemsDataModels=new ArrayList<>();

        cardItemsDataModels.add(new CardItemsDataModel(R.drawable.haritage512, "Heritage", "500ml", "25.00"));
        cardItemsDataModels.add(new CardItemsDataModel(R.drawable.haritage512, "Heritage", "500ml", "25.00"));
        cardItemsDataModels.add(new CardItemsDataModel(R.drawable.haritage512, "Heritage", "500ml", "25.00"));
        cardItemsDataModels.add(new CardItemsDataModel(R.drawable.haritage512, "Heritage", "500ml", "25.00"));
        cardItemsDataModels.add(new CardItemsDataModel(R.drawable.haritage512, "Heritage", "500ml", "25.00"));
        cardItemsDataModels.add(new CardItemsDataModel(R.drawable.haritage512, "Heritage", "500ml", "25.00"));
        cardItemsDataModels.add(new CardItemsDataModel(R.drawable.haritage512, "Heritage", "500ml", "25.00"));
        cardItemsDataModels.add(new CardItemsDataModel(R.drawable.haritage512, "Heritage", "500ml", "25.00"));
        cardItemsDataModels.add(new CardItemsDataModel(R.drawable.haritage512, "Heritage", "500ml", "25.00"));
        cardItemsDataModels.add(new CardItemsDataModel(R.drawable.haritage512, "Heritage", "500ml", "25.00"));
        recyclerView.setLayoutManager(linearLayout);
        recyclerView.setHasFixedSize(true);
        cardItemsDataAdopter=new CardItemsDataAdopter(this,cardItemsDataModels);
        recyclerView.setAdapter(cardItemsDataAdopter);
    }
}
