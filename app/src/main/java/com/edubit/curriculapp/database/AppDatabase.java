package com.edubit.curriculapp.database;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.edubit.curriculapp.daos.mcDao;
import com.edubit.curriculapp.entities.mc;

@Database(entities = {mc.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract mcDao McDao();
}
