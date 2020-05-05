package com.example.listadefilme.Film;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

import com.example.listadefilme.Actor.ActorFragment;
import com.example.listadefilme.Director.Director;
import com.example.listadefilme.Director.DirectorAdapter;
import com.example.listadefilme.Director.DirectorFragment;
import com.example.listadefilme.R;
import java.util.ArrayList;
import java.util.List;

public class newFilmActivity extends AppCompatActivity{

    ImageView posterImageView;
    EditText titleEditText;
    EditText releasedEditText;
    EditText genreEditText;
    Spinner directorNameSpinner;
    Spinner actorNameSpinner;
    Film film;
    List<String> directorName = new ArrayList<>();
    List<String> actorName = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.film_add);
        posterImageView = findViewById(R.id.posterImageView);
        titleEditText = findViewById(R.id.titleEditText);
        releasedEditText = findViewById(R.id.releasedEditText);
        genreEditText = findViewById(R.id.genreEditText);
        directorNameSpinner = findViewById(R.id.directorNameSpinner);
        actorNameSpinner = findViewById(R.id.actorNameSpinner);

        directorName.add("Chris Columbus");
        directorName.add("Peter Jackson");
        directorName.add("David Fincher");

        actorName.add("Daniel Radcliffe");
        actorName.add("Elijah Wood");
        actorName.add("Brad Pitt");


        for (int i = 0; i < DirectorFragment.names.size(); i++){
            if(DirectorFragment.names.get(i).equals("Chris Columbus") || DirectorFragment.names.get(i).equals("Peter Jackson") || DirectorFragment.names.get(i).equals("David Fincher")){

            }else{
                directorName.add(DirectorFragment.names.get(i));
            }

        }

        for (int i = 0; i < ActorFragment.names.size(); i++){
            if(ActorFragment.names.get(i).equals("Daniel Radcliffe") || ActorFragment.names.get(i).equals("Elijah Wood") || ActorFragment.names.get(i).equals("Brad Pitt")){

            }else{
                actorName.add(ActorFragment.names.get(i));
            }
        }


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, directorName);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        directorNameSpinner.setAdapter(dataAdapter);

        ArrayAdapter<String> dataAdapterActor = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, actorName);
        dataAdapterActor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        actorNameSpinner.setAdapter(dataAdapterActor);

        film = new Film();
        film.setPoster(R.drawable.sem_capa);
        posterImageView.setImageResource(film.getPoster());
    }


    public void concluir(View view){
        Bundle bundle = new Bundle();
        film.setTitle(titleEditText.getText().toString());
        film.setReleased(releasedEditText.getText().toString());
        film.setGenre(genreEditText.getText().toString());
        film.setDirector(directorNameSpinner.getSelectedItem().toString());
        film.setProtagonist(actorNameSpinner.getSelectedItem().toString());
        bundle.putSerializable("film", film);
        Intent returnIntent = new Intent();
        returnIntent.putExtras(bundle);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();

    }

}
