package com.example.androidtask2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{
    private static ArrayList<DataModel> dataSet;
    public CustomAdapter(ArrayList<DataModel> dataSet){
    this.dataSet = dataSet;}

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView textViewName;
        TextView textViewDescription;
        ImageView imageViewIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            imageViewIcon = itemView.findViewById(R.id.imageView);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();

                    bundle.putString("name", dataSet.get(getAdapterPosition()).getName());
                    bundle.putInt("image", dataSet.get(getAdapterPosition()).getImage());
                    bundle.putString("description",
                            dataSet.get(getAdapterPosition()).getDetails());
                    Navigation.findNavController(view).navigate(
                            R.id.action_mainPage_to_detailedCharData, bundle);
                }
            });
    }}
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext() ).inflate(R.layout.cards_view , parent
                ,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        TextView textViewName = holder.textViewName;
        TextView textViewDescription = holder.textViewDescription;
        ImageView imageView = holder.imageViewIcon;
        CardView cardView = holder.cardView;

        textViewName.setText(dataSet.get(position).getName());
        textViewDescription.setText(dataSet.get(position).getDescription());
        imageView.setImageResource(dataSet.get(position).getImage());


    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
