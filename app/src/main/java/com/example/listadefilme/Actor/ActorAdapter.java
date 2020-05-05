package com.example.listadefilme.Actor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listadefilme.R;

import java.util.ArrayList;
import java.util.List;

public class ActorAdapter extends RecyclerView.Adapter<ActorAdapter.ActorViewHolder> {

    private Context mContext;
    private List<Actor> listActor;

    public ActorAdapter(Context mContext, List<Actor> listActor) {
        this.mContext = mContext;
        this.listActor = listActor;
    }

    @NonNull
    @Override
    public ActorAdapter.ActorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from((mContext)).inflate(R.layout.card_item_ad, parent, false);
        ActorViewHolder aHolder = new ActorViewHolder(view);
        return aHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ActorAdapter.ActorViewHolder holder, int position) {
        holder.photoImage.setImageResource(listActor.get(position).getPhoto());
        holder.nameText.setText(listActor.get(position).getName());
        holder.birthText.setText(listActor.get(position).getBirth());
    }

    @Override
    public int getItemCount() {
        return listActor.size();
    }

    public void inserir(Actor actor){
        listActor.add(actor);
        notifyItemInserted(getItemCount());
    }


    public static class ActorViewHolder extends RecyclerView.ViewHolder{
        private ImageView photoImage;
        private TextView nameText;
        private TextView birthText;

        public ActorViewHolder(@NonNull View itemView) {
            super(itemView);
            photoImage = itemView.findViewById(R.id.photoImage);
            nameText = itemView.findViewById(R.id.nameText);
            birthText = itemView.findViewById(R.id.birthText);


        }
    }



}
