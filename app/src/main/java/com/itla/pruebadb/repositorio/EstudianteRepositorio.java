package com.itla.pruebadb.repositorio;

import com.itla.pruebadb.entidades.Estudiante;

public interface EstudianteRepositorio {

   void crear(Estudiante estudiante);
   void actulizar (Estudiante estudiante);
   void borrar ( Estudiante estudiante);
   Estudiante buscar(int id);

}
