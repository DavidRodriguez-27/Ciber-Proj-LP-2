package com.cibertec.proyectogrupo4.service;

import com.cibertec.proyectogrupo4.model.Clientes;
import com.cibertec.proyectogrupo4.repository.ClientesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ClientesServiceImpl implements ClientesService {

    private final ClientesRepository clientesRepository;
    @Override
    public List<Clientes> listarClientes() {
       return clientesRepository.findAll();
    }

    @Override
    public void guardarCliente(Clientes cliente) {
    clientesRepository.save(cliente);
    }

    @Override
    public Clientes obtenerClientePorId(int id) {
        return clientesRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No existe el cliente con id: " + id));
    }

    @Override
    public void eliminarCliente(int id) {
        if (clientesRepository.existsById(id)) {
            clientesRepository.deleteById(id);
        }else {
            throw new RuntimeException("No existe el cliente con id: " + id);
        }
    }
}
