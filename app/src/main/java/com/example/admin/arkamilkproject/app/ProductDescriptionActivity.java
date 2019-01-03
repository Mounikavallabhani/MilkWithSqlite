package com.example.admin.arkamilkproject.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.admin.arkamilkproject.R;

import java.io.ByteArrayOutputStream;

public class ProductDescriptionActivity  extends AppCompatActivity {
    Button subscribe,deliveryonce;
    Button increse, decrese;
    TextView add;
    int count = 1;
    ImageView backbutton,productimage;
    LinearLayout descriptionlinerelayout;
    TextView t1,t2,t3,t4;
    Typeface tf_regular1,tf_regular2;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productdescription);
        productimage=(ImageView)findViewById(R.id.productimage);
        t1=(TextView)findViewById(R.id.pdt1);
        t2=(TextView)findViewById(R.id.pdt2);
        t3=(TextView)findViewById(R.id.pdt3);
        t4=(TextView)findViewById(R.id.t4);


       productimage.setImageResource(getIntent().getIntExtra("image",0));
        t1.setText(""+getIntent().getStringExtra("name"));
        t2.setText(""+getIntent().getStringExtra("size"));
        t3.setText("\u20B9"+getIntent().getStringExtra("cost"));


        tf_regular1 = Typeface.createFromAsset(getAssets(), "fonts/six.otf");
        tf_regular2 = Typeface.createFromAsset(getAssets(), "fonts/six.otf");

        subscribe=(Button)findViewById(R.id.subscribe);
        deliveryonce=(Button)findViewById(R.id.deliveryonce);

        subscribe.setTypeface(tf_regular2);
        deliveryonce.setTypeface(tf_regular2);

        increse = findViewById(R.id.increase);
        decrese = findViewById(R.id.decrease);
        descriptionlinerelayout=findViewById(R.id.descriptionlinerelayout);

        int resId = R.anim.lauoutforside;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(ProductDescriptionActivity.this, resId);
        descriptionlinerelayout.setLayoutAnimation(animation);
        add = findViewById(R.id.add);
        backbutton=findViewById(R.id.backbutton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ProductDescriptionActivity.this,DashBoard.class);
                startActivity(intent);
            }
        });
        subscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ProductDescriptionActivity.this,Subscription.class);


                String st1=t1.getText().toString();
                String st2=t2.getText().toString();
                String st3=t3.getText().toString();
                String sadd=add.getText().toString();

                productimage.buildDrawingCache();
                Bitmap bitmap = productimage.getDrawingCache();
                ByteArrayOutputStream stream=new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, stream);
                byte[] image=stream.toByteArray();

                String img_str = Base64.encodeToString(image, 0);
                //decode string to image
                String base=img_str;
                byte[] imageAsBytes = Base64.decode(base.getBytes(), Base64.DEFAULT);

                editor = getSharedPreferences("productdetails", MODE_PRIVATE).edit();

                editor.putString("productname", st1);
                editor.putString("productml",st2);
                editor.putString("productcost",st3);
                editor.putString("increment",sadd);
                editor.putString("userphoto",img_str);
                editor.commit();
                startActivity(intent);
            }
        });
        deliveryonce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ProductDescriptionActivity.this,DeliveryOnce.class);
                editor = getSharedPreferences("productdetails", MODE_PRIVATE).edit();

                productimage.buildDrawingCache();
                Bitmap bitmap = productimage.getDrawingCache();
                ByteArrayOutputStream stream=new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, stream);
                byte[] image=stream.toByteArray();

                String img_str = Base64.encodeToString(image, 0);
                //decode string to image
                String base=img_str;
                byte[] imageAsBytes = Base64.decode(base.getBytes(), Base64.DEFAULT);
                String st1=t1.getText().toString();
                String st2=t2.getText().toString();
                String st3=t3.getText().toString();
                editor.putString("productname", st1);
                editor.putString("productml",st2);
                editor.putString("productcost",st3);
                editor.putString("userphoto",img_str);
                editor.commit();
                editor.apply();
                startActivity(intent);
            }
        });
        increse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count++;
                add.setText(String.valueOf(count));

            }
        });
        decrese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count > 1) {
                    count--;
                    add.setText(String.valueOf(count));
                }

            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        t1.setText("");
        t2.setText("");
        t3.setText("");

    }
}
