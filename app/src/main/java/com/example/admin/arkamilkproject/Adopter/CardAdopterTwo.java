package com.example.admin.arkamilkproject.Adopter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.arkamilkproject.R;
import com.example.admin.arkamilkproject.app.ProductDescriptionActivity;
import com.example.admin.arkamilkproject.model.CardModelTwo;

import java.util.ArrayList;

public class CardAdopterTwo extends RecyclerView.Adapter<CardAdopterTwo.MyData> {

    Context context;
    ArrayList<CardModelTwo>cardModelTwo;

    public CardAdopterTwo(Context context, ArrayList<CardModelTwo> cardModelTwo) {
        this.context = context;
        this.cardModelTwo = cardModelTwo;
    }

    @NonNull
    @Override
    public MyData onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.carditems_list_data,viewGroup,false);

        return new MyData(view,context,cardModelTwo);
    }

    @Override
    public void onBindViewHolder(@NonNull MyData myData, int i) {

        CardModelTwo cardModelTwo1=cardModelTwo.get(i);
        myData.imageView.setImageResource(cardModelTwo1.getImage());
        myData.textView1.setText(cardModelTwo1.getName());
        myData.textView2.setText(cardModelTwo1.getSize());
        myData.textView3.setText(cardModelTwo1.getPrice());

    }

    @Override
    public int getItemCount() {
        return cardModelTwo.size();
    }

    public class MyData extends RecyclerView.ViewHolder implements View.OnClickListener {
        LinearLayout cardrecyclerviewonclick;
        ImageView imageView;
        TextView textView1,textView2,textView3;
        Context context;
        ArrayList<CardModelTwo>cardModelTwos=new ArrayList<>();
        public MyData(@NonNull View itemView ,Context context,ArrayList<CardModelTwo>cardModelTwos) {
            super(itemView);
            this.context=context;
            this.cardModelTwos=cardModelTwos;
            itemView.setOnClickListener(this);
            textView1=(TextView)itemView.findViewById(R.id.cardproductname);
            textView2=(TextView)itemView.findViewById(R.id.cardproductml);
            textView3=(TextView)itemView.findViewById(R.id.cardproductcost);
            imageView=(ImageView)itemView.findViewById(R.id.cardproductimage);
            cardrecyclerviewonclick=(LinearLayout)itemView.findViewById(R.id.cardrecyclerviewonclick);


        }

        @Override
        public void onClick(View v) {

            int position=getAdapterPosition();
            CardModelTwo cardModelTwo=this.cardModelTwos.get(position);
            Intent intent=new Intent(context.getApplicationContext(),ProductDescriptionActivity.class);
              intent.putExtra("image",cardModelTwo.getImage());
              intent.putExtra("name",cardModelTwo.getName());
              intent.putExtra("size",cardModelTwo.getSize());
              intent.putExtra("cost",cardModelTwo.getPrice());
            context.startActivity(intent);
        }
    }
}
