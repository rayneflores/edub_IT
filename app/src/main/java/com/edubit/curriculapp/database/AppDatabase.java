package com.edubit.curriculapp.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.edubit.curriculapp.daos.mcDao;
import com.edubit.curriculapp.entities.mc;

@Database(entities = {mc.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract mcDao McDao();

    private static volatile AppDatabase instance;

    public static AppDatabase getInstance(final Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "database").createFromAsset("databases/mat.db").build();
        }
        return instance;
    }
}
