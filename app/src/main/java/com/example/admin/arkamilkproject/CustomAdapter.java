package com.example.admin.arkamilkproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    Context contect;

    public CustomAdapter(Context contect, ArrayList<Model> list) {
        this.contect = contect;
        this.list = list;
    }

    ArrayList<Model>list;



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.productchiled, parent, false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final Model model=list.get(position);
        holder.producttext.setText(model.getText());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView producttext;
        public ViewHolder(View itemView) {
            super(itemView);
            producttext=itemView.findViewById(R.id.producttext);
        }

    }
}
