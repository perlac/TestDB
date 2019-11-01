package com.itla.pruebadb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.itla.pruebadb.adaptadores.CarreraAdapter;
import com.itla.pruebadb.entidades.Carrera;
import com.itla.pruebadb.repositorio.CarreraRepositorioDbImpl;

import java.util.ArrayList;

public class ListaCarreras extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private  RecyclerView.LayoutManager layoutManager;
    CarreraRepositorioDbImpl carreraRepositorioDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_carreras);
        Button button = findViewById(R.id.btnnewcarrera);
        carreraRepositorioDb = new CarreraRepositorioDbImpl(this);
        cargarCarrera();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CrearCarrera.class);
                startActivityForResult(intent,1);
            }
        });
    }


    private void cargarCarrera(){
        ArrayList<Carrera> carreras = carreraRepositorioDb.buscartodos();

        recyclerView=findViewById(R.id.listacarreras);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter=new CarreraAdapter(carreras);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        cargarCarrera();
    }

}
