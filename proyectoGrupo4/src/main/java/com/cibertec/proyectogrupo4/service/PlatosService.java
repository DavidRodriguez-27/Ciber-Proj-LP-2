package com.cibertec.proyectogrupo4.service;

import com.cibertec.proyectogrupo4.model.Platos;

import java.util.List;

public interface PlatosService {
    List<Platos> listarPlatos();
    void guardarPlato(Platos plato);
    Platos obtenerPlatosPorId(Integer id);

}
