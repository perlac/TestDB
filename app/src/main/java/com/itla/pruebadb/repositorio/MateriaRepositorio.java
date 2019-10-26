package com.itla.pruebadb.repositorio;

import com.itla.pruebadb.entidades.Materia;

import java.util.ArrayList;

public interface MateriaRepositorio {

    void crear(Materia materia);
    void actulizar (Materia materia);
    void borrar ( Materia materia);
    Materia buscar(Integer id);
    ArrayList<Materia> buscartodos();
}
