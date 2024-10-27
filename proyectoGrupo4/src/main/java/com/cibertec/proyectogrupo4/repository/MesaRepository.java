package com.cibertec.proyectogrupo4.repository;

import com.cibertec.proyectogrupo4.model.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MesaRepository extends JpaRepository<Mesa, Integer> {
    List<Mesa> findMesaByEstado(String estado);
}
