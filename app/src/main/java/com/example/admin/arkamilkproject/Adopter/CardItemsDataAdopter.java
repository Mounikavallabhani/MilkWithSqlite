package com.example.admin.arkamilkproject.Adopter;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.arkamilkproject.R;
import com.example.admin.arkamilkproject.app.CardItemsList;
import com.example.admin.arkamilkproject.app.ProductDescriptionActivity;
import com.example.admin.arkamilkproject.model.CardItemsDataModel;

import java.util.ArrayList;

public class CardItemsDataAdopter extends RecyclerView.Adapter<CardItemsDataAdopter.MyViewHolder> {

    Context context;
    ArrayList<CardItemsDataModel>cardItemsDataModel;

    public CardItemsDataAdopter(Context context, ArrayList<CardItemsDataModel> cardItemsDataModel) {
        this.context = context;
        this.cardItemsDataModel = cardItemsDataModel;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.curd_data_one,viewGroup,false);

        return new MyViewHolder(view,context,cardItemsDataModel);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        final CardItemsDataModel cardItemsDataModel1=cardItemsDataModel.get(i);
        myViewHolder.textView1.setText(cardItemsDataModel1.getName());
        myViewHolder.textView3.setText(cardItemsDataModel1.getSize());
        myViewHolder.textView2.setText(cardItemsDataModel1.getCost());
        myViewHolder.imageView.setImageResource(cardItemsDataModel1.getImage());


    }

    @Override
    public int getItemCount() {
        return cardItemsDataModel.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView textView1,textView2,textView3;
        Context context;
        LinearLayout onelineronclik;
        ArrayList<CardItemsDataModel>cardItemsDataModel=new ArrayList<>();
        public MyViewHolder(@NonNull View itemView, Context context,ArrayList<CardItemsDataModel>cardItemsDataModel) {
            super(itemView);
            this.context=context;
            this.cardItemsDataModel=cardItemsDataModel;
            itemView.setOnClickListener(this);
            imageView=(ImageView)itemView.findViewById(R.id.cproductimage);
            textView1=(TextView)itemView.findViewById(R.id.cproductname);
            textView2=(TextView)itemView.findViewById(R.id.cproductml);
            textView3=(TextView)itemView.findViewById(R.id.cproductcost);
            onelineronclik=(LinearLayout)itemView.findViewById(R.id.onelineronclik);
        }

        @Override
        public void onClick(View v) {
            int position=getAdapterPosition();
            CardItemsDataModel cardItemsDataModel=this.cardItemsDataModel.get(position);
            Intent intent=new Intent(context,ProductDescriptionActivity.class);
             intent.putExtra("image",cardItemsDataModel.getImage());
             intent.putExtra("name",cardItemsDataModel.getName());
             intent.putExtra("size",cardItemsDataModel.getSize());
             intent.putExtra("cost",cardItemsDataModel.getCost());
            this.context.startActivity(intent);
        }
    }
}
