package com.cibertec.proyectogrupo4.service;

import com.cibertec.proyectogrupo4.model.Proveedor;

import java.util.List;

public interface ProveedorService {
    List<Proveedor> listarProveedores();
    void guardarProveedor(Proveedor proveedor);
    Proveedor obtenerProveedorPorId(Integer id);
    void eliminarProveedor(Integer id);

    List<Proveedor> listarProveedoresPorCategoriaProductoRuc(String categoriaProducto, String ruc);
}
