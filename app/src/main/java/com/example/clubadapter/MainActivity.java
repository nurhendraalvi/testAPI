package com.example.clubadapter;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    ArrayList<TeamsItem> list = new ArrayList<>();
    private ClubAdapter clubAdapter;
    private RecyclerView rvClub;
    private FootballViewModel viewModel;
    private String l = "English Premier League";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clubAdapter = new ClubAdapter(getApplicationContext());
        clubAdapter.notifyDataSetChanged();

        rvClub = findViewById(R.id.fragmentclub_rv);
        rvClub.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        viewModel = new ViewModelProvider(this).get(FootballViewModel.class);
        viewModel.setListClub(l);
        viewModel.getListClub().observe(this, getlistClub);

        rvClub.setAdapter(clubAdapter);

    }

    private Observer<ArrayList<TeamsItem>> getlistClub = new Observer<ArrayList<TeamsItem>>() {
        @Override
        public void onChanged(ArrayList<TeamsItem> clubItems) {
            if ((clubItems != null)) {
                Log.d("MainActivity", "getListClub Observer : "+clubItems);
                clubAdapter.setClub(clubItems);
            }
        }
    };
}
