package com.itla.pruebadb.repositorio;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbConexion extends SQLiteOpenHelper {

    private final static int VERSION =1;
    private final static String NAME_DB= "databaseescuela.db";

    private final static String estudiante = "CREATE TABLE estudiante (id INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT,matricula TEXT,carrera_id INTEGER);";
    private final static String materia = " CREATE TABLE  materia  (    idmateria  INTEGER PRIMARY KEY AUTOINCREMENT,    nombre  TEXT,    creditos  INTEGER  );";
    private final static String carrera = " CREATE TABLE  carrera  (    idcarrera  INTEGER PRIMARY KEY AUTOINCREMENT,    nombre  TEXT  );";
    private final static String carrera_materia = " CREATE TABLE  carrera_materia  (   idcarrera  INTEGER,   idmateria  INTEGER );";


    public DbConexion(@Nullable Context context) {
        super(context, NAME_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(estudiante);
        db.execSQL(materia);
        db.execSQL(carrera);
        db.execSQL(carrera_materia);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
