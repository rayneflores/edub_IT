package com.edubit.curriculapp.daos;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Update;

import com.edubit.curriculapp.entities.mc;

import java.util.List;

@Dao
public interface mcDao {

    @Query("SELECT id,nombre, creditos, area, previaturas, dictadoSemestral FROM mc WHERE nombre=:nombre")
    public List<mc> infoByName(String nombre);

    @Query("SELECT * FROM mc WHERE id=:id")
    public List<mc> nombreById(int id);

    @Update
    void aprobe (mc materiaAprobada);

    @Update
    void aprobeProf (mc profAprobada);

    @Update
    void noaprobeProf (mc profNoAprobada);

}
