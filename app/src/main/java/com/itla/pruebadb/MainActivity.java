package com.itla.pruebadb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.itla.pruebadb.entidades.Carrera;
import com.itla.pruebadb.entidades.Estudiante;
import com.itla.pruebadb.repositorio.CarreraRepositorioDbImpl;
import com.itla.pruebadb.repositorio.EstudianteRepositorio;
import com.itla.pruebadb.repositorio.EstudianteRepositorioDbImpl;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EstudianteRepositorio estudianteRepositorio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button2);
        final EditText tvnombre = findViewById(R.id.editText3);
        final EditText tvmatricula = findViewById(R.id.editText4);
        Button button1 = findViewById(R.id.btnaddcarrera);


        CarreraRepositorioDbImpl carrerasimp = new CarreraRepositorioDbImpl(this);
        ArrayList<Carrera> carreras = carrerasimp.buscartodos();
        final ArrayAdapter<Carrera> carreraArrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,carreras);
        carreraArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final Spinner spinner = findViewById(R.id.spcarrera);
        spinner.setAdapter(carreraArrayAdapter);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                estudianteRepositorio = new EstudianteRepositorioDbImpl(v.getContext());
                Carrera carrera = (Carrera) spinner.getSelectedItem();
                Estudiante est2 = new Estudiante();
                est2.setNombre(tvnombre.getText().toString());
                est2.setMatricula(tvmatricula.getText().toString());
                est2.setIdcarrera(carrera.getIdcarrera());
                estudianteRepositorio.crear(est2);

                tvmatricula.setText("");
                tvnombre.setText("");

                Toast.makeText(getApplicationContext(),"Estudiante Guardado",Toast.LENGTH_SHORT).show();
                setResult(1, null);
                finish();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),ListaCarreras.class);
                startActivity(intent);
            }
        });

    }

}
