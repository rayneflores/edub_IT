package com.edubit.curriculapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class Configuracion extends AppCompatActivity {

    private Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        this.window = getWindow();

        findViewById(R.id.button6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String primaryDark = "ba4c00";
                String primary = "f47b00";
                String background = "f7f9f8";
                cambiarColor(primaryDark,primary,background);

            }
        });

        findViewById(R.id.button7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String primaryDark = "f47b00";
                String primary = "ffac42";
                String background = "c6c6c6";
                cambiarColor(primaryDark,primary,background);

            }
        });







    }

    private void cambiarColor(String primaryDark, String primary, String background){
        //colorPrimaryDark
        window.setStatusBarColor(Color.parseColor(primaryDark));
        //colorPrimary
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(primary)));
        //bg
        window.setBackgroundDrawable(new ColorDrawable(Color.parseColor(background)));
        //bottom navigation
        window.setNavigationBarColor(Color.parseColor(primary));

    }
}