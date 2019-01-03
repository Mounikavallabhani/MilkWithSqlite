package com.example.admin.arkamilkproject.fragmentsdata;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

import com.example.admin.arkamilkproject.Adopter.WalletAdopter;
import com.example.admin.arkamilkproject.R;
import com.example.admin.arkamilkproject.model.WalletModel;

import java.util.ArrayList;

public class Wallet extends Fragment {
    private static final String TAG = "CalendarFragment";
    private CalendarView calendarView;


    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    ArrayList<WalletModel>walletModels;
    WalletAdopter walletAdopter;
    TextView wt1,wt2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wallet, container, false);

        wt1=(TextView)view.findViewById(R.id.wt1);
        wt2=(TextView)view.findViewById(R.id.wt2);
        wt1.setText("Avialable Balance");
        wt2.setText("\u20B9"+"500.00");
        recyclerView=(RecyclerView)view.findViewById(R.id.walletrecyclerview);
        linearLayoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        walletModels=new ArrayList<>();
        walletModels.add(new WalletModel("300.00","debited"));
        walletModels.add(new WalletModel("900.00","credited"));
        walletModels.add(new WalletModel("500.00","debited"));
        walletModels.add(new WalletModel("200.00","credited"));
        walletModels.add(new WalletModel("700.00","debited"));
        walletModels.add(new WalletModel("900.00","credited"));

        walletAdopter=new WalletAdopter(getActivity(),walletModels);
        recyclerView.setAdapter(walletAdopter);
        return view;
    }
}

