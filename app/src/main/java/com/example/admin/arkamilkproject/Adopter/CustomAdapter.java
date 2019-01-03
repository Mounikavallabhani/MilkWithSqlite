package com.example.admin.arkamilkproject.Adopter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.arkamilkproject.app.Brands;
import com.example.admin.arkamilkproject.app.ProductActivity;
import com.example.admin.arkamilkproject.model.Model;
import com.example.admin.arkamilkproject.R;


import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    Context contect;
    ProductActivity productActivity;
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
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final Model model =list.get(position);
        holder.producttext.setText(model.getText());
        holder.linearitemtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(contect.getApplicationContext(),Brands.class);
                contect.startActivity(intent);
                }
                }
        );


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView producttext;
        LinearLayout linearitemtext;
        Typeface tf_regular1;
        public ViewHolder(View itemView) {
            super(itemView);
            producttext=itemView.findViewById(R.id.producttext);
            linearitemtext=(LinearLayout)itemView.findViewById(R.id.linearitemtext);

            tf_regular1 = Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/six.otf");
            /*  Typeface type1 = Typeface.createFromAsset(getAssets(),"fonts/agaramondpro_bold.otf");*/
            this.producttext.setTypeface(tf_regular1);

        }

    }
}
