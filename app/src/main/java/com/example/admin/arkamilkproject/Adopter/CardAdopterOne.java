package com.example.admin.arkamilkproject.Adopter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.arkamilkproject.R;
import com.example.admin.arkamilkproject.app.CardItemsList;
import com.example.admin.arkamilkproject.model.CardModelOne;

import java.util.ArrayList;

public class CardAdopterOne extends RecyclerView.Adapter<CardAdopterOne.MyAdopter> {
    Context c;
    ArrayList<CardModelOne>cardModelOne;

    public CardAdopterOne(Context c, ArrayList<CardModelOne> cardModelOne) {
        this.c = c;
        this.cardModelOne = cardModelOne;
    }

    @NonNull
    @Override
    public MyAdopter onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(c).inflate(R.layout.carditemlist,viewGroup,false);

        return new MyAdopter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdopter myAdopter, int i) {

        CardModelOne cardModelOne1=cardModelOne.get(i);
        myAdopter.textView.setText(cardModelOne1.getName());
        myAdopter.linearitemtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(c.getApplicationContext(),CardItemsList.class);
                c.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cardModelOne.size();
    }

    public class MyAdopter extends RecyclerView.ViewHolder {
        TextView textView;
        LinearLayout linearitemtext;
        public MyAdopter(@NonNull View itemView) {
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.cardproducttext);
            linearitemtext=(LinearLayout)itemView.findViewById(R.id.linearitemtext);
        }
    }
}
