package com.unalyeten.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.unalyeten.landmarkbook.databinding.ActivityMainBinding;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    ArrayList<Landmark> landmarkArrayList;
    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = mainBinding.inflate(getLayoutInflater());
        View view = mainBinding.getRoot();
        setContentView(view);

        Landmark landmark1 = new Landmark("Eiffel Tower", "France", R.drawable.eiffeltower);
        Landmark landmark2 = new Landmark("Colosseum", "Italy", R.drawable.colosseum);
        Landmark landmark3 = new Landmark("London Bridge", "United Kingdom", R.drawable.londonbridge);
        Landmark landmark4 = new Landmark("Pisa Tower", "Italy", R.drawable.pisatower);

        landmarkArrayList = new ArrayList<>();
        landmarkArrayList.add(landmark1);
        landmarkArrayList.add(landmark2);
        landmarkArrayList.add(landmark3);
        landmarkArrayList.add(landmark4);

        // Adapter
        /*
        ArrayAdapter<Landmark> landmarkArrayAdapter = new ArrayAdapter(
                 this,
                        android.R.layout.simple_list_item_1,
                        landmarkArrayList.stream().map(landmark -> landmark.name).collect(Collectors.toList()));
        mainBinding.listView.setAdapter(landmarkArrayAdapter);

        mainBinding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("Landmark", landmarkArrayList.get(position));
                startActivity(intent);
            }
        });*/

        // RecyclerView Adapter
        mainBinding.recyclerViewList.setLayoutManager(new LinearLayoutManager(this));
        LandmarkAdapter landmarkAdapter = new LandmarkAdapter(landmarkArrayList);
        mainBinding.recyclerViewList.setAdapter(landmarkAdapter);


    }
}