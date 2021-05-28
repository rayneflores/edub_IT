package com.edubit.curriculapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import com.edubit.curriculapp.database.ConexionSQLiteHelper;
import com.edubit.curriculapp.entities.Notif;

import java.util.ArrayList;

import static com.edubit.curriculapp.Utilities.Utilities.FIELD_N_ENABLED;
import static com.edubit.curriculapp.Utilities.Utilities.FIELD_N_NAME;
import static com.edubit.curriculapp.Utilities.Utilities.TABLE_NOTIFICATION;

public class Configuracion extends AppCompatActivity {

    private Window window;
    Switch switch1, switch2;
    ConexionSQLiteHelper conn;
    SQLiteDatabase db;
    boolean valueSwitch1, valueSwitch2;

    ArrayList<Notif> notifsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        conn = new ConexionSQLiteHelper(Configuracion.this);

        switch1 = findViewById(R.id.swInArq);
        switch2 = findViewById(R.id.swTecInteg);

        switch1.setOnCheckedChangeListener((buttonView, isChecked) -> updateNotification("notif1", isChecked));
        switch2.setOnCheckedChangeListener((buttonView, isChecked) -> updateNotification("notif2", isChecked));

        this.window = getWindow();

        findViewById(R.id.button6).setOnClickListener(v -> {
            String primaryDark = "#BA4C00";
            String primary = "#F47B00";
            String background = "#F7F9F8";
            cambiarColor(primaryDark,primary,background);

        });

        findViewById(R.id.button7).setOnClickListener(v -> {
            String primaryDark = "#F47B00";
            String primary = "#FFAC42";
            String background = "#C6C6C6";
            cambiarColor(primaryDark,primary,background);

        });

        queryNotificationList();

    }

    private void queryNotificationList() {
        db = conn.getReadableDatabase();

        Notif notif;
        notifsList = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NOTIFICATION, null);

        while (cursor.moveToNext()) {
            notif = new Notif();
            notif.nId = cursor.getInt(0);
            notif.nName = cursor.getString(1);
            notif.nEnabled = cursor.getInt(2);
            notifsList.add(notif);
        }

        try {
            valueSwitch1 = notifsList.get(0).getNEnabled() != 0;
            switch1.setChecked(valueSwitch1);

            valueSwitch2 = notifsList.get(1).getNEnabled() != 0;
            switch2.setChecked(valueSwitch2);
        } catch (Exception e) {
            insertTestReg("notif1", 0);
            insertTestReg("notif2", 0);
            //Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }

    private void insertTestReg(String notif, int value) {
        db = conn.getWritableDatabase();

        String insert = "INSERT INTO " + TABLE_NOTIFICATION + " (" +
                FIELD_N_NAME + ", " +
                FIELD_N_ENABLED + ") VALUES ('" +
                notif + "', " +
                value + ")";

        db.execSQL(insert);
        db.close();
    }

    private void updateNotification(String notif, boolean value) {
        int fieldValue;
        if (value) {
            fieldValue = 1;
        } else {
            fieldValue = 0;
        }

        db = conn.getWritableDatabase();

        String update = "UPDATE " +
                TABLE_NOTIFICATION + " SET " +
                FIELD_N_ENABLED + " = " + fieldValue + " WHERE " +
                FIELD_N_NAME + " = '" + notif + "'" ;
        db.execSQL(update);
        db.close();
    }

    private void cambiarColor(String primaryDark, String primary, String background){
        window.setStatusBarColor(Color.parseColor(primaryDark));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(primary)));
        window.setBackgroundDrawable(new ColorDrawable(Color.parseColor(background)));
        window.setNavigationBarColor(Color.parseColor(primary));

    }
}