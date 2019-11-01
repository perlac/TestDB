package com.itla.pruebadb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.itla.pruebadb.entidades.Materia;
import com.itla.pruebadb.repositorio.CarreraRepositorio;
import com.itla.pruebadb.repositorio.CarreraRepositorioDbImpl;
import com.itla.pruebadb.repositorio.MateriaRepositorio;
import com.itla.pruebadb.repositorio.MateriaRepositorioDbImpl;

public class CrearMateria extends AppCompatActivity {
MateriaRepositorio  materiaRepositorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_materia);

        Button button = findViewById(R.id.btnguardarmateria);
        final EditText etnombremateria = findViewById(R.id.etnombremateria);
        final EditText etcantcredito = findViewById(R.id.etcantcreditos);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                materiaRepositorio = new MateriaRepositorioDbImpl(v.getContext());
                Materia mat = new Materia();
                mat.setNombremateria(etnombremateria.getText().toString());
                mat.setCreditos(Integer.parseInt(etcantcredito.getText().toString()));
                materiaRepositorio.crear(mat);

                etnombremateria.setText("");
                etcantcredito.setText("");

                Toast.makeText(getApplicationContext(),"Materia Guardado",Toast.LENGTH_SHORT).show();
                setResult(1, null);
                finish();

            }
        });
    }




}
