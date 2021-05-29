package com.edubit.curriculapp.Utilities;

public class Utilities {

    public static final String dbName = "cursos.db";
    public static final Integer dbVersion = 1;

    /*constantes tabla Notificaciones*/
    public static final String TABLE_NOTIFICATION = "notification";
    public static final String FIELD_N_ID = "nid";
    public static final String FIELD_N_NAME = "nname";
    public static final String FIELD_N_ENABLED = "nenabled";

    /*Creacion tabla Notificaciones*/
    public static final String CREATE_TABLE_NOTIFICATION = "CREATE TABLE IF NOT EXISTS " +
            TABLE_NOTIFICATION + " (" +
            FIELD_N_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            FIELD_N_NAME + " TEXT, " +
            FIELD_N_ENABLED + " INTEGER)";

    /*constantes tabla profile*/
    public static final String TABLE_PROFILE = "profile";
    public static final String FIELD_P_ID = "pid";
    public static final String FIELD_P_NAME= "pname";
    public static final String FIELD_P_3 = "p3";
    public static final String FIElD_P_A = "pa";
    public static final String FIELD_P_C = "pc";
    public static final String FIELD_P_I = "pi";
    public static final String FIELD_P_P = "pp";
    public static final String FIELD_P_R = "pr";

    /*Creacion tabla profile*/
    public static final String CREATE_TABLE_PROFILE = "CREATE TABLE IF NOT EXISTS " +
            TABLE_PROFILE + " (" +
            FIELD_P_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            FIELD_P_NAME + " TEXT, " +
            FIELD_P_3 + " INTEGER, " +
            FIElD_P_A + " INTEGER, " +
            FIELD_P_C + " INTEGER, " +
            FIELD_P_I + " INTEGER, " +
            FIELD_P_P + " INTEGER, " +
            FIELD_P_R + " INTEGER)";

    /*constantes tabla Mapa Curricular*/
    public static final String TABLE_CURR_MAP = "curmap";
    public static final String FIELD_CM_ID = "cmid";
    public static final String FIELD_CM_IN_ARQ = "cminarq";
    public static final String FIELD_CM_TEC_INT = "cmtecinteg";
    public static final String FIELD_CM_ACO_NAT = "cmacondnat";
    public static final String FIELD_CM_PYR_1 = "cmpyr1";
    public static final String FIELD_CM_PYR_2 = "cmpyr2";
    public static final String FIELD_CM_TRA_1 = "cmtransv1";

    /*Creacion tabla Curricular Map*/
    public static final String CREATE_TABLE_CURR_MAP = "CREATE TABLE IF NOT EXISTS " +
            TABLE_CURR_MAP + " (" +
            FIELD_CM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            FIELD_CM_IN_ARQ + " INTEGER, " +
            FIELD_CM_TEC_INT + " INTEGER, " +
            FIELD_CM_ACO_NAT + " INTEGER, " +
            FIELD_CM_PYR_1 + " INTEGER, " +
            FIELD_CM_PYR_2 + " INTEGER, " +
            FIELD_CM_TRA_1 + " INTEGER)";

    /*constantes tabla Electivas*/
    public static final String TABLE_ELECTIVA = "electiva";
    public static final String FIELD_E_ID = "eId";
    public static final String FIELD_E_EG = "eEg";
    public static final String FIELD_E_CTS = "eCts";
    public static final String FIELD_E_MC = "eMc";
    public static final String FIELD_E_EP = "eEp";
    public static final String FIELD_E_PI = "ePi";
    public static final String FIELD_E_IC = "eIc";

    /*Creacion tabla Electiva*/
    public static final String CREATE_TABLE_ELECTIVA = "CREATE TABLE IF NOT EXISTS " +
            TABLE_ELECTIVA + " (" +
            FIELD_E_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            FIELD_E_EG + " INTEGER, " +
            FIELD_E_CTS + " INTEGER, " +
            FIELD_E_MC + " INTEGER, " +
            FIELD_E_EP + " INTEGER, " +
            FIELD_E_PI + " INTEGER, " +
            FIELD_E_IC + " INTEGER)";

    /*constantes tabla Optativas*/
    public static final String TABLE_OPTATIVA = "optativa";
    public static final String FIELD_O_ID = "oId";
    public static final String FIELD_O_PAL = "oPal";
    public static final String FIELD_O_MYM = "oMym";
    public static final String FIELD_O_MYP = "oMyp";
    public static final String FIELD_O_POM = "oPom";
    public static final String FIELD_O_TAP = "oTap";
    public static final String FIELD_O_ARU = "oAru";
    public static final String FIELD_O_GYP = "oGyp";
    public static final String FIELD_O_MAT = "oMat";
    public static final String FIELD_O_REA = "oRea";
    public static final String FIELD_O_PRP = "oPrp";

    /*creacion tabla Optativa*/
    public static final String CREATE_TABLE_OPTATIVA = "CREATE TABLE IF NOT EXISTS " +
            TABLE_OPTATIVA + " (" +
            FIELD_O_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            FIELD_O_PAL + " INTEGER, " +
            FIELD_O_MYM + " INTEGER, " +
            FIELD_O_MYP + " INTEGER, " +
            FIELD_O_POM + " INTEGER, " +
            FIELD_O_TAP + " INTEGER, " +
            FIELD_O_ARU + " INTEGER, " +
            FIELD_O_GYP + " INTEGER, " +
            FIELD_O_MAT + " INTEGER, " +
            FIELD_O_REA + " INTEGER, " +
            FIELD_O_PRP + " INTEGER)";
}