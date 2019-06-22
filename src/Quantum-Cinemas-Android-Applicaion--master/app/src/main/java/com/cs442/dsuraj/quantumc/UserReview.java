package com.cs442.dsuraj.quantumc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by sushma on 11/24/2016.
 */

public class UserReview extends AppCompatActivity {
    ArrayList<MovieReview> moviereview;
    ListView movielist;
    CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.review);

        //create Array list of menu items
        moviereview = new ArrayList();

        moviereview.add(new MovieReview("Avenger", "@drawable/avengerreview",5,"Rất tốt"));

        moviereview.add(new MovieReview("Flypaper", "@drawable/flypaperreview",3,"Tốt"));

        moviereview.add(new MovieReview("Mission Impossible", "@drawable/missionimpossible",2,"Không tốt"));

        moviereview.add(new MovieReview("Spiderman", "@drawable/spidermanreview",1,"Dở nhất từng xem"));
        adapter=new CustomAdapter(this, moviereview);

        movielist=(ListView)findViewById(R.id.myListView);
        movielist.setAdapter(adapter);

    }


}
