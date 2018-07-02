package com.example.katarzynagedlek.planets_01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class PlanetActivity extends AppCompatActivity {

    public static final String EXTRA_PLANETNO = "planetNo";

    private DatabaseHelper databaseHelper;
    private TextView name;
    private TextView description;
    private ImageView photo;
    private CheckBox read;
    private int planetNo;
    private Planet planet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet);

        planetNo = getIntent().getExtras().getInt(EXTRA_PLANETNO);
        databaseHelper = new DatabaseHelper(this);

        planet = databaseHelper.getPlanet(planetNo);

        name = (TextView) findViewById(R.id.name);
        description = (TextView) findViewById(R.id.description);
        photo = (ImageView) findViewById(R.id.photo);
        read = (CheckBox) findViewById(R.id.read);

        name.setText(planet.getName());
        description.setText(planet.getDescription());
        photo.setImageResource(planet.getImageResourceId());
        photo.setContentDescription(planet.getName());
        read.setChecked(planet.isRead());

    }

    public void onReadClicked(View view) {

        int planetNo = getIntent().getExtras().getInt(EXTRA_PLANETNO);

        planet.setRead(read.isChecked());
        databaseHelper.updatePlanetRecord(planetNo, this, planet);

    }

}
