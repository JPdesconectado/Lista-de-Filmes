package com.example.listadefilme.Film;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.listadefilme.R;
import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.FilmViewHolder> {

    private Context mContext;
    private List<Film> listFilm;


    public FilmAdapter(Context mContext, List<Film> listFilm) {
        this.mContext = mContext;
        this.listFilm = listFilm;
    }

    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from((mContext)).inflate(R.layout.card_item, parent, false);
        FilmViewHolder fHolder = new FilmViewHolder(view);
        return fHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder holder, int position) {
        holder.posterImage.setImageResource(listFilm.get(position).getPoster());
        holder.titleText.setText(listFilm.get(position).getTitle());
        holder.releasedText.setText(String.valueOf(listFilm.get(position).getReleased()));
        holder.genreText.setText(listFilm.get(position).getGenre());
        holder.directorText.setText(listFilm.get(position).getDirector());
        holder.actorText.setText(listFilm.get(position).getProtagonist());
    }

    @Override
    public int getItemCount() {
        return listFilm.size();
    }

    public void inserir(Film film){
        listFilm.add(film);
        notifyItemInserted(getItemCount());
    }

    public static class FilmViewHolder extends RecyclerView.ViewHolder{
        private ImageView posterImage;
        private TextView titleText;
        private TextView releasedText;
        private TextView genreText;
        private TextView directorText;
        private TextView actorText;

        public FilmViewHolder(@NonNull View itemView) {
            super(itemView);
            posterImage = itemView.findViewById(R.id.posterImage);
            titleText = itemView.findViewById(R.id.titleText);
            releasedText = itemView.findViewById(R.id.releasedText);
            genreText = itemView.findViewById(R.id.genreText);
            directorText = itemView.findViewById(R.id.directorText);
            actorText = itemView.findViewById(R.id.actorText);
        }

    }
}
