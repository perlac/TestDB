package com.itla.pruebadb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.itla.pruebadb.entidades.Estudiante;
import com.itla.pruebadb.repositorio.EstudianteRepositorio;
import com.itla.pruebadb.repositorio.EstudianteRepositorioDbImpl;

public class MainActivity extends AppCompatActivity {
    EstudianteRepositorio estudianteRepositorio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        estudianteRepositorio = new EstudianteRepositorioDbImpl(this.getBaseContext());
        Estudiante estl = new Estudiante();
        estl.setNombre("Juan Perez");
        estl.setMatricula("Mat01");

        estudianteRepositorio.crear(estl);

        estudianteRepositorio = new EstudianteRepositorioDbImpl(this.getBaseContext());
        Estudiante est2 = new Estudiante();
        est2.setNombre("Marta Heredia");
        est2.setMatricula("Mat02");

        estudianteRepositorio.crear(est2);
    }

}
