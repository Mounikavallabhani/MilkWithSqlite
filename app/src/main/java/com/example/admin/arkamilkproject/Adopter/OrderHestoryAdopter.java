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

import com.example.admin.arkamilkproject.R;
import com.example.admin.arkamilkproject.app.CheckOut;
import com.example.admin.arkamilkproject.app.OrderHistroyViewDetails;
import com.example.admin.arkamilkproject.model.OrderHestoryModel;

import java.util.ArrayList;

public class OrderHestoryAdopter extends RecyclerView.Adapter<OrderHestoryAdopter.Myview> {

    Context context;
    ArrayList<OrderHestoryModel>orderHestoryModels;

    public OrderHestoryAdopter(Context context, ArrayList<OrderHestoryModel> orderHestoryModels) {
        this.context = context;
        this.orderHestoryModels = orderHestoryModels;
    }

    @NonNull
    @Override
    public Myview onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
           View view=LayoutInflater.from(context).inflate(R.layout.orderhistroy_items,viewGroup,false);
        return new Myview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myview myview, int i) {
        OrderHestoryModel orderHestoryModel=orderHestoryModels.get(i);
        myview.order1.setText(orderHestoryModel.getNameone());
        myview.order2.setText(orderHestoryModel.getNametwo());
        myview.order3.setText(orderHestoryModel.getNamethree());
        myview.order4.setText(orderHestoryModel.getNamefour());
        myview.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context.getApplicationContext(),OrderHistroyViewDetails.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return orderHestoryModels.size();
    }

    public class Myview extends RecyclerView.ViewHolder {
        TextView order1,order2,order3,order4;
        LinearLayout linearLayout;
        Typeface tf_regular1,tf_regular2;
        public Myview(@NonNull View itemView) {
            super(itemView);
            order1=(TextView)itemView.findViewById(R.id.order1);
            order2=(TextView)itemView.findViewById(R.id.order2);
            order3=(TextView)itemView.findViewById(R.id.order3);
            order4=(TextView)itemView.findViewById(R.id.order4);
            linearLayout=(LinearLayout)itemView.findViewById(R.id.ordersend);
            tf_regular1 = Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/six.otf");
            tf_regular2 = Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/six.otf");
            /*  Typeface type1 = Typeface.createFromAsset(getAssets(),"fonts/agaramondpro_bold.otf");*/
                this.order1.setTypeface(tf_regular1);
                this.order2.setTypeface(tf_regular2);
                this.order3.setTypeface(tf_regular2);
                this.order4.setTypeface(tf_regular1);



        }
    }
}
