package com.example.movies2;

import android.content.Context;
import android.text.Layout;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{ //source: https://developer.android.com/develop/ui/views/layout/recyclerview#java
    Context context;
    ArrayList<Movie> movies;

    public CustomAdapter(Context context, ArrayList<Movie> movies){
        this.context = context;
        this.movies = movies;


    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view, which defines the UI of the list item
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.text_row_item, parent, false);

        return new CustomAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        holder.tvTitle.setText(movies.get(position).getTitle());
        holder.tvYear.setText(String.valueOf(movies.get(position).getYear()));
        holder.tvGenre.setText(movies.get(position).getGenre());
    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return movies.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView tvTitle, tvYear, tvGenre;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            imageView = itemView.findViewById(R.id.posterId);
            tvTitle = itemView.findViewById(R.id.title);
            tvYear = itemView.findViewById(R.id.year);
            tvGenre = itemView.findViewById(R.id.genre);
        }
    }
}
