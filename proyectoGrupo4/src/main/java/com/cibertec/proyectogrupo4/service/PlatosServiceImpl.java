package com.cibertec.proyectogrupo4.service;

import com.cibertec.proyectogrupo4.model.Platos;
import com.cibertec.proyectogrupo4.repository.PlatosRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlatosServiceImpl implements PlatosService {

    private final PlatosRepository platosRepository;

    @Override
    public List<Platos> listarPlatos() {
        return platosRepository.findAll();
    }

    @Override
    @Transactional
    public void guardarPlato(Platos platos) {

        if (platos.getId_plato() == null) {
            platosRepository.save(platos);
        } else {
            platosRepository.findById(platos.getId_plato())
                    .orElseThrow(() -> new RuntimeException("Plato no encontrado para el id: " + platos.getId_plato()));
            platosRepository.save(platos);
        }

    }

}
