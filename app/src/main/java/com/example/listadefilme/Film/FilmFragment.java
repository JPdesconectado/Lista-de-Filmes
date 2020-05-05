package com.example.listadefilme.Film;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.listadefilme.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FilmFragment extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private List<Film> listFilm = new ArrayList<>();
    private FilmAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.fragment_film, container, false);
        recyclerView = view.findViewById(R.id.filmRecyclerView);
        adapter = new FilmAdapter(getContext(), listFilm);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        Button button = view.findViewById(R.id.inserirButton);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), newFilmActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        setRetainInstance(true);
        return view;

    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);


        if(listFilm.size() == 0){
        listFilm.add(new Film(R.drawable.harry_potter1, "Harry Potter and the Sorcerer's Stone", "2001",
                "Adventure", "Chris Columbus", "Daniel Radcliffe"));
        listFilm.add(new Film(R.drawable.lord_rings, "The Lord of the Rings: The Fellowship of the Ring", "2001",
                "Adventure", "Peter Jackson", "Elijah Wood"));
        listFilm.add(new Film(R.drawable.fight_club, "Fight Club", "1999",
                "Drama", "David Fincher", "Brad Pitt"));

         }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == getActivity().RESULT_OK && requestCode == 1) {
            Bundle bundle = data.getExtras();
            Film film = (Film) bundle.getSerializable("film");
            adapter.inserir(film);

        }

    }


}
