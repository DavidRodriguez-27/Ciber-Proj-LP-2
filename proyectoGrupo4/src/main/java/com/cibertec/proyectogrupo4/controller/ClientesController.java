package com.cibertec.proyectogrupo4.controller;

import com.cibertec.proyectogrupo4.model.Clientes;
import com.cibertec.proyectogrupo4.service.ClientesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClientesController {
    private final ClientesService clientesService;
    @GetMapping("/listarClientes")
    public String verPaginaInicio(Model model) {
        model.addAttribute("listaClientes", clientesService.listarClientes());
        return "clientes/clientes";
    }

    @GetMapping("/nuevoCliente")
    public String nuevoCliente(Model model) {
        model.addAttribute("cliente", new Clientes());
        return "clientes/nuevoCliente";
    }

    @PostMapping("/guardarCliente")
    public String guardarCliente(@ModelAttribute("cliente") Clientes cliente) {
        clientesService.guardarCliente(cliente);
        return "redirect:/clientes/listarClientes";
    }

    @GetMapping("/actualizaCliente/{id}")
    public String actualizarCliente(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("cliente", clientesService.obtenerClientePorId(id));
        return "clientes/actualizaCliente";
    }

    @GetMapping("/eliminarCliente/{id}")
    public String eliminarCliente(@PathVariable("id") Integer id) {
        clientesService.eliminarCliente(id);
        return "redirect:/clientes/listarClientes";
    }


}
