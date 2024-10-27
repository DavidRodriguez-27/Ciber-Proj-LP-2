package com.cibertec.proyectogrupo4.service;

import com.cibertec.proyectogrupo4.model.Almacen;

import java.util.List;

public interface AlmacenService {

    List<Almacen> listarAlmacenes();
    void guardarAlmacen(Almacen almacen);
    Object obtenerAlmacenPorId(Integer id);
    void eliminarAlmacen(Integer id);
}
