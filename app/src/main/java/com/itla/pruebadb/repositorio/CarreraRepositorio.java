package com.itla.pruebadb.repositorio;

import com.itla.pruebadb.entidades.Carrera;


import java.util.ArrayList;

public interface CarreraRepositorio {
    void crear(Carrera carrera);
    void actulizar (Carrera carrera);
    void borrar ( Carrera carrera);
    Carrera buscar(Integer id);
    ArrayList<Carrera> buscartodos();

}
