package com.example.katarzynagedlek.planets_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView planetRecycler;
    private DatabaseHelper databaseHelper;
    private LinearLayoutManager layoutManager;
    private PlanetAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        planetRecycler = (RecyclerView) findViewById(R.id.planet_recycler);
        planetRecycler.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        planetRecycler.setLayoutManager(layoutManager);

        databaseHelper = new DatabaseHelper(this);
        adapter = new PlanetAdapter(databaseHelper.planetsList(), this, planetRecycler);
        planetRecycler.setAdapter(adapter);

    }

    @Override
    protected void onRestart() {
        super.onRestart();

        adapter = new PlanetAdapter(databaseHelper.planetsList(), this, planetRecycler);
        planetRecycler.setAdapter(adapter);
        //adapter.notifyDataSetChanged();
    }

}
