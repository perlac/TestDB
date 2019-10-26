package com.itla.pruebadb.repositorio;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbConexion extends SQLiteOpenHelper {

    private final static int VERSION =1;
    private final static String NAME_DB= "escuela.db";

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
//
//        db.execSQL("INSERT into estudiante (nombre, matricula, carrera_id) values ('juan perez', 'mat0001',1)");
//        db.execSQL("INSERT into estudiante (nombre, matricula, carrera_id) values ('maria diaz', 'mat0002',2) ");
//        db.execSQL(" INSERT into estudiante (nombre, matricula, carrera_id) values ('pepe lopez', 'mat0003',1)");
//        db.execSQL("INSERT into carrera (nombre) VALUES ('Ing. en Sistemas'); INSERT into carrera (nombre) VALUES ('Mercadeo')");
//        db.execSQL("INSERT into carrera (nombre) VALUES ('Contabilidad')");
//        db.execSQL("INSERT into materia (nombre, creditos) VALUES ('Matematica 1', 2)");
//        db.execSQL("INSERT into materia (nombre, creditos) VALUES ('Espanol 1',5)");
//        db.execSQL("INSERT into materia (nombre, creditos) VALUES ('Ingles 1', 3) ");
//        db.execSQL("INSERT into materia (nombre, creditos) VALUES ('Metodologia de la Investigacion', 2)");
//        db.execSQL("INSERT into materia (nombre, creditos) VALUES ('Relaciones Humanas', 3)");
//        db.execSQL("INSERT into carrera_materia (idcarrera,idmateria) VALUES (1,1)");
//        db.execSQL("INSERT into carrera_materia (idcarrera,idmateria) VALUES (1,2)");
//        db.execSQL("INSERT into carrera_materia (idcarrera,idmateria) VALUES (1,3)");
//        db.execSQL("INSERT into carrera_materia (idcarrera,idmateria) VALUES (2,2)");
//        db.execSQL("INSERT into carrera_materia (idcarrera,idmateria) VALUES (2,4) ");
//        db.execSQL("INSERT into carrera_materia (idcarrera,idmateria) VALUES (3,1)");
//        db.execSQL("INSERT into carrera_materia (idcarrera,idmateria) VALUES (3,5) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
