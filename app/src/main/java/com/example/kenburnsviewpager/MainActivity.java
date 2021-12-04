package com.example.kenburnsviewpager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import com.example.kenburnsviewpager.adapter.TravelLocationAdapter;
import com.example.kenburnsviewpager.model.TravelLocation;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 locationViewPager = findViewById(R.id.locationViewPager);
        List<TravelLocation> travelLocations = new ArrayList<>();

        TravelLocation travelChina = new TravelLocation();
        //travelChina.imageUrl = "https://images.unsplash.com/photo-1500297726361-1715d90aec00?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1047&q=80";
        travelChina.image = R.drawable.china;
        travelChina.title = "China";
        travelChina.location = "Grate Wall of China";
        travelChina.startRating = 4.8f;
        travelLocations.add(travelChina);

        TravelLocation travelMexico = new TravelLocation();
        //travelMexico.imageUrl = "https://images.unsplash.com/photo-1567930009485-07d60c813306?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80";
        travelMexico.image = R.drawable.mexico;
        travelMexico.title = "Mexico";
        travelMexico.location = "Chichén Itzá";
        travelMexico.startRating = 4.5f;
        travelLocations.add(travelMexico);

        TravelLocation travelJordan = new TravelLocation();
        //travelJordan.imageUrl = "https://images.unsplash.com/photo-1589825274556-94746a018766?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80";
        travelJordan.image = R.drawable.jordan;
        travelJordan.title = "Jordan";
        travelJordan.location = "Petra";
        travelJordan.startRating = 4.7f;
        travelLocations.add(travelJordan);

        TravelLocation travelPeru = new TravelLocation();
        //travelJordan.imageUrl = "https://images.unsplash.com/photo-1456244440184-1d494704a505?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80";
        travelPeru.image = R.drawable.peru;
        travelPeru.title = "Peru";
        travelPeru.location = "Machu Picchu";
        travelPeru.startRating = 4.6f;
        travelLocations.add(travelPeru);

        TravelLocation travelBrazil = new TravelLocation();
        //travelBrazil.imageUrl = "https://images.unsplash.com/photo-1595688878177-b72dfeeed683?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1151&q=80";
        travelBrazil.image = R.drawable.brazil;
        travelBrazil.title = "Brazil";
        travelBrazil.location = "Christ the Redeemer";
        travelBrazil.startRating = 4.6f;
        travelLocations.add(travelBrazil);

        TravelLocation travelItaly = new TravelLocation();
        //travelItaly.imageUrl = "https://images.unsplash.com/photo-1482401204742-eb3c31c24722?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1112&q=80";
        travelItaly.image = R.drawable.italy;
        travelItaly.title = "Italy";
        travelItaly.location = "Colosseum";
        travelItaly.startRating = 4.7f;
        travelLocations.add(travelItaly);

        TravelLocation travelIndia = new TravelLocation();
        //travelIndia.imageUrl = "https://images.unsplash.com/photo-1524492412937-b28074a5d7da?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1051&q=80";
        travelIndia.image = R.drawable.india;
        travelIndia.title = "India";
        travelIndia.location = "Taj Mahal";
        travelIndia.startRating = 4.8f;
        travelLocations.add(travelIndia);

        locationViewPager.setAdapter(new TravelLocationAdapter(travelLocations));
        locationViewPager.setClipToPadding(false);
        locationViewPager.setClipChildren(false);
        locationViewPager.setOffscreenPageLimit(3);

        locationViewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.90f + r * 0.04f);
            }
        });
        locationViewPager.setPageTransformer(compositePageTransformer);
    }
}