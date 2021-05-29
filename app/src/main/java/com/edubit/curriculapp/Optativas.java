package com.edubit.curriculapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.edubit.curriculapp.database.ConexionSQLiteHelper;
import com.edubit.curriculapp.entities.Optativa;

import static com.edubit.curriculapp.Utilities.Utilities.FIELD_O_ARU;
import static com.edubit.curriculapp.Utilities.Utilities.FIELD_O_GYP;
import static com.edubit.curriculapp.Utilities.Utilities.FIELD_O_MAT;
import static com.edubit.curriculapp.Utilities.Utilities.FIELD_O_MYM;
import static com.edubit.curriculapp.Utilities.Utilities.FIELD_O_MYP;
import static com.edubit.curriculapp.Utilities.Utilities.FIELD_O_PAL;
import static com.edubit.curriculapp.Utilities.Utilities.FIELD_O_POM;
import static com.edubit.curriculapp.Utilities.Utilities.FIELD_O_PRP;
import static com.edubit.curriculapp.Utilities.Utilities.FIELD_O_REA;
import static com.edubit.curriculapp.Utilities.Utilities.FIELD_O_TAP;
import static com.edubit.curriculapp.Utilities.Utilities.TABLE_OPTATIVA;

public class Optativas extends AppCompatActivity {

    Switch swOpal, swOmym, swOmyp, swOpom, swOtap, swOaru, swOgyp, swOmat, swOrea, swOprp;
    int valSwOpal, valSwOmym, valSwOmyp, valSwOpom, valSwOtap, valSwOaru, valSwOgyp, valSwOmat, valSwOrea, valSwOprp;

    ConexionSQLiteHelper conn;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_optativas);

        conn = new ConexionSQLiteHelper(Optativas.this);

        swOpal = findViewById(R.id.swOpal);
        swOmym = findViewById(R.id.swOmym);
        swOmyp = findViewById(R.id.swOmyp);
        swOpom = findViewById(R.id.swOpom);
        swOtap = findViewById(R.id.swOtap);
        swOaru = findViewById(R.id.swOaru);
        swOgyp = findViewById(R.id.swOgyp);
        swOmat = findViewById(R.id.swOmat);
        swOrea = findViewById(R.id.swOrea);
        swOprp = findViewById(R.id.swOprp);

        swOpal.setOnCheckedChangeListener((buttonView, isChecked) -> valSwOpal = swOpal.isChecked() ? 1 : 0);
        swOmym.setOnCheckedChangeListener((buttonView, isChecked) -> valSwOmym = swOmym.isChecked() ? 1 : 0);
        swOmyp.setOnCheckedChangeListener((buttonView, isChecked) -> valSwOmyp = swOmyp.isChecked() ? 1 : 0);
        swOpom.setOnCheckedChangeListener((buttonView, isChecked) -> valSwOpom = swOpom.isChecked() ? 1 : 0);
        swOtap.setOnCheckedChangeListener((buttonView, isChecked) -> valSwOtap = swOtap.isChecked() ? 1 : 0);
        swOaru.setOnCheckedChangeListener((buttonView, isChecked) -> valSwOaru = swOaru.isChecked() ? 1 : 0);
        swOgyp.setOnCheckedChangeListener((buttonView, isChecked) -> valSwOgyp = swOgyp.isChecked() ? 1 : 0);
        swOmat.setOnCheckedChangeListener((buttonView, isChecked) -> valSwOmat = swOmat.isChecked() ? 1 : 0);
        swOrea.setOnCheckedChangeListener((buttonView, isChecked) -> valSwOrea = swOrea.isChecked() ? 1 : 0);
        swOprp.setOnCheckedChangeListener((buttonView, isChecked) -> valSwOprp = swOprp.isChecked() ? 1 : 0);

        queryOptativas();

    }

    private void queryOptativas() {
        db = conn.getReadableDatabase();
        Optativa optativa = null;

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_OPTATIVA, null);

        while (cursor.moveToNext()) {
            optativa = new Optativa();
            optativa.setOId(cursor.getInt(0));
            optativa.setOPal(cursor.getInt(1));
            optativa.setOMym(cursor.getInt(2));
            optativa.setOMyp(cursor.getInt(3));
            optativa.setOPom(cursor.getInt(4));
            optativa.setOTap(cursor.getInt(5));
            optativa.setOAru(cursor.getInt(6));
            optativa.setOGyp(cursor.getInt(7));
            optativa.setOMat(cursor.getInt(8));
            optativa.setORea(cursor.getInt(9));
            optativa.setOPrp(cursor.getInt(10));
        }

        try {
            swOpal.setChecked(optativa.getOPal() != 0);
            swOmym.setChecked(optativa.getOMym() != 0);
            swOmyp.setChecked(optativa.getOMyp() != 0);
            swOpom.setChecked(optativa.getOPom() != 0);
            swOtap.setChecked(optativa.getOTap() != 0);
            swOaru.setChecked(optativa.getOAru() != 0);
            swOgyp.setChecked(optativa.getOGyp() != 0);
            swOmat.setChecked(optativa.getOMat() != 0);
            swOrea.setChecked(optativa.getORea() != 0);
            swOprp.setChecked(optativa.getOPrp() != 0);

        } catch (Exception e) {
            insertTestReg(0,0,0,0,0,0,0,0,0,0);
        }
    }

    private void insertTestReg(int oPal, int oMym, int oMyp, int oPom, int oTap, int oAru, int oGyp, int oMat, int oRea, int oPrp) {

        db = conn.getWritableDatabase();

        String insert = "INSERT INTO " + TABLE_OPTATIVA + " (" +
                FIELD_O_PAL + ", " +
                FIELD_O_MYM + ", " +
                FIELD_O_MYP + ", " +
                FIELD_O_POM + ", " +
                FIELD_O_TAP + ", " +
                FIELD_O_ARU + ", " +
                FIELD_O_GYP + ", " +
                FIELD_O_MAT + ", " +
                FIELD_O_REA + ", " +
                FIELD_O_PRP + ") VALUES (" +
                oPal + ", " +
                oMym + ", " +
                oMyp + ", " +
                oPom + ", " +
                oTap + ", " +
                oAru + ", " +
                oGyp + ", " +
                oMat + ", " +
                oRea + ", " +
                oPrp + ")";

        db.execSQL(insert);
        db.close();
    }

    public void updateOptativas(View view) {

        db = conn.getWritableDatabase();

        String update = "UPDATE " +
                TABLE_OPTATIVA + " SET " +
                FIELD_O_PAL + " = " + valSwOpal + ", " +
                FIELD_O_MYM + " = " + valSwOmym + ", " +
                FIELD_O_MYP + " = " + valSwOmyp + ", " +
                FIELD_O_POM + " = " + valSwOpom + ", " +
                FIELD_O_TAP + " = " + valSwOtap + ", " +
                FIELD_O_ARU + " = " + valSwOaru + ", " +
                FIELD_O_GYP + " = " + valSwOgyp + ", " +
                FIELD_O_MAT + " = " + valSwOmat + ", " +
                FIELD_O_REA + " = " + valSwOrea + ", " +
                FIELD_O_PRP + " = " + valSwOprp;

        db.execSQL(update);
        db.close();
        Toast.makeText(getApplicationContext(), R.string.save, Toast.LENGTH_LONG).show();
        finish();
    }
}