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
public class Notif implements Serializable {
    public int nId;
    public String nName;
    public int nEnabled;
}
