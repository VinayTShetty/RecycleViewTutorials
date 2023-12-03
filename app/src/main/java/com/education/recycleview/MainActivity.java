package com.education.recycleview;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.education.api.ApiService;
import com.education.model.ProductDetails;
import com.education.recycleview.adapter.MyAdapter;
import com.education.retrofitClient.RetrofitClient;

import java.util.ArrayList;
import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter myAdapter;
    List<ProductDetails> productDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        restApi();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                intializeViews();
                initiallizeRecycleViews();
            }
        },2000);

       // restApi();
    }

    private void restApi() {
        ApiService apiService = RetrofitClient.getClient().create(ApiService.class);
        Call<List<ProductDetails>> call=  apiService.getProducts();
        call.enqueue(new Callback<List<ProductDetails>>() {
          @Override
          public void onResponse(Call<List<ProductDetails>> call, Response<List<ProductDetails>> response) {
              Log.d(TAG, "onResponse: "+response.body().toString());
              productDetails= response.body();
          }

          @Override
          public void onFailure(Call<List<ProductDetails>> call, Throwable t) {
              Log.d(TAG, "onFailure: "+t.getLocalizedMessage());
          }
      });
    }



    private void intializeViews() {
        recyclerView=(RecyclerView) findViewById(R.id.myRecycleView_rv);
    }

    private void initiallizeRecycleViews() {
        /**
         *   1)Initialize adapter.
         *   2)Set layuout manager for RecycleView.
         *   3)Set adapter for RecycleView.
         */
        myAdapter=new MyAdapter(productDetails);
        System.out.println("DATA "+productDetails.get(0).geturl());
        /**
         * This below logic can be removed by adding the layout manager directly in the XML file for the RecycleView i.e
         * app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"
         * If we are adding the above Tag,No need of defining it in the java files like below
         */
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(myAdapter);
    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
//    private void generateDataList(List<ProductDetails> photoList) {
//
//
//        adapter = new CustomAdapter(this,photoList);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(adapter);
//    }

}