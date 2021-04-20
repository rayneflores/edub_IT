package com.edubit.curriculapp.entities;

import androidx.room.Entity;

@Entity(primaryKeys = {"id"})
public class mc {

    public int id ;
    private String nombre;
    private int creditos;
    private int area;
    private String previaturas;
    private int dictadoSemestral;
    private String ancla;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getPreviaturas() {
        return previaturas;
    }

    public void setPreviaturas(String previaturas) {
        this.previaturas = previaturas;
    }

    public int getDictadoSemestral() {
        return dictadoSemestral;
    }

    public void setDictadoSemestral(int dictadoSemestral) {
        this.dictadoSemestral = dictadoSemestral;
    }

    public String getAncla() {
        return ancla;
    }

    public void setAncla(String ancla) {
        this.ancla = ancla;
    }
}

