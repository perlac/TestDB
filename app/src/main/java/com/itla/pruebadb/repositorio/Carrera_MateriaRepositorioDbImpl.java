package com.itla.pruebadb.repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.itla.pruebadb.entidades.Carrera_Materia;

public class Carrera_MateriaRepositorioDbImpl implements Carrera_MateriaRepositorio{

    private DbConexion dbConexion;

    public Carrera_MateriaRepositorioDbImpl(Context context) {
        this.dbConexion = new DbConexion(context);
    }
    @Override
    public void crear(Carrera_Materia carrera_materia) {
        ContentValues cv= new ContentValues();
        cv.put("carrera_id", carrera_materia.getIdcarrera());
        cv.put("materia_id", carrera_materia.getIdmateria());

        SQLiteDatabase db=  dbConexion.getWritableDatabase();
        long id= db.insert( "carrera_materia", null, cv);
        db.close();


    }

    @Override
    public void borrar(Carrera_Materia carrera_materia) {

        SQLiteDatabase db=  dbConexion.getReadableDatabase();
        long res=db.delete("carrera_materia", "carrera_id=? and materia_id=?",new String[]{carrera_materia.getIdcarrera().toString(), carrera_materia.getIdmateria().toString()});
        db.close();
    }

    @Override
    public void borrarPorCarrera(Integer idcarrera) {
        SQLiteDatabase db=  dbConexion.getReadableDatabase();
        long res=db.delete("carrera_materia", "carrera_id=? ",new String[]{idcarrera.toString()});
        db.close();
    }
}
