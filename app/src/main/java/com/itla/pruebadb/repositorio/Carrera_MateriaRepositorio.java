package com.itla.pruebadb.repositorio;


import com.itla.pruebadb.entidades.Carrera_Materia;

public interface Carrera_MateriaRepositorio {

    void crear(Carrera_Materia carrera_materia);
    void borrar ( Carrera_Materia carrera_materia);
    void borrarPorCarrera(Integer idcarrera);

}
