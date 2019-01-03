package com.example.admin.arkamilkproject.Adopter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.arkamilkproject.R;
import com.example.admin.arkamilkproject.model.WalletModel;

import java.util.ArrayList;

public class WalletAdopter extends RecyclerView.Adapter<WalletAdopter.MyHolder> {
    Context context;
    ArrayList<WalletModel>walletModel;

    public WalletAdopter(Context context, ArrayList<WalletModel> walletModel) {
        this.context = context;
        this.walletModel = walletModel;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.wallet_items,viewGroup,false);
        return new MyHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {

        WalletModel walletModel1=walletModel.get(i);
        myHolder.w1.setText("Wallet Transition :");
        myHolder.w2.setText("\u20B9 "+walletModel1.getWallettransition());
        myHolder.w3.setText("Wallet Status : ");
        myHolder.w4.setText(walletModel1.getWalletstatus());
        if(myHolder.w4.getText()=="debited"){
            myHolder.w4.setTextColor(Color.GREEN);

        }else if(myHolder.w4.getText()=="credited"){
            myHolder.w4.setTextColor(Color.RED);

        }
    }

    @Override
    public int getItemCount() {
        return walletModel.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView w1,w2,w3,w4;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            w1=(TextView)itemView.findViewById(R.id.w1);
            w2=(TextView)itemView.findViewById(R.id.w2);
            w3=(TextView)itemView.findViewById(R.id.w3);
            w4=(TextView)itemView.findViewById(R.id.w4);

        }
    }
}
