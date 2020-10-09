package com.example.moovico.Data;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moovico.Model.Movie;
import com.example.moovico.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by paulodichone on 4/12/17.
 */

public class MovieRecyclerViewAdapter extends RecyclerView.Adapter<MovieRecyclerViewAdapter.ViewHolder> {

  private Context context;
  private List<Movie>movieList;
    public MovieRecyclerViewAdapter(Context context, List<Movie> movies) {

        this.context=context;
        movieList=movies;

    }

    @NonNull
    @Override
    public MovieRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View layoutview= LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_row,null,false);
        RecyclerView.LayoutParams ip=new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutview.setLayoutParams(ip);
        MovieRecyclerViewAdapter.ViewHolder rcv=new MovieRecyclerViewAdapter.ViewHolder(layoutview,context);

        return rcv;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieRecyclerViewAdapter.ViewHolder holder, int position) {

        Movie movie=movieList.get(position);
        String posterLink =  movie.getPoster();

        holder.title.setText(movie.getTitle());
        holder.type.setText(movie.getMovieType());

        Picasso.with(context)
                .load(posterLink)
                .placeholder(android.R.drawable.ic_btn_speak_now)
                .into(holder.poster);

        holder.year.setText(movie.getYear());

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title;
        ImageView poster;
        TextView year;
        TextView type;

        public ViewHolder(@NonNull View itemView,Context ctx) {
            super(itemView);
            context=ctx;

            title = (TextView) itemView.findViewById(R.id.movietitle);
            poster = (ImageView) itemView.findViewById(R.id.movieimageid);
            year = (TextView) itemView.findViewById(R.id.moviereleasedate);
            type = (TextView) itemView.findViewById(R.id.moviecat);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

        }

        @Override
        public void onClick(View v) {



        }
    }
}