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
import androidx.fragment.app.Fragment;
import com.example.listadefilme.Actor.Actor;
import com.example.listadefilme.Actor.ActorAdapter;
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
    List<Actor> listActor = new ArrayList<>();
    List<Director> listDirector = new ArrayList<>();

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
