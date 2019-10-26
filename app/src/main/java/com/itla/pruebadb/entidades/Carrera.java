package com.itla.pruebadb.entidades;

public class Carrera {

    private Integer idcarrera;
    private String nombrecarrera;
    private Integer cantmateria;
    private Integer cantcreditos;

    public Integer getIdcarrera() {
        return idcarrera;
    }

    public void setIdcarrera(Integer idcarrera) {
        this.idcarrera = idcarrera;
    }

    public String getNombrecarrera() {
        return nombrecarrera;
    }

    public void setNombrecarrera(String nombrecarrera) {
        this.nombrecarrera = nombrecarrera;
    }

    public Integer getCantmateria() {
        return cantmateria;
    }

    public void setCantmateria(Integer cantmateria) {
        this.cantmateria = cantmateria;
    }

    public Integer getCantcreditos() {
        return cantcreditos;
    }

    public void setCantcreditos(Integer cantcreditos) {
        this.cantcreditos = cantcreditos;
    }
}
