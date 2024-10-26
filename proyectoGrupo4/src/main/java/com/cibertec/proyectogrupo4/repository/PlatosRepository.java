package com.cibertec.proyectogrupo4.repository;

import com.cibertec.proyectogrupo4.model.Platos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlatosRepository extends JpaRepository<Platos, Integer> {
    List<Platos> findByDescripcion(String descripcion);
}
