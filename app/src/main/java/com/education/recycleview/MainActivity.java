package com.education.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.education.recycleview.adapter.MyAdapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter myAdapter;
    UserDetails[] UserDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadData();
        intializeViews();
        initiallizeRecycleViews();
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
        myAdapter=new MyAdapter(UserDetails);
        /**
         * This below logic can be removed by adding the layout manager directly in the XML file for the RecycleView i.e
         * app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"
         * If we are adding the above Tag,No need of defining it in the java files like below
         */
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);
    }

        private void loadData(){
            UserDetails = new UserDetails[] {
                    new UserDetails("Email", getDrawable(R.drawable.baseline_person_3_24)),
                    new UserDetails("Info", getDrawable(R.drawable.baseline_person_3_24)),
                    new UserDetails("Delete", getDrawable(R.drawable.baseline_person_3_24)),
                    new UserDetails("Dialer", getDrawable(R.drawable.baseline_person_3_24)),
                    new UserDetails("Alert", getDrawable(R.drawable.baseline_person_3_24)),
                    new UserDetails("Map", getDrawable(R.drawable.baseline_person_3_24)),
                    new UserDetails("Email", getDrawable(R.drawable.baseline_person_3_24)),
                    new UserDetails("Info", getDrawable(R.drawable.baseline_person_3_24)),
                    new UserDetails("Delete", getDrawable(R.drawable.baseline_person_3_24)),
                    new UserDetails("Dialer", getDrawable(R.drawable.baseline_person_3_24)),
                    new UserDetails("Alert", getDrawable(R.drawable.baseline_person_3_24)),
                    new UserDetails("Map", getDrawable(R.drawable.baseline_person_3_24)),
            };
        }

}