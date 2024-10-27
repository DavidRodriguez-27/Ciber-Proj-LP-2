package com.cibertec.proyectogrupo4.service;

import com.cibertec.proyectogrupo4.model.Clientes;

import java.util.List;

public interface ClientesService {
    List<Clientes> listarClientes();
    void guardarCliente(Clientes cliente);
    Clientes obtenerClientePorId(int id);
    void eliminarCliente(int id);
}
