package com.example.admin.arkamilkproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Area extends AppCompatActivity {
    Button area;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);
        area=(Button)findViewById(R.id.area);
        area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Area.this, Login.class);
                startActivity(intent);
            }
        });
        Toast.makeText(this, "haii", Toast.LENGTH_SHORT).show();

    }
}
