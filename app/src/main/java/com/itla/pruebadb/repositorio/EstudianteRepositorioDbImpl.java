package com.itla.pruebadb.repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.itla.pruebadb.entidades.Estudiante;

import java.util.ArrayList;
import java.util.List;

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
        cv.put("carrera_id", estudiante.getIdcarrera());

        SQLiteDatabase db=  dbConexion.getWritableDatabase();
        long id= db.insert( "estudiante", null, cv);
        db.close();
        if(id<= 0){
            Log.i("EstudianteRepositorio", "Ocurrio un error al salvar o guardar estudiante");
        } else {
            Log.i("EstudianteRepositorio", "el estudiante se a creado id="+id);
        }
    }

    @Override
    public void actulizar(Estudiante estudiante) {
        ContentValues cv= new ContentValues();
        cv.put("nombre", estudiante.getNombre());
        cv.put("matricula", estudiante.getMatricula());
        cv.put("carrera_id", estudiante.getIdcarrera());

        SQLiteDatabase db=  dbConexion.getWritableDatabase();
        long id= db.update( "estudiante",  cv,"id=?",new String[]{estudiante.getId().toString()});
        db.close();
    }

    @Override
    public void borrar(Estudiante estudiante) {
        SQLiteDatabase db=  dbConexion.getReadableDatabase();
        long res=db.delete("estudiante", "id=?",new String[]{estudiante.getId().toString()});
        db.close();
    }

    @Override
    public Estudiante buscar(Integer id) {

        SQLiteDatabase db=  dbConexion.getReadableDatabase();
        Cursor cursor=db.query("estudiante",null,"id=?",new String[]{id.toString()},null,null,null);

        Estudiante estudiante = null;
        while (cursor.moveToNext())
        {
            estudiante = new Estudiante();
            estudiante.setId(cursor.getInt(cursor.getColumnIndex("id")));
            estudiante.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
            estudiante.setMatricula(cursor.getString(cursor.getColumnIndex("matricula")));
            estudiante.setIdcarrera(cursor.getInt(cursor.getColumnIndex("carrera_id")));

        }

        cursor.close();
        db.close();

        return estudiante;
    }

    @Override
    public ArrayList<Estudiante> buscartodos() {
        SQLiteDatabase db=  dbConexion.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT e.id,e.nombre,e.matricula,e.carrera_id,c.nombre nombrecarrera FROM estudiante e left join carrera c on e.carrera_id=c.idcarrera",null);

                //db.query("estudiante",null,null,null,null,null,null,null);
        ArrayList<Estudiante>estudiantes = new ArrayList<>();

        while (cursor.moveToNext())
        {
            Estudiante estudiante = new Estudiante();
            estudiante.setId(cursor.getInt(cursor.getColumnIndex("id")));
            estudiante.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
            estudiante.setMatricula(cursor.getString(cursor.getColumnIndex("matricula")));
            estudiante.setIdcarrera(cursor.getInt(cursor.getColumnIndex("carrera_id")));
            estudiante.setNombreCarrera(cursor.getString(cursor.getColumnIndex("nombrecarrera")));
            estudiantes.add(estudiante);
        }

        cursor.close();
        db.close();

        return estudiantes;

    }
}
