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
    public Platos obtenerPlatoPorNombre(String nombre_plato) {
        List<Platos> platos = platosRepository.findByNombre_plato(nombre_plato);
        if (platos != null && !platos.isEmpty()) {
            return platos.get(0); // Retornamos el primer plato encontrado.
        }
        return null; // Si no hay ningun plato con ese nombre, devolvemos null.
    }

    public void guardarPlato(Platos plato) {
        platosRepository.save(plato);
    }
}
