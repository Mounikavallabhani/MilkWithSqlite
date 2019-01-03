package com.example.admin.arkamilkproject.Adopter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.arkamilkproject.app.ProductDescriptionActivity;
import com.example.admin.arkamilkproject.model.ModelMilk;
import com.example.admin.arkamilkproject.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapterMilk extends RecyclerView.Adapter<CustomAdapterMilk.ViewHolder> {
    Context context;
    LinearLayout recyclerviewonclick;
    ArrayList<ModelMilk> productlist;
    public CustomAdapterMilk(Context context, ArrayList<ModelMilk> productlist) {
        this.context = context;
        this.productlist = productlist;

    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.productchaild2, parent, false);


        return new ViewHolder(v,context,productlist);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final ModelMilk modelMilk=productlist.get(position);
        holder.productname.setText(modelMilk.getProductname());
        holder.productml.setText(modelMilk.getProductml());
        holder.prouctcost.setText("\u20B9"+modelMilk.getProductcost());
        //holder.productimage.setBackgroundResource(modelMilk.getImage());
        Picasso.with(context).
                load(modelMilk.getImage())
                .into(holder.productimage);



    }


    @Override
    public int getItemCount() {
        return productlist.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView productname,productml,prouctcost;
        ImageView productimage;
         Typeface tf_regular1,tf_regular2;
       Context context;
       ArrayList<ModelMilk>productlist=new ArrayList<>();
        public ViewHolder(View itemView,Context context,ArrayList<ModelMilk>productlist) {
            super(itemView);
             this.context=context;
             this.productlist=productlist;
            itemView.setOnClickListener(this);
            recyclerviewonclick=itemView.findViewById(R.id.recyclerviewonclick);
            productname = itemView.findViewById(R.id.productname);
            productml=itemView.findViewById(R.id.productml);
            prouctcost=itemView.findViewById(R.id.productcost);
            productimage=itemView.findViewById(R.id.productimage);
            tf_regular1 = Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/six.otf");
            tf_regular2 = Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/six.otf");

            /*  Typeface type1 = Typeface.createFromAsset(getAssets(),"fonts/agaramondpro_bold.otf");*/
            this.productname.setTypeface(tf_regular1);
            this.productml.setTypeface(tf_regular2);
            this.prouctcost.setTypeface(tf_regular2);


    }
        @Override
        public void onClick(View v) {

            int position=getAdapterPosition();
            ModelMilk modelMilk=this.productlist.get(position);
            Intent intent=new Intent(this.context,ProductDescriptionActivity.class);
            intent.putExtra("image",modelMilk.getImage());
            intent.putExtra("name",modelMilk.getProductname());
            intent.putExtra("size",modelMilk.getProductml());
            intent.putExtra("cost",modelMilk.getProductcost());
            Toast.makeText(context,""+modelMilk.getProductcost(),Toast.LENGTH_LONG).show();
           System.out.println("Narasimha"+modelMilk.getProductcost());
            this.context.startActivity(intent);


        }
    }
}