package com.example.admin.arkamilkproject.fragmentsdata;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.admin.arkamilkproject.R;
import com.example.admin.arkamilkproject.app.CustomerActivity;
import com.example.admin.arkamilkproject.app.OrderHestory;
import com.example.admin.arkamilkproject.app.OrderHistroyViewDetails;
import com.example.admin.arkamilkproject.app.Settings;

public class Me  extends Fragment {
    LinearLayout invitefriends,settings,support,orderhistory;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_me,container,false);
        invitefriends=view.findViewById(R.id.ml3);
        settings=view.findViewById(R.id.ml2);
        support=view.findViewById(R.id.ml4);
        orderhistory=view.findViewById(R.id.orderhistory);
        orderhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),OrderHestory.class);
                startActivity(intent);
            }
        });
        invitefriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Your App is here";
                String shareSub = "Your subject here";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share using"));

            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),Settings.class);
                startActivity(intent);
            }
        });
        support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),CustomerActivity.class);
                startActivity(intent);

            }
        });
        return view;
    }
}