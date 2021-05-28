package com.edubit.curriculapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.edubit.curriculapp.database.ConexionSQLiteHelper;
import com.edubit.curriculapp.entities.Profile;
import com.google.android.material.textfield.TextInputEditText;

import static com.edubit.curriculapp.Utilities.Utilities.*;

public class Perfil extends AppCompatActivity {

    TextInputEditText etNombreProfile;
    CheckBox cbAutocad, cb3D, cbIllustrator, cbPhotoshop, cbRevit, cbCorel;

    ConexionSQLiteHelper conn;
    SQLiteDatabase db;
    int valcbA, valcb3, valcbI, valcbP, valcbR, valcbC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        conn = new ConexionSQLiteHelper(Perfil.this);

        etNombreProfile = findViewById(R.id.etNombreProfile);
        cb3D = findViewById(R.id.cb3D);
        cbAutocad = findViewById(R.id.cbAutocad);
        cbCorel = findViewById(R.id.cbCorel);
        cbIllustrator = findViewById(R.id.cbIllustrator);
        cbPhotoshop = findViewById(R.id.cbPhotoshop);
        cbRevit = findViewById(R.id.cbRevit);

        cb3D.setOnCheckedChangeListener((buttonView, isChecked) -> valcb3 = cb3D.isChecked() ? 1 : 0);
        cbAutocad.setOnCheckedChangeListener((buttonView, isChecked) -> valcbA = cbAutocad.isChecked() ? 1 : 0);
        cbCorel.setOnCheckedChangeListener((buttonView, isChecked) -> valcbC = cbCorel.isChecked() ? 1 : 0);
        cbIllustrator.setOnCheckedChangeListener((buttonView, isChecked) -> valcbI = cbIllustrator.isChecked() ? 1 : 0);
        cbPhotoshop.setOnCheckedChangeListener((buttonView, isChecked) -> valcbP = cbPhotoshop.isChecked() ? 1 : 0);
        cbRevit.setOnCheckedChangeListener((buttonView, isChecked) -> valcbR = cbRevit.isChecked() ? 1 : 0);

        queryProfile();


    }

    private void queryProfile() {
        db = conn.getReadableDatabase();
        Profile profile = null;

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_PROFILE,  null);

        while (cursor.moveToNext()) {
            profile = new Profile();
            profile.setPId(cursor.getInt(0));
            profile.setPName(cursor.getString(1));
            profile.setP3(cursor.getInt(2));
            profile.setPA(cursor.getInt(3));
            profile.setPC(cursor.getInt(4));
            profile.setPI(cursor.getInt(5));
            profile.setPP(cursor.getInt(6));
            profile.setPR(cursor.getInt(7));
        }

        try {
            etNombreProfile.setText(profile.getPName().trim());
            cbAutocad.setChecked(profile.getPA() != 0);
            cb3D.setChecked(profile.getP3() != 0);
            cbCorel.setChecked(profile.getPC() != 0);
            cbIllustrator.setChecked(profile.getPI() != 0);
            cbPhotoshop.setChecked(profile.getPP() != 0);
            cbRevit.setChecked(profile.getPR() != 0);
        } catch (Exception e) {
            insertTestReg("Profile Test", 0,0,0,0,0,0);
            etNombreProfile.setText("Profile Test");
        }
    }

    private void insertTestReg(String profile_Name, int _3dMax, int autocad, int corel, int illustrator, int photoshop, int revit) {
        db = conn.getWritableDatabase();

        String insert = "INSERT INTO " + TABLE_PROFILE + " (" +
                FIELD_P_NAME + ", " +
                FIELD_P_3 + ", " +
                FIElD_P_A + ", " +
                FIELD_P_C + ", " +
                FIELD_P_I + ", " +
                FIELD_P_P + ", " +
                FIELD_P_R + ") VALUES ('" +
                profile_Name + "', " +
                _3dMax + ", " +
                autocad + ", " +
                corel + ", " +
                illustrator + ", " +
                photoshop + ", " +
                revit + ")";
        db.execSQL(insert);
        db.close();
    }

    public void updateProfile(View view) {

        db = conn.getWritableDatabase();

        String update = "UPDATE " +
                TABLE_PROFILE + " SET " +
                FIELD_P_NAME + " = '" + etNombreProfile.getText() + "', " +
                FIELD_P_3 + " = " + valcb3 + ", " +
                FIElD_P_A + " = " + valcbA + ", " +
                FIELD_P_C + " = " + valcbC + ", " +
                FIELD_P_I + " = " + valcbI + ", " +
                FIELD_P_P + " = " + valcbP + ", " +
                FIELD_P_R + " = " + valcbR;

        db.execSQL(update);
        db.close();
        Toast.makeText(getApplicationContext(), R.string.save, Toast.LENGTH_LONG).show();
        finish();
    }
}