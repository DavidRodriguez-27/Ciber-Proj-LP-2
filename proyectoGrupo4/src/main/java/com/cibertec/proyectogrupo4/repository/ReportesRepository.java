package com.cibertec.proyectogrupo4.repository;

import com.cibertec.proyectogrupo4.model.Reportes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportesRepository extends JpaRepository<Reportes, Integer> {
}
