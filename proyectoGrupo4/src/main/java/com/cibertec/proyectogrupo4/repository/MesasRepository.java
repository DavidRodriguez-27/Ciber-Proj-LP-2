package com.cibertec.proyectogrupo4.repository;

import com.cibertec.proyectogrupo4.model.Mesas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesasRepository extends JpaRepository<Mesas, Integer> {
}
