package com.cibertec.proyectogrupo4.controller;

import com.cibertec.proyectogrupo4.model.Pedidos;
import com.cibertec.proyectogrupo4.model.Platos;
import com.cibertec.proyectogrupo4.service.PedidosService;
import com.cibertec.proyectogrupo4.service.PlatosService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pedidos")
@AllArgsConstructor
public class PedidosController {

    private final PedidosService pedidosService;
    private final PlatosService platosService;

    @GetMapping("/listarPedidos")
    public String verPaginaInicio(Model model){
        model.addAttribute("listaPedidos", pedidosService.listarPedidos());
        return "pedidos/pedidos";
    }

    @GetMapping("/nuevoPedido")
    public String nuevoPedido(Model model){
        model.addAttribute("pedido", new Pedidos());
        return "pedidos/nuevoPedido";
    }

    @PostMapping("/guardarPedido")
    public String guardarPedido(@ModelAttribute("pedido") Pedidos pedido){

        String descripcionPlato = pedido.getPlato().getDescripcion();
        Platos platoExistente = platosService.obtenerPlatoPorDescripcion(descripcionPlato);

        if (platoExistente != null) {
            pedido.setPlato(platoExistente);
        } else {
            Platos nuevoPlato = new Platos();
            nuevoPlato.setDescripcion(descripcionPlato);
            platosService.guardarPlato(nuevoPlato);
            pedido.setPlato(nuevoPlato);
        }
        pedidosService.guardarPedido(pedido);
        return "redirect:/pedidos/listarPedidos";
    }

    @GetMapping("/actualizarPedido/{id}")
    public String actualizarPedido(@PathVariable("id") Integer id, Model model){
        model.addAttribute("pedido", pedidosService.obtenerPedido(id));
        return "pedidos/actualizarPedido";
    }

    @GetMapping("/eliminarPedido/{id}")
    public String elimarPedido(@PathVariable("id") Integer id){
        pedidosService.eliminarPedido(id);
        return "redirect:/pedidos/listarPedidos";
    }

}
