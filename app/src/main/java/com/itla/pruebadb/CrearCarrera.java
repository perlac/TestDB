package com.itla.pruebadb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.itla.pruebadb.adaptadores.EstudianteAdaptador;
import com.itla.pruebadb.adaptadores.MateriaAdapter;
import com.itla.pruebadb.entidades.Carrera;
import com.itla.pruebadb.entidades.Materia;
import com.itla.pruebadb.repositorio.CarreraRepositorio;
import com.itla.pruebadb.repositorio.CarreraRepositorioDbImpl;
import com.itla.pruebadb.repositorio.Carrera_MateriaRepositorioDbImpl;
import com.itla.pruebadb.repositorio.MateriaRepositorioDbImpl;

import java.util.ArrayList;

public class CrearCarrera extends AppCompatActivity {
    CarreraRepositorio carreraRepositorio;
    private  EditText etnombrecarrera;
    private Spinner spinner;
    ArrayList<Materia> materias;
    ArrayList<Materia> rcmaterias;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private  RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_carrera);
        Button btagregar = findViewById(R.id.btncrearmateria);
        Button btguardar = findViewById(R.id.btnguardarcarrera);
        Button button = findViewById(R.id.btnaddmateria);
        etnombrecarrera = findViewById(R.id.etnombrecarrera);
        spinner = findViewById(R.id.spmaterias);
        rcmaterias= new ArrayList<>();
        MateriaRepositorioDbImpl materiasimp = new MateriaRepositorioDbImpl(getApplicationContext());
        materias = materiasimp.buscartodos();
        final ArrayAdapter<Materia> materiaArrayAdapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_spinner_item,materias);
        materiaArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(materiaArrayAdapter);



        recyclerView=findViewById(R.id.rvlistamaterias);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new MateriaAdapter(rcmaterias);
        recyclerView.setAdapter(adapter);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ListaMaterias.class);
                startActivity(intent);
            }
        });

        btguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carreraRepositorio= new CarreraRepositorioDbImpl(v.getContext());
                Materia materia = (Materia) spinner.getSelectedItem();
                Carrera car1 = new Carrera();
                car1.setNombrecarrera(etnombrecarrera.getText().toString());
                carreraRepositorio.crear(car1);
                Carrera_MateriaRepositorioDbImpl carreraMateriaRepositorioDb = new Carrera_MateriaRepositorioDbImpl(getApplicationContext());
                etnombrecarrera.setText("");

                Toast.makeText(getApplicationContext(),"Carrera Guardado",Toast.LENGTH_SHORT).show();
                setResult(1, null);
                finish();
            }
        });

        btagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Materia materia = (Materia) spinner.getSelectedItem();
                rcmaterias.add(materia);

                adapter.notifyDataSetChanged();
            }
        });
    }
}
