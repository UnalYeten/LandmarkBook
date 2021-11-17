package com.unalyeten.landmarkbook;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.unalyeten.landmarkbook.databinding.ActivityRecyclerRowBinding;

import java.util.ArrayList;

public class LandmarkAdapter extends RecyclerView.Adapter<LandmarkAdapter.LandmarkViewHolder> {

    private ArrayList<Landmark> landmarkArrayList;

    public LandmarkAdapter(ArrayList<Landmark> landmarkArrayList) {
        this.landmarkArrayList = landmarkArrayList;
    }

    @NonNull
    @Override
    public LandmarkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ActivityRecyclerRowBinding binding = ActivityRecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),
                                                                                parent,
                                                                    false);
        return new LandmarkViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(LandmarkViewHolder holder, int position) {
        holder.binding.textView.setText(landmarkArrayList.get(position).name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailsActivity.class);
                //intent.putExtra("Landmark", landmarkArrayList.get(position));

                Singleton singleton = Singleton.getInstance();
                singleton.setLandmark(landmarkArrayList.get(position));

                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return landmarkArrayList.size();
    }

    public  class LandmarkViewHolder extends RecyclerView.ViewHolder {

        private ActivityRecyclerRowBinding binding;

        public LandmarkViewHolder(ActivityRecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
