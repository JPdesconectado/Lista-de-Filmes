package com.example.listadefilme.Main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;
import com.example.listadefilme.Actor.Actor;
import com.example.listadefilme.Actor.ActorFragment;
import com.example.listadefilme.Director.Director;
import com.example.listadefilme.Director.DirectorFragment;
import com.example.listadefilme.Film.Film;
import com.example.listadefilme.Film.FilmFragment;
import com.example.listadefilme.R;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    FilmFragment filmFragment = new FilmFragment();
    ActorFragment actorFragment = new ActorFragment();
    DirectorFragment directorFragment = new DirectorFragment();

    private List<Film> listFilm;
    private List<Director> listDirector;
    private List<Actor> listActor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container_fragment, filmFragment);
        fragmentTransaction.commit();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        switch(item.getItemId()){

            case R.id.films:

                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container_fragment, filmFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;

            case R.id.actors:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container_fragment, actorFragment);
                fragmentTransaction.commit();
                break;

            case R.id.directors:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container_fragment, directorFragment);
                fragmentTransaction.commit();
                break;

        }
        return true;
    }

    public List<Film> getListFilm() {
        return listFilm;
    }

    public void setListFilm(List<Film> listFilm) {
        this.listFilm = listFilm;
    }

    public List<Director> getListDirector() {
        return listDirector;
    }

    public void setListDirector(List<Director> listDirector) {
        this.listDirector = listDirector;
    }

    public List<Actor> getListActor() {
        return listActor;
    }

    public void setListActor(List<Actor> listActor) {
        this.listActor = listActor;
    }
}
