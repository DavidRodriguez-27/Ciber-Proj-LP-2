package com.cibertec.proyectogrupo4.service;

import com.cibertec.proyectogrupo4.model.Mesa;

import java.util.List;

public interface MesaService {
    List<Mesa> listarMesas();
    void guardarMesa(Mesa mesa);
    Mesa obtenerMesaPorId(Integer id_mesa);
    void eliminarMesa(Integer id_mesa);
}
