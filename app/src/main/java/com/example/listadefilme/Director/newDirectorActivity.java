package com.example.listadefilme.Director;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.listadefilme.R;

public class newDirectorActivity extends AppCompatActivity {

    ImageView photoImageView;
    EditText nameEditText;
    EditText birthEditText;
    Director director;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.director_add);
        photoImageView = findViewById(R.id.photoImageView);
        nameEditText = findViewById(R.id.nameEditText);
        birthEditText = findViewById(R.id.anoEditText);

        director = new Director();
        director.setPhoto(R.drawable.sem_capa);
        photoImageView.setImageResource(director.getPhoto());

    }

    public void concluir(View view){
        Bundle bundle = new Bundle();
        director.setName(nameEditText.getText().toString());
        director.setBirth(birthEditText.getText().toString());
        bundle.putSerializable("director", director);

        Intent returnIntent = new Intent();
        returnIntent.putExtras(bundle);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }
}
