package com.itla.pruebadb.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.itla.pruebadb.R;
import com.itla.pruebadb.entidades.Estudiante;
import com.itla.pruebadb.entidades.Materia;

import java.util.ArrayList;

public class MateriaAdapter extends RecyclerView.Adapter <RecyclerView.ViewHolder> {

    private static TextView tvnombre, tvcreditos;
    private ArrayList<Materia> materias;


    public static class MyHolder extends RecyclerView.ViewHolder{
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tvnombre=itemView.findViewById(R.id.tvlistnombremateria);
            tvcreditos=itemView.findViewById(R.id.tvlistcantcreditos);

        }
    }

    public MateriaAdapter(ArrayList<Materia>materias) {
        this.materias=materias;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_materia,parent,false);
        MateriaAdapter.MyHolder myHolder = new MateriaAdapter.MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Materia materia = materias.get(position);

        tvnombre.setText(materia.getNombremateria());
        tvcreditos.setText("Cantidad Creditos : "+materia.getCreditos().toString());

    }

    @Override
    public int getItemCount() {
        return materias.size();

    }
}
