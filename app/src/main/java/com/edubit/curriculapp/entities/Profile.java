package com.edubit.curriculapp.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Profile implements Serializable {
    public int pId;
    public String pName;
    public int p3;
    public int pA;
    public int pC;
    public int pI;
    public int pP;
    public int pR;
}
