package com.kuroyuki.musikkita;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bnvmusikkita;
    private ActionBar judulbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        judulbar = getSupportActionBar();
        judulbar.setTitle("Musik");
        bukafragment(new MusikFragment());

        bnvmusikkita = findViewById(R.id.bnv_musik_kita);
        bnvmusikkita.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fr;
                switch (item.getItemId()){
                    case R.id.menu_musik:
                        bukafragment(new MusikFragment());
                        judulbar.setTitle("Musik");
                        return true;
                    case R.id.menu_album:
                        bukafragment(new AlbumFragment());
                        judulbar.setTitle("Album");
                        return true;
                    case R.id.menu_artis:
                        bukafragment(new ArtistFragment());
                        judulbar.setTitle("Artist");
                        return true;
                }
                return false;
            }
        });

    }
    private void bukafragment(Fragment fr){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fl_container, fr);
        ft.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_atas, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menu_about){
            startActivity(new Intent(MainActivity.this, AboutActivity.class));
        }
        if(item.getItemId() == R.id.menu_help){
            startActivity(new Intent(MainActivity.this, HelpActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}