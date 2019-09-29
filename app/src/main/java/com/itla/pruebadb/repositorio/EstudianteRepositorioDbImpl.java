package com.itla.pruebadb.repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.itla.pruebadb.entidades.Estudiante;

public class EstudianteRepositorioDbImpl implements EstudianteRepositorio{

    private DbConexion dbConexion;

    public EstudianteRepositorioDbImpl(Context context) {
        this.dbConexion = new DbConexion(context);
    }

    @Override
    public void crear(Estudiante estudiante) {
        ContentValues cv= new ContentValues();
        cv.put("nombre", estudiante.getNombre());
        cv.put("matricula", estudiante.getMatricula());


        SQLiteDatabase db=  dbConexion.getWritableDatabase();
       long id= db.insert( "estudiante", null, cv);

       if(id<= 0){
           Log.i("EstudianteRepositorio", "Ocurrio un error al salvar o guardar estudiante");
       } else {
           Log.i("EstudianteRepositorio", "el estudiante se a creado id="+id);
       }
    }

    @Override
    public void actulizar(Estudiante estudiante) {

    }

    @Override
    public void borrar(Estudiante estudiante) {

    }

    @Override
    public Estudiante buscar(int id) {
        return null;
    }


}
