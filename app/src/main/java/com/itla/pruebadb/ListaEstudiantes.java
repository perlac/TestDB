package com.itla.pruebadb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.itla.pruebadb.adaptadores.EstudianteAdaptador;
import com.itla.pruebadb.entidades.Estudiante;
import com.itla.pruebadb.repositorio.EstudianteRepositorioDbImpl;

import java.util.ArrayList;

public class ListaEstudiantes extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private  RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_estudiantes);

        EstudianteRepositorioDbImpl estudianteRepositorioDb = new EstudianteRepositorioDbImpl(this);
        ArrayList<Estudiante> estudiantes = estudianteRepositorioDb.buscartodos();

        recyclerView=findViewById(R.id.listaestudiante);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter=new EstudianteAdaptador(estudiantes);
        recyclerView.setAdapter(adapter);

    }
}
