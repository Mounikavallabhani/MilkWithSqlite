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


import com.example.admin.arkamilkproject.MyDbHandler;
import com.example.admin.arkamilkproject.R;
import com.example.admin.arkamilkproject.app.ProductActivity;
import com.example.admin.arkamilkproject.interfacesdata.ItemClickListener;
import com.example.admin.arkamilkproject.model.StoreModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class StoreRecyclerviewAdopter extends RecyclerView.Adapter<StoreRecyclerviewAdopter.MyViewHolder> {
    Context context;
    ArrayList<StoreModel>list;
    private ItemClickListener clickListener;
    MyDbHandler dbHandler;
    public StoreRecyclerviewAdopter(Context activity,ArrayList<StoreModel>list,MyDbHandler dbHandler ){
        this.context=activity;
        this.list=list;
        this.dbHandler=dbHandler;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.recuclerview_items,viewGroup,false);
        return new MyViewHolder(view,context,list);
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final StoreModel storeModel=list.get(i);

        myViewHolder.textView.setText(storeModel.getName());

        Picasso.with(context)
                .load(storeModel.getImage())
                .into(myViewHolder.imageView);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Typeface tf_regular1;
        public TextView textView;
        public ImageView imageView;
        public LinearLayout linearLayout;
        Context context;
        ArrayList<StoreModel>list;
        String dbString;
        String ids,name;
        String[] totaldata;
        public MyViewHolder(@NonNull View itemView ,Context  context , ArrayList<StoreModel>list) {
            super(itemView);
            this.context=context;
            this.list=list;
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
            imageView=(ImageView) itemView.findViewById(R.id.titleimage);
            textView=(TextView)itemView.findViewById(R.id.titletext);
            linearLayout=(LinearLayout)itemView.findViewById(R.id.contaent_liner);
            tf_regular1 = Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/six.otf");
            /*  Typeface type1 = Typeface.createFromAsset(getAssets(),"fonts/agaramondpro_bold.otf");*/
            this.textView.setTypeface(tf_regular1);

        }

        @Override
        public void onClick(View v) {

            final Intent intent;
            int a=getAdapterPosition()+1;

            dbString = dbHandler.databaseToStringTwo(a);
            //name=dbHandler.databaseToStringOne(a);

            // Toast.makeText(context,"one "+dbString,Toast.LENGTH_LONG).show();
            intent =  new Intent(context, ProductActivity.class);
            intent.putExtra("catidone",dbString);
            intent.putExtra("name",name);

            context.startActivity(intent);


        }
    }
}
