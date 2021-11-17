package com.unalyeten.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.unalyeten.landmarkbook.databinding.ActivityDetailsBinding;
import com.unalyeten.landmarkbook.databinding.ActivityMainBinding;

public class DetailsActivity extends AppCompatActivity {

    private ActivityDetailsBinding activityDetailsBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDetailsBinding = activityDetailsBinding.inflate(getLayoutInflater());
        View view = activityDetailsBinding.getRoot();
        setContentView(view);

        // Intent ile veri aktarımı
        //Intent intent = getIntent();
        //Landmark selectedLandmark = (Landmark)intent.getSerializableExtra("Landmark");

        // Singleton ile veri aktarımı
        Singleton singleton = Singleton.getInstance();
        Landmark selectedLandmark = singleton.getLandmark();

        activityDetailsBinding.textViewName.setText(selectedLandmark.name);
        activityDetailsBinding.textViewCountry.setText(selectedLandmark.country);
        activityDetailsBinding.imageView.setImageResource(selectedLandmark.image);

    }
}