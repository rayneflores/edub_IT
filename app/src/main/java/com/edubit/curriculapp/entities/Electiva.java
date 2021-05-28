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
public class Electiva implements Serializable {
    private int eId;
    private int eEg;
    private int eCts;
    private int eMc;
    private int eEp;
    private int ePi;
    private int eIc;
}
