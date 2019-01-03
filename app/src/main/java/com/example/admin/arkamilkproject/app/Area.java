package com.example.admin.arkamilkproject.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.admin.arkamilkproject.R;


public class Area extends AppCompatActivity {
    Button area;
    LinearLayout arealayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);
        area=(Button)findViewById(R.id.area);
        arealayout=findViewById(R.id.arealayout);
        int resId = R.anim.layoutslidebottom;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(Area.this, resId);
        arealayout.setLayoutAnimation(animation);
        area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Area.this, Login.class);
                startActivity(intent);
            }
        });

    }
}
