package com.cibertec.proyectogrupo4.repository;

import com.cibertec.proyectogrupo4.model.Platos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlatosRepository extends JpaRepository<Platos, Integer> {
}
