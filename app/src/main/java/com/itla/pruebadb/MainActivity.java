package com.itla.pruebadb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.itla.pruebadb.entidades.Estudiante;
import com.itla.pruebadb.repositorio.EstudianteRepositorio;
import com.itla.pruebadb.repositorio.EstudianteRepositorioDbImpl;

public class MainActivity extends AppCompatActivity {
    EstudianteRepositorio estudianteRepositorio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button2);
        final EditText tvnombre = findViewById(R.id.editText3);
        final EditText tvmatricula = findViewById(R.id.editText4);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                estudianteRepositorio = new EstudianteRepositorioDbImpl(v.getContext());
                Estudiante est2 = new Estudiante();
                est2.setNombre(tvnombre.getText().toString());
                est2.setMatricula(tvmatricula.getText().toString());

                estudianteRepositorio.crear(est2);

                tvmatricula.setText("");
                tvnombre.setText("");
            }
        });

    }

}
