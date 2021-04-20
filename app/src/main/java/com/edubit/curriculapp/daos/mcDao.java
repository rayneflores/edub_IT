package com.edubit.curriculapp.daos;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Update;

import com.edubit.curriculapp.entities.mc;

import java.util.List;

@Dao
public interface mcDao {

    @Query("SELECT nombre, creditos, area, previaturas FROM mc WHERE nombre='(:nombre)'")
    List<mc> infoByName(String nombre);

    @Query("SELECT nombre FROM mc WHERE id=:id")
    List<mc> nombreById(int id);

    @Update
    void aprobe (mc materiaAprobada);

    @Update
    void aprobeProf (mc profAprobada);

    @Update
    void noaprobeProf (mc profNoAprobada);

}
