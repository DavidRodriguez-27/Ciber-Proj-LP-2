package com.cibertec.proyectogrupo4.service;

import com.cibertec.proyectogrupo4.model.Proveedor;
import com.cibertec.proyectogrupo4.repository.ProveedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProveedorServiceImpl implements ProveedorService{

    private final ProveedorRepository proveedorRepository;

    @Override
    public List<Proveedor> listarProveedores() {
        return proveedorRepository.findAll();
    }

    @Override
    public void guardarProveedor(Proveedor proveedor) {
        proveedorRepository.save(proveedor);
    }

    @Override
    public Proveedor obtenerProveedorPorId(Integer id) {
        return proveedorRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Proveedor no encontrado para el id: "+ id));
    }

    @Override
    public void eliminarProveedor(Integer id) {
        if (proveedorRepository.existsById(id)) {
            proveedorRepository.deleteById(id);
        }else {
            throw new RuntimeException("Proveedor no encontrado para el id: "+ id);
        }
    }

    @Override
    public List<Proveedor> listarProveedoresPorCategoriaProductoRuc(String categoriaProducto, String ruc) {
        return proveedorRepository.findProveedorPorCategoriaProductoRuc(categoriaProducto,ruc);
    }
}
