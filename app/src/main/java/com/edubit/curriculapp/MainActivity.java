package com.edubit.curriculapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.edubit.curriculapp.database.ConexionSQLiteHelper;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    ConexionSQLiteHelper conn;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conn = new ConexionSQLiteHelper(MainActivity.this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        NavigationView nav_view = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
        case R.id.nav_perfil:
            Intent intent_nav_perfil = new Intent(this, Perfil.class);
            startActivity(intent_nav_perfil);
            break;
        case R.id.nav_miscursos:
            Intent intent_nav_miscursos = new Intent(this, MisCursos.class);
            startActivity(intent_nav_miscursos);
            break;
        case R.id.nav_optativas:
            Intent intent_nav_optativas = new Intent(this, Optativas.class);
            startActivity(intent_nav_optativas);
            break;
        case R.id.nav_electivas:
            Intent intent_nav_electivas = new Intent(this, Electivas.class);
            startActivity(intent_nav_electivas);
            break;
        case R.id.nav_informacion:
            Intent intent_nav_informacion = new Intent(this, Informacion.class);
            startActivity(intent_nav_informacion);
            break;
        case R.id.nav_configuracion:
            Intent intent_nav_configuracion = new Intent(this, Configuracion.class);
            startActivity(intent_nav_configuracion);
            break;
        default:
            throw new IllegalArgumentException("Opción no existente");

        }
        return true;
    }


}