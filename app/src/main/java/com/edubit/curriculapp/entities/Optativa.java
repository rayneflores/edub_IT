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
public class Optativa implements Serializable {
    private int oId;
    private int oPal;
    private int oMym;
    private int oMyp;
    private int oPom;
    private int oTap;
    private int oAru;
    private int oGyp;
    private int oMat;
    private int oRea;
    private int oPrp;
}
