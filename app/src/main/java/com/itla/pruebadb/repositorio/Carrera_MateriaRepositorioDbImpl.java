package com.itla.pruebadb.repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.itla.pruebadb.entidades.Carrera_Materia;

public class Carrera_MateriaRepositorioDbImpl implements Carrera_MateriaRepositorio{

    private DbConexion dbConexion;

    public Carrera_MateriaRepositorioDbImpl(Context context) {
        this.dbConexion = new DbConexion(context);
    }
    @Override
    public void crear(Carrera_Materia carrera_materia) {
        ContentValues cv= new ContentValues();
        cv.put("idcarrera", carrera_materia.getIdcarrera());
        cv.put("idmateria", carrera_materia.getIdmateria());

        SQLiteDatabase db=  dbConexion.getWritableDatabase();
        long id= db.insert( "carrera_materia", null, cv);
        db.close();


    }

    @Override
    public void borrar(Carrera_Materia carrera_materia) {

        SQLiteDatabase db=  dbConexion.getWritableDatabase();
        long res=db.delete("carrera_materia", "idcarrera=? and idmateria=?",new String[]{carrera_materia.getIdcarrera().toString(), carrera_materia.getIdmateria().toString()});
        db.close();
    }

    @Override
    public void borrarPorCarrera(Integer idcarrera) {
        SQLiteDatabase db=  dbConexion.getWritableDatabase();
        long res=db.delete("carrera_materia", "idcarrera=? ",new String[]{idcarrera.toString()});
        db.close();
    }
}
