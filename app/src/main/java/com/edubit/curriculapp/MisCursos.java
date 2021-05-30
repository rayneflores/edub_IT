package com.edubit.curriculapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.edubit.curriculapp.database.ConexionSQLiteHelper;

import static com.edubit.curriculapp.Utilities.Utilities.*;


public class MisCursos extends AppCompatActivity {

    Button button2, button3, button9;

    ProgressBar progressBar;

    ConexionSQLiteHelper conn;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_cursos);

        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button9 = findViewById(R.id.button9);

        button2.setEnabled(false);
        button3.setEnabled(false);
        button9.setEnabled(false);

        progressBar = findViewById(R.id.progressBar);

        conn = new ConexionSQLiteHelper(MisCursos.this);

        progressBar.setProgress((int) calculateProgress());
    }

    private double calculateProgress() {

        int count;
        String countQuery;
        Cursor cursor;

        db = conn.getReadableDatabase();

        countQuery = "SELECT * FROM " + TABLE_CURR_MAP + " WHERE " + FIELD_CM_IN_ARQ + " = 1";
        cursor = db.rawQuery(countQuery, null);
        count = cursor.getCount();
        cursor.close();

        countQuery = "SELECT * FROM " + TABLE_CURR_MAP + " WHERE " + FIELD_CM_TEC_INT + " = 1";
        cursor = db.rawQuery(countQuery, null);
        count += cursor.getCount();
        cursor.close();

        countQuery = "SELECT * FROM " + TABLE_CURR_MAP + " WHERE " + FIELD_CM_ACO_NAT + " = 1";
        cursor = db.rawQuery(countQuery, null);
        count += cursor.getCount();
        cursor.close();

        countQuery = "SELECT * FROM " + TABLE_CURR_MAP + " WHERE " + FIELD_CM_PYR_1 + " = 1";
        cursor = db.rawQuery(countQuery, null);
        count += cursor.getCount();
        cursor.close();

        countQuery = "SELECT * FROM " + TABLE_CURR_MAP + " WHERE " + FIELD_CM_PYR_2 + " = 1";
        cursor = db.rawQuery(countQuery, null);
        count += cursor.getCount();
        cursor.close();

        countQuery = "SELECT * FROM " + TABLE_CURR_MAP + " WHERE " + FIELD_CM_TRA_1 + " = 1";
        cursor = db.rawQuery(countQuery, null);
        count += cursor.getCount();
        cursor.close();

        return ((count * 100) / 6);
    }


    public void goToMapa(View view) {
        //Toast.makeText(getApplicationContext(), R.string.menu_perfil, Toast.LENGTH_LONG).show();
        finish();
        startActivity(new Intent(this, MapaCurricular.class));
    }
}