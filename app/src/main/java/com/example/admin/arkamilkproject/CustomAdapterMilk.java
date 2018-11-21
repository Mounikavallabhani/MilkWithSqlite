package com.example.admin.arkamilkproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapterMilk extends RecyclerView.Adapter<CustomAdapterMilk.ViewHolder> {
    Context context;

    public CustomAdapterMilk(Context context, ArrayList<ModelMilk> productlist) {
        this.context = context;
        this.productlist = productlist;

    }

    ArrayList<ModelMilk> productlist;


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.productchaild2, parent, false);
        CustomAdapterMilk.ViewHolder vh = new CustomAdapterMilk.ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final ModelMilk modelMilk=productlist.get(position);
        holder.productname.setText(modelMilk.getProductname());
        holder.productml.setText(modelMilk.getProductml());
        holder.productcost.setText(modelMilk.getProductcost());
        holder.productimage.setBackgroundResource(modelMilk.getImage());




    }


    @Override
    public int getItemCount() {
        return productlist.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView productname,productml,productcost;
        ImageView productimage;

        public ViewHolder(View itemView) {
            super(itemView);
            productname = itemView.findViewById(R.id.productname);
            productml=itemView.findViewById(R.id.productml);
            productcost=itemView.findViewById(R.id.productcost);
            productimage=itemView.findViewById(R.id.productimage);
        }

    }
}