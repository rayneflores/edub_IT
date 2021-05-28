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
public class CurriMap implements Serializable {
    private int cmId;
    private int cmInArq;
    private int cmTecInteg;
    private int cmAcondNat;
    private int cmPyr1;
    private int cmPyr2;
    private int cmTransv1;
}
