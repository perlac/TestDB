package com.itla.pruebadb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.itla.pruebadb.adaptadores.EstudianteAdaptador;
import com.itla.pruebadb.entidades.Estudiante;
import com.itla.pruebadb.repositorio.EstudianteRepositorioDbImpl;

import java.util.ArrayList;

public class ListaEstudiantes extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private  RecyclerView.LayoutManager layoutManager;
    EstudianteRepositorioDbImpl estudianteRepositorioDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_estudiantes);
        estudianteRepositorioDb   = new EstudianteRepositorioDbImpl(this);
        cargarEstudiantes();


        final Button btnnewestudinate = findViewById(R.id.btnewest);
        btnnewestudinate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                //startActivity(intent);
                startActivityForResult(intent,1);
            }
        });
    }

    private void cargarEstudiantes(){
        ArrayList<Estudiante> estudiantes = estudianteRepositorioDb.buscartodos();

        recyclerView=findViewById(R.id.listaestudiante);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter=new EstudianteAdaptador(estudiantes);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        cargarEstudiantes();
    }
}
