package com.cibertec.proyectogrupo4.service;

import com.cibertec.proyectogrupo4.model.Platos;

import java.util.List;

public interface PlatosService {
    void guardarPlato(Platos plato);
    Platos obtenerPlatoPorNombre(String nombre_plato);
}
