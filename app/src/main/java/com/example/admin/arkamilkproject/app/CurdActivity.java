package com.example.admin.arkamilkproject.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.admin.arkamilkproject.Adopter.CardAdopterOne;
import com.example.admin.arkamilkproject.Adopter.CardAdopterTwo;
import com.example.admin.arkamilkproject.Adopter.CustomAdapter;
import com.example.admin.arkamilkproject.Adopter.CustomAdapterMilk;
import com.example.admin.arkamilkproject.R;
import com.example.admin.arkamilkproject.model.CardModelOne;
import com.example.admin.arkamilkproject.model.CardModelTwo;
import com.example.admin.arkamilkproject.model.Model;
import com.example.admin.arkamilkproject.model.ModelMilk;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CurdActivity extends AppCompatActivity {

    RecyclerView cardrecyclerview1,cardrecyclerview2;
    LinearLayoutManager cardliner1,cardliner2;
    GridLayoutManager gridLayoutManager,gridLayoutManager1;
    ArrayList<CardModelOne>cardModelOne;
    ArrayList<CardModelTwo>cardModelTwo;

    CardAdopterOne cardAdopterOne;
    CardAdopterTwo cardAdopterTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curd);

        cardone();
        cardtwo();
    }

    public void cardone(){
        cardrecyclerview1=(RecyclerView)findViewById(R.id.cardrecyclerview1);
//         cardModelOne=new ArrayList<>();
//         cardModelOne.add(new CardModelOne("Heritage Curd"));
//         cardModelOne.add(new CardModelOne("Jersey Curd"));
//         cardModelOne.add(new CardModelOne("Vijaya Curd"));
//         cardModelOne.add(new CardModelOne("Thirumala Curd"));
//         cardModelOne.add(new CardModelOne("Amul Curd"));
        gridLayoutManager=new GridLayoutManager(this,3);
         cardrecyclerview1.setLayoutManager(gridLayoutManager);
         cardrecyclerview1.setHasFixedSize(true);
//         cardAdopterOne=new CardAdopterOne(this,cardModelOne);
//         cardrecyclerview1.setAdapter(cardAdopterOne);
         cardrecyclerview1.setHasFixedSize(true);
        jsondata();

    }
    public void cardtwo(){

        cardrecyclerview2=(RecyclerView)findViewById(R.id.cardrecyclerview2);
        cardModelTwo=new ArrayList<>();
        cardModelTwo.add(new CardModelTwo(R.drawable.milk,"Heritage","500ml","25.00"));
        cardModelTwo.add(new CardModelTwo(R.drawable.milk,"Amul","500ml","25.00"));
        cardModelTwo.add(new CardModelTwo(R.drawable.milk,"Thirumala","500ml","25.00"));
        cardModelTwo.add(new CardModelTwo(R.drawable.milk,"Vijaya","500ml","25.00"));
        cardModelTwo.add(new CardModelTwo(R.drawable.milk,"Jersey","500ml","25.00"));
        cardModelTwo.add(new CardModelTwo(R.drawable.milk,"Heritage","500ml","25.00"));
        cardModelTwo.add(new CardModelTwo(R.drawable.milk,"Amul","500ml","25.00"));
        cardModelTwo.add(new CardModelTwo(R.drawable.milk,"Thirumala","500ml","25.00"));
        cardModelTwo.add(new CardModelTwo(R.drawable.milk,"Vijaya","500ml","25.00"));
        cardModelTwo.add(new CardModelTwo(R.drawable.milk,"Jersey","500ml","25.00"));
        gridLayoutManager1=new GridLayoutManager(this,1);
        cardrecyclerview2.setLayoutManager(gridLayoutManager1);
        cardrecyclerview2.setHasFixedSize(true);
        cardAdopterTwo=new CardAdopterTwo(this,cardModelTwo);
        cardrecyclerview2.setAdapter(cardAdopterTwo);
    }
    public void jsondata() {

        RequestQueue rq = Volley.newRequestQueue(CurdActivity.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                "https://milk365.in/api/get_subcategories_categorieid?catid=8",
                new Response.Listener<String>() {

                    public void onResponse(String response) {

                        try {
                            //     Toast.makeText(getActivity()," "+response,Toast.LENGTH_LONG).show();
                            JSONArray jsonObject1=new JSONArray(response);
                            //System.out.println("ohhk"+jsonObject1);
                            cardModelOne=new ArrayList<>();

                            String name,image;
                            for (int i=0;i<jsonObject1.length();i++) {
                                JSONObject jsonObject=jsonObject1.optJSONObject(i);
                                name=jsonObject.getString("sub_category");

                                cardModelOne.add(new CardModelOne(name));
                                cardrecyclerview1.setAdapter(new CardAdopterOne(getApplication(),cardModelOne));

                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    };
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError arg0) {
                // TODO Auto-generated method stub
                //   pd.hide();
            }
        })

        {
            @Override
            public Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("catid","8");



                return params;
            }
        };
        rq.add(stringRequest);
    }
}
