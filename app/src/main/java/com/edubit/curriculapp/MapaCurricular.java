package com.edubit.curriculapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.edubit.curriculapp.database.ConexionSQLiteHelper;
import com.edubit.curriculapp.entities.CurriMap;

import static com.edubit.curriculapp.Utilities.Utilities.*;

public class MapaCurricular extends AppCompatActivity {

    Switch swInArq, swTecInteg, swAcondNat, swPyr1, swPyr2, swTransv1;
    int valSwInArq, valSwTecInteg, valSwAcondNat, valSwPyr1, valSwPyr2, valSwTransv1;

    ConexionSQLiteHelper conn;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_curricular);

        conn = new ConexionSQLiteHelper(MapaCurricular.this);

        swInArq = findViewById(R.id.swInArq);
        swTecInteg = findViewById(R.id.swTecInteg);
        swAcondNat = findViewById(R.id.swAcondNat);
        swPyr1 = findViewById(R.id.swPyr1);
        swPyr2 = findViewById(R.id.swPyr2);
        swTransv1 = findViewById(R.id.swTransv1);

        swInArq.setOnCheckedChangeListener((buttonView, isChecked) -> valSwInArq = swInArq.isChecked() ? 1 : 0);
        swTecInteg.setOnCheckedChangeListener((buttonView, isChecked) -> valSwTecInteg = swTecInteg.isChecked() ? 1 : 0);
        swAcondNat.setOnCheckedChangeListener((buttonView, isChecked) -> valSwAcondNat = swAcondNat.isChecked() ? 1 : 0);
        swPyr1.setOnCheckedChangeListener((buttonView, isChecked) -> valSwPyr1 = swPyr1.isChecked() ? 1 : 0);
        swPyr2.setOnCheckedChangeListener((buttonView, isChecked) -> valSwPyr2 = swPyr2.isChecked() ? 1 : 0);
        swTransv1.setOnCheckedChangeListener((buttonView, isChecked) -> valSwTransv1 = swTransv1.isChecked() ? 1 : 0);

        queryCurricularMap();

    }

    private void queryCurricularMap() {
        db = conn.getReadableDatabase();
        CurriMap curriMap = null;

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_CURR_MAP, null);

        while (cursor.moveToNext()) {
            curriMap = new CurriMap();
            curriMap.setCmId(cursor.getInt(0));
            curriMap.setCmInArq(cursor.getInt(1));
            curriMap.setCmTecInteg(cursor.getInt(2));
            curriMap.setCmAcondNat(cursor.getInt(3));
            curriMap.setCmPyr1(cursor.getInt(4));
            curriMap.setCmPyr2(cursor.getInt(5));
            curriMap.setCmTransv1(cursor.getInt(6));
        }

        try {
            swInArq.setChecked(curriMap.getCmInArq() != 0);
            swTecInteg.setChecked(curriMap.getCmTecInteg() != 0);
            swAcondNat.setChecked(curriMap.getCmAcondNat() != 0);
            swPyr1.setChecked(curriMap.getCmPyr1() != 0);
            swPyr2.setChecked(curriMap.getCmPyr2() != 0);
            swTransv1.setChecked(curriMap.getCmTransv1() != 0);

        } catch (Exception e) {
            insertTestReg(0,0,0,0,0,0);
        }
    }

    private void insertTestReg(int inArq, int tecInteg, int acondNat, int pyr1, int pyr2, int transv1) {
        db = conn.getWritableDatabase();

        String insert = "INSERT INTO " + TABLE_CURR_MAP + " (" +
                FIELD_CM_IN_ARQ + ", " +
                FIELD_CM_TEC_INT + ", " +
                FIELD_CM_ACO_NAT + ", " +
                FIELD_CM_PYR_1 + ", " +
                FIELD_CM_PYR_2 + ", " +
                FIELD_CM_TRA_1 + ") VALUES (" +
                inArq + ", " +
                tecInteg + ", " +
                acondNat + ", " +
                pyr1 + ", " +
                pyr2 + ", " +
                transv1 + ")";
        db.execSQL(insert);
        db.close();
    }

    public void updateCurrMap(View view) {

        db = conn.getWritableDatabase();

        String update = "UPDATE " +
                TABLE_CURR_MAP + " SET " +
                FIELD_CM_IN_ARQ + " = " + valSwInArq + ", " +
                FIELD_CM_TEC_INT + " = " + valSwTecInteg + ", " +
                FIELD_CM_ACO_NAT + " = " + valSwAcondNat + ", " +
                FIELD_CM_PYR_1 + " = " + valSwPyr1 + ", " +
                FIELD_CM_PYR_2 + " = " + valSwPyr2 + ", " +
                FIELD_CM_TRA_1 + " = " + valSwTransv1;

        db.execSQL(update);
        db.close();
        Toast.makeText(getApplicationContext(), R.string.save, Toast.LENGTH_LONG).show();
        finish();
    }
}