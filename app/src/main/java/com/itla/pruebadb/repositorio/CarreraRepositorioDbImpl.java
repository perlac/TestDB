package com.itla.pruebadb.repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.itla.pruebadb.entidades.Carrera;

import java.util.ArrayList;

public class CarreraRepositorioDbImpl implements CarreraRepositorio {

    private DbConexion dbConexion;
    public CarreraRepositorioDbImpl(Context context){
        this.dbConexion= new DbConexion(context);
    }
    @Override
    public void crear(Carrera carrera) {
        ContentValues cv= new ContentValues();
        cv.put("nombre",carrera.getNombrecarrera());


        SQLiteDatabase db=  dbConexion.getWritableDatabase();
        long id= db.insert( "carrera", null, cv);

        if(id<= 0){
            Log.i("carrerarepositorio", "Ocurrio un error al salvar o guardar la carrera");
        } else {
            Log.i("carrerarepositorio", "la carrera se a creado id="+id);
        }

    }

    @Override
    public void actulizar(Carrera carrera) {
        ContentValues cv= new ContentValues();
        cv.put("nombre",carrera.getNombrecarrera());


        SQLiteDatabase db=  dbConexion.getWritableDatabase();
        long id= db.update( "carrera",cv,"id=?",new String[]{carrera.getIdcarrera().toString()});


    }

    @Override
    public void borrar(Carrera carrera) {
        SQLiteDatabase db=  dbConexion.getReadableDatabase();
        long res=db.delete("carrera", "id=?",new String[]{carrera.getIdcarrera().toString()});
        db.close();
    }

    @Override
    public Carrera buscar(Integer id) {


        SQLiteDatabase db=  dbConexion.getReadableDatabase();
        Cursor cursor=db.query("carrera",null,"id=?",new String[]{id.toString()},null,null,null);

        Carrera carrera = null;
        while (cursor.moveToNext())
        {
            carrera = new Carrera();
            carrera.setIdcarrera(cursor.getInt(cursor.getColumnIndex("idcarrera")));
            carrera.setNombrecarrera(cursor.getString(cursor.getColumnIndex("nombre")));
        }

        cursor.close();
        db.close();

        return carrera;
    }

    @Override
    public ArrayList<Carrera> buscartodos() {
        SQLiteDatabase db=  dbConexion.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT c.idcarrera, c.nombre, count(m.idmateria) cantmateria, " +
                "sum(m.creditos) cantidadcreditos  from carrera c left join carrera_materia cm  " +
                "on c.idcarrera=cm.idcarrera inner join materia m on m.idmateria=cm.idmateria " +
                "group by c.idcarrera, c.nombre",null);

                //db.query("carrera",null,null,null,null,null,null,null);
        ArrayList<Carrera> carreras = new ArrayList<>();

        while (cursor.moveToNext())
        {
            Carrera carrera = new Carrera();
            carrera.setIdcarrera(cursor.getInt(cursor.getColumnIndex("idcarrera")));
            carrera.setNombrecarrera(cursor.getString(cursor.getColumnIndex("nombre")));
            carrera.setCantcreditos(cursor.getInt(cursor.getColumnIndex("cantidadcreditos")));
            carrera.setCantmateria(cursor.getInt(cursor.getColumnIndex("cantmateria")));

            carreras.add(carrera);
        }

        cursor.close();
        db.close();

        return carreras;
    }

}
