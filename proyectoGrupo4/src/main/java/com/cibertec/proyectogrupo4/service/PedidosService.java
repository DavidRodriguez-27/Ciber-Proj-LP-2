package com.cibertec.proyectogrupo4.service;

import com.cibertec.proyectogrupo4.model.Pedidos;

import java.util.List;

public interface PedidosService {
    List<Pedidos> listarPedidos();
    void guardarPedido(Pedidos pedido);
    Pedidos obtenerPedido(Integer id);
    void eliminarPedido(Integer id);
}
