package com.cibertec.proyectogrupo4.service;

import com.cibertec.proyectogrupo4.model.Mesa;
import com.cibertec.proyectogrupo4.repository.MesaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MesaServicelmpl implements MesaService {
    private final MesaRepository mesaRepository;

    @Override
    public List<Mesa> listarMesas() {
        return mesaRepository.findAll();
    }

    @Override
    public void guardarMesa(Mesa mesa) {
            mesaRepository.save(mesa);
    }

    @Override
    public Mesa obtenerMesaPorId(Integer id_mesa) {
        return mesaRepository.findById(id_mesa)
                .orElseThrow( () -> new RuntimeException("Mesa no encontrada con el ID"+ id_mesa));
    }

    @Override
    public void eliminarMesa(Integer id_mesa) {
        if(mesaRepository.existsById(id_mesa)){
            mesaRepository.deleteById(id_mesa);
        } else {
            throw new RuntimeException("Mesa no encontrada");
        }
    }

    @Override
    public List<Mesa> listarMesasPorEstado(String estado) {
        return mesaRepository.findMesaByEstado(estado);
    }
}
