package com.itla.pruebadb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.itla.pruebadb.adaptadores.MateriaAdapter;
import com.itla.pruebadb.entidades.Materia;
import com.itla.pruebadb.repositorio.MateriaRepositorioDbImpl;

import java.util.ArrayList;

public class ListaMaterias extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private  RecyclerView.LayoutManager layoutManager;
    MateriaRepositorioDbImpl materiaRepositorioDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_materias);
        materiaRepositorioDb= new MateriaRepositorioDbImpl(this);

        final  Button button = findViewById(R.id.btnnewmateria);
        cargarMateria();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CrearMateria.class);
                startActivityForResult(intent,1);
            }
        });

    }

    private void cargarMateria(){

        ArrayList<Materia> materias = materiaRepositorioDb.buscartodos();

        recyclerView=findViewById(R.id.rvlistamaterias2);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter=new MateriaAdapter(materias);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        cargarMateria();
    }
}
