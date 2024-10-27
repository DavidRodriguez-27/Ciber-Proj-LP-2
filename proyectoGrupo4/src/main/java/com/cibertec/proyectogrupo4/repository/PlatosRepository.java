package com.cibertec.proyectogrupo4.repository;

import com.cibertec.proyectogrupo4.model.Platos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlatosRepository extends JpaRepository<Platos, Integer> {
    @Query("SELECT p FROM Platos p WHERE p.nombre_plato = :nombre_plato")
    List<Platos> findByNombre_plato(@Param("nombre_plato") String nombre_plato);

}
