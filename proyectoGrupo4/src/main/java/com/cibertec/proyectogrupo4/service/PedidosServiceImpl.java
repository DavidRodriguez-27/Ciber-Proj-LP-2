package com.cibertec.proyectogrupo4.service;

import com.cibertec.proyectogrupo4.model.Pedidos;
import com.cibertec.proyectogrupo4.repository.PedidosRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PedidosServiceImpl implements PedidosService{

    private final PedidosRepository pedidosRepository;

    @Override
    public List<Pedidos> listarPedidos() { return pedidosRepository.findAll(); }

    @Override
    public void guardarPedido(Pedidos pedido) { pedidosRepository.save(pedido); }

    @Override
    public Pedidos obtenerPedido(Integer id) {
        return pedidosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado por el id: " + id));
    }

    @Override
    public void eliminarPedido(Integer id) {
        if (pedidosRepository.existsById(id)) {
            pedidosRepository.deleteById(id);
        } else {
            throw new RuntimeException("Pedido no encontrado por el id: " + id);
        }
    }
}
