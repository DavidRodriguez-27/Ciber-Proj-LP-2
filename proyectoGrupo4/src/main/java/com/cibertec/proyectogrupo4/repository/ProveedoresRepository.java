package com.cibertec.proyectogrupo4.repository;

import com.cibertec.proyectogrupo4.model.Proveedores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedoresRepository extends JpaRepository<Proveedores, Integer> {
}
