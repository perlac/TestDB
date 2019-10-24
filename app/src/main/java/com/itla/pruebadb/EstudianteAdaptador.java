package com.itla.pruebadb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.itla.pruebadb.entidades.Estudiante;

import java.util.ArrayList;

public class EstudianteAdaptador extends RecyclerView.Adapter <RecyclerView.ViewHolder> {
    private static TextView etnombre, etmatricula;
    private ArrayList<Estudiante> estudiantes;


    public static class MyHolder extends RecyclerView.ViewHolder{
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            etnombre=itemView.findViewById(R.id.tvlistnombre);
            etmatricula=itemView.findViewById(R.id.tvlistmatricula);
        }
    }

    public EstudianteAdaptador(ArrayList<Estudiante>estudiantes) {
        this.estudiantes=estudiantes;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_estudiante,parent,false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Estudiante estudiante = estudiantes.get(position);

        etmatricula.setText(estudiante.getMatricula());
        etnombre.setText(estudiante.getNombre());
    }

    @Override
    public int getItemCount() {
        return estudiantes.size();

    }

}