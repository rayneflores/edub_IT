package com.edubit.curriculapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.edubit.curriculapp.database.ConexionSQLiteHelper;
import com.edubit.curriculapp.entities.Electiva;

import static com.edubit.curriculapp.Utilities.Utilities.*;

public class Electivas extends AppCompatActivity {

    Switch swEeg, swEcts, swEmc, swEep, swEpi, swEic;
    int valSwEeg, valSwEcts, valSwEmc, valSwEep, valSwEpi, valSwEic;

    ConexionSQLiteHelper conn;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electivas);

        conn = new ConexionSQLiteHelper(Electivas.this);

        swEeg = findViewById(R.id.swEeg);
        swEcts = findViewById(R.id.swEcts);
        swEmc = findViewById(R.id.swEmc);
        swEep = findViewById(R.id.swEep);
        swEpi = findViewById(R.id.swEpi);
        swEic = findViewById(R.id.swEic);

        swEeg.setOnCheckedChangeListener(((buttonView, isChecked) -> valSwEeg = swEeg.isChecked() ? 1 : 0));
        swEcts.setOnCheckedChangeListener(((buttonView, isChecked) -> valSwEcts = swEcts.isChecked() ? 1 : 0));
        swEmc.setOnCheckedChangeListener(((buttonView, isChecked) -> valSwEmc = swEmc.isChecked() ? 1 : 0));
        swEep.setOnCheckedChangeListener(((buttonView, isChecked) -> valSwEep = swEep.isChecked() ? 1 : 0));
        swEpi.setOnCheckedChangeListener(((buttonView, isChecked) -> valSwEpi = swEpi.isChecked() ? 1 : 0));
        swEic.setOnCheckedChangeListener(((buttonView, isChecked) -> valSwEic = swEic.isChecked() ? 1 : 0));

        queryElectivas();
    }

    private void queryElectivas() {
        db = conn.getReadableDatabase();
        Electiva electiva = null;

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_ELECTIVA, null);

        while (cursor.moveToNext()) {
            electiva = new Electiva();
            electiva.setEId(cursor.getInt(0));
            electiva.setEEg(cursor.getInt(1));
            electiva.setECts(cursor.getInt(2));
            electiva.setEMc(cursor.getInt(3));
            electiva.setEEp(cursor.getInt(4));
            electiva.setEPi(cursor.getInt(5));
            electiva.setEIc(cursor.getInt(6));
        }

        try {
            swEeg.setChecked(electiva.getEEg() != 0);
            swEcts.setChecked(electiva.getECts() != 0);
            swEmc.setChecked(electiva.getEMc() != 0);
            swEep.setChecked(electiva.getEEp() != 0);
            swEpi.setChecked(electiva.getEPi() != 0);
            swEic.setChecked(electiva.getEIc() != 0);

        } catch (Exception e) {
            insertTestReg(0,0,0,0,0,0);
        }
    }

    private void insertTestReg(int eEg, int eCts, int eMc, int eEp, int ePi, int eIc) {

        db = conn.getWritableDatabase();

        String insert = "INSERT INTO " + TABLE_ELECTIVA + " (" +
                FIELD_E_EG + ", " +
                FIELD_E_CTS + ", " +
                FIELD_E_MC + ", " +
                FIELD_E_EP + ", " +
                FIELD_E_PI + ", " +
                FIELD_E_IC + ") VALUES (" +
                eEg + ", " +
                eCts + ", " +
                eMc + ", " +
                eEp + ", " +
                ePi + ", " +
                eIc + ")";

        db.execSQL(insert);
        db.close();

    }

    public void updateElectivas(View view) {

        db = conn.getWritableDatabase();

        String update = "UPDATE " +
                TABLE_ELECTIVA + " SET " +
                FIELD_E_EG + " = " + valSwEeg + ", " +
                FIELD_E_CTS + " = " + valSwEcts + ", " +
                FIELD_E_MC + " = " + valSwEmc + ", " +
                FIELD_E_EP + " = " + valSwEep + ", " +
                FIELD_E_PI + " = " + valSwEpi + ", " +
                FIELD_E_IC + " = " + valSwEic;

        db.execSQL(update);
        db.close();
        Toast.makeText(getApplicationContext(), R.string.save, Toast.LENGTH_LONG).show();
        finish();
    }
}