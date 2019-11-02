package com.itla.pruebadb.repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.itla.pruebadb.entidades.Materia;

import java.util.ArrayList;

public class MateriaRepositorioDbImpl implements MateriaRepositorio {

    private DbConexion dbConexion;
    public MateriaRepositorioDbImpl (Context context){
        this.dbConexion= new DbConexion(context);
    }
    @Override
    public void crear(Materia materia) {

        ContentValues cv= new ContentValues();
        cv.put("nombre", materia.getNombremateria());
        cv.put("creditos", materia.getCreditos());


        SQLiteDatabase db=  dbConexion.getWritableDatabase();
        long id= db.insert( "materia", null, cv);

        if(id<= 0){
            Log.i("MateriaRepositorio", "Ocurrio un error al salvar o guardar la materia");
        } else {
            Log.i("MateriaRepositorio", "La materia se a creado id="+id);
        }
    }

    @Override
    public void actulizar(Materia materia) {
        ContentValues cv= new ContentValues();
        cv.put("nombre", materia.getNombremateria());
        cv.put("creditos", materia.getCreditos());


        SQLiteDatabase db=  dbConexion.getWritableDatabase();
        long idmateria= db.update( "materia",  cv,"id=?",new String[]{materia.getIdmateria().toString()});
        db.close();
    }

    @Override
    public void borrar(Materia materia) {
        SQLiteDatabase db=  dbConexion.getWritableDatabase();
        long res=db.delete("materia", "id=?",new String[]{materia.getIdmateria().toString()});
        db.close();
    }

    @Override
    public Materia buscar(Integer id) {
        SQLiteDatabase db=  dbConexion.getReadableDatabase();
        Cursor cursor=db.query("materia",null,"id=?",new String[]{id.toString()},null,null,null);

        Materia materia = null;
        while (cursor.moveToNext())
        {
            materia = new Materia();
            materia.setIdmateria(cursor.getInt(cursor.getColumnIndex("idmateria")));
            materia.setNombremateria(cursor.getString(cursor.getColumnIndex("nombre")));
            materia.setCreditos(cursor.getInt(cursor.getColumnIndex("creditos")));
        }

        cursor.close();
        db.close();

        return materia;
    }

    @Override
    public ArrayList<Materia> buscartodos() {
        SQLiteDatabase db=  dbConexion.getReadableDatabase();
        Cursor cursor=db.query("materia",null,null,null,null,null,null,null);
        ArrayList<Materia>materias = new ArrayList<>();

        while (cursor.moveToNext())
        {
            Materia materia = new Materia();
            materia.setIdmateria(cursor.getInt(cursor.getColumnIndex("idmateria")));
            materia.setNombremateria(cursor.getString(cursor.getColumnIndex("nombre")));
            materia.setCreditos(cursor.getInt(cursor.getColumnIndex("creditos")));
            materias.add(materia);
        }

        cursor.close();
        db.close();

        return materias;
    }

    void borrarMaterias (Integer idcarrera){
        SQLiteDatabase db=  dbConexion.getWritableDatabase();
        long res=db.delete("materia", "idcarrera=?",new String[]{idcarrera.toString()});
        db.close();
    }
}
