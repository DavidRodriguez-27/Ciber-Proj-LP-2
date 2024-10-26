package com.cibertec.proyectogrupo4.service;

import com.cibertec.proyectogrupo4.model.Platos;
import com.cibertec.proyectogrupo4.repository.PlatosRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlatosServiceImpl implements PlatosService{

    private final PlatosRepository platosRepository;

    @Override
    public Platos obtenerPlatoPorDescripcion(String descripcion) {
        List<Platos> platos = platosRepository.findByDescripcion(descripcion);
        if (platos != null && !platos.isEmpty()) {
            return platos.get(0); // Retornamos el primer plato encontrada.
        }
        return null; // Si no hay ningun plato con esa descripción, devolvemos null.
    }

    public void guardarPlato(Platos plato) {
        platosRepository.save(plato);
    }
}
