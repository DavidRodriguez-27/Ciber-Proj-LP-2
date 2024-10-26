package com.cibertec.proyectogrupo4.service;

import com.cibertec.proyectogrupo4.model.Platos;
import com.cibertec.proyectogrupo4.repository.PlatosRepository;
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

}
