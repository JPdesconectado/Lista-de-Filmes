package com.example.listadefilme.Actor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.listadefilme.R;

public class newActorActivity extends AppCompatActivity {

    ImageView photoImageView;
    EditText nameEditText;
    EditText birthEditText;
    Actor actor;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.director_add);
        photoImageView = findViewById(R.id.photoImageView);
        nameEditText = findViewById(R.id.nameEditText);
        birthEditText = findViewById(R.id.anoEditText);

        actor = new Actor();
        actor.setPhoto(R.drawable.sem_capa);
        photoImageView.setImageResource(actor.getPhoto());
    }

    public void concluir(View view){
        Bundle bundle = new Bundle();
        actor.setName(nameEditText.getText().toString());
        actor.setBirth(birthEditText.getText().toString());
        bundle.putSerializable("actor", actor);

        Intent returnIntent = new Intent();
        returnIntent.putExtras(bundle);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }
}
