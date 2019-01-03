package com.example.admin.arkamilkproject.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.admin.arkamilkproject.R;



public class CustomerActivity extends AppCompatActivity {
    TextView call ,mail;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);
        call=findViewById(R.id.call);
        mail=findViewById(R.id.mail);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:9703596929"));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setPackage("com.whatsapp");
                Intent chooser  = Intent.createChooser(intent, "Complete Action using..");
                startActivity(chooser);

                }
        });
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent i = new Intent(Intent.ACTION_SENDTO);
                    i.setType("message/rfc822");
                    i.setData(Uri.parse("mailto:narasimha@gmail.com"));
                    i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
                    i.putExtra(Intent.EXTRA_TEXT   , "body of email");
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Log.d("exception", "There are no email clients installed.");
                }
                }
        });
    }
}
