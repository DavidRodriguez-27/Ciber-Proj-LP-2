package com.cibertec.proyectogrupo4.repository;

import com.cibertec.proyectogrupo4.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
    @Query( value=" SELECT * FROM tb_proveedor p WHERE (:categoriaProducto IS NULL OR p.categoria_producto LIKE %:categoriaProducto%) AND (:ruc IS NULL OR p.ruc LIKE %:ruc%)", nativeQuery = true)
    List<Proveedor> findProveedorPorCategoriaProductoRuc(@Param("categoriaProducto") String categoriaProducto, @Param("ruc") String ruc);
}
