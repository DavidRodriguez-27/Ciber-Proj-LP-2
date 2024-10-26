package com.cibertec.proyectogrupo4.repository;

import com.cibertec.proyectogrupo4.model.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Integer> {
}
