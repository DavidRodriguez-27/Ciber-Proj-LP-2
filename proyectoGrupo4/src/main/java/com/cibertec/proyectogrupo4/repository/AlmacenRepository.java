package com.cibertec.proyectogrupo4.repository;

import com.cibertec.proyectogrupo4.model.Almacen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlmacenRepository extends JpaRepository<Almacen, Integer> {
}
