package com.example.listadefilme.Actor;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listadefilme.R;

import java.util.ArrayList;
import java.util.List;

public class ActorFragment extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private List<Actor> listActor = new ArrayList<>();
    private ActorAdapter adapter;
    public static List<String> names = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.fragment_actor, container, false);
        recyclerView = view.findViewById(R.id.actorRecyclerView);
        adapter = new ActorAdapter(getContext(), listActor);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        Button button = view.findViewById(R.id.inserirButton);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), newActorActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        for(int i = 0; i < listActor.size(); i++){
            addLista(listActor.get(i).getName());
        }

        setRetainInstance(true);

        return view;

    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        if(listActor.size() == 0){
        listActor.add(new Actor(R.drawable.daniel_radcliffe, "Daniel Radcliffe", "23/07/1989"));
        listActor.add(new Actor(R.drawable.elijah_wood, "Elijah Wood", "28/01/1981"));
        listActor.add(new Actor(R.drawable.brad_pitt, "Brad Pitt", "18/12/1963"));
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == getActivity().RESULT_OK && requestCode == 1) {
            Bundle bundle = data.getExtras();
            Actor actor = (Actor) bundle.getSerializable("actor");
            addLista(actor.getName());
            adapter.inserir(actor);

        }
    }

    public void addLista(String string){
        names.add(string);

    }

}