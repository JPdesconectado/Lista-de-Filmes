package com.example.listadefilme.Director;

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

public class DirectorFragment extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private List<Director> listDirector = new ArrayList<>();
    private DirectorAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.fragment_director, container, false);

        recyclerView = view.findViewById(R.id.directorRecyclerView);
        adapter = new  DirectorAdapter(getContext(), listDirector);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        Button button = view.findViewById(R.id.inserirButton);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), newDirectorActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        setRetainInstance(true);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        if(listDirector.size() == 0){
        listDirector.add(new Director(R.drawable.chris_columbus, "Chris Columbus", "10/09/1958"));
        listDirector.add(new Director(R.drawable.peter_jackson, "Peter Jackson", "31/10/1961"));
        listDirector.add(new Director(R.drawable.david_fincher, "David Fincher", "28/08/1962"));
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == getActivity().RESULT_OK && requestCode == 1) {
        Bundle bundle = data.getExtras();
        Director director = (Director) bundle.getSerializable("director");
        adapter.inserir(director);
        }
    }


}
