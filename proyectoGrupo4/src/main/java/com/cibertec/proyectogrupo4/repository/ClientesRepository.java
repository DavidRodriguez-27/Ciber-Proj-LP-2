package com.cibertec.proyectogrupo4.repository;

import com.cibertec.proyectogrupo4.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Integer> {
}
