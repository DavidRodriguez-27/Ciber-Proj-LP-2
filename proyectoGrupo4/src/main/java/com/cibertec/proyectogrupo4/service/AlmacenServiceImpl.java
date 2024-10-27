package com.cibertec.proyectogrupo4.service;

import com.cibertec.proyectogrupo4.model.Almacen;
import com.cibertec.proyectogrupo4.repository.AlmacenRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlmacenServiceImpl  implements AlmacenService{

    private final AlmacenRepository almacenRepository;



    @Override
    public List<Almacen> listarAlmacenes() {
        return almacenRepository.findAll();
    }

    @Override
    public void guardarAlmacen(Almacen almacen) {
        almacenRepository.save(almacen);
    }

    @Override
    public Object obtenerAlmacenPorId(Integer id) {
        return almacenRepository.findById(id).orElseThrow(()->new RuntimeException("Almacen no encontrado para el id: "+id));
    }

    @Override
    public void eliminarAlmacen(Integer id) {
        if(almacenRepository.existsById(id)){
            almacenRepository.deleteById(id);
        }else{
            throw new RuntimeException("Almacen no encontrado para el id: "+id);
        }
    }
}
