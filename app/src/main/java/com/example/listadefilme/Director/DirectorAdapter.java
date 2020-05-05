package com.example.listadefilme.Director;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.listadefilme.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DirectorAdapter extends RecyclerView.Adapter<DirectorAdapter.DirectorViewHolder> {

    private Context mContext;
    private List<Director> listDirector;

    public DirectorAdapter(Context mContext, List<Director> listDirector) {
        this.mContext = mContext;
        this.listDirector = listDirector;
    }


    @NonNull
    @Override
    public DirectorAdapter.DirectorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from((mContext)).inflate(R.layout.card_item_ad, parent, false);
        DirectorViewHolder dHolder = new DirectorViewHolder(view);
        return dHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DirectorAdapter.DirectorViewHolder holder, int position) {
        holder.photoImage.setImageResource(listDirector.get(position).getPhoto());
        holder.nameText.setText(listDirector.get(position).getName());
        holder.birthText.setText(listDirector.get(position).getBirth());
    }

    @Override
    public int getItemCount() {
       return listDirector.size();
    }

    public void inserir(Director director){
        listDirector.add(director);
        notifyItemInserted(getItemCount());
    }

    public static class DirectorViewHolder extends RecyclerView.ViewHolder{
            private ImageView photoImage;
            private TextView nameText;
            private TextView birthText;

        public DirectorViewHolder(@NonNull View itemView) {
            super(itemView);
            photoImage = itemView.findViewById(R.id.photoImage);
            nameText = itemView.findViewById(R.id.nameText);
            birthText = itemView.findViewById(R.id.birthText);


        }
    }
}
