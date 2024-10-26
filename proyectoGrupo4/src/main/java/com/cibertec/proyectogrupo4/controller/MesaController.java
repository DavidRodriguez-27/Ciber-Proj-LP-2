package com.cibertec.proyectogrupo4.controller;

import com.cibertec.proyectogrupo4.model.Mesa;
import com.cibertec.proyectogrupo4.service.MesaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mesas")
@RequiredArgsConstructor
public class MesaController {
    private final MesaService mesaService;

    @GetMapping("/listarMesas")
    public String listarMesas(Model model) {
        model.addAttribute("listarMesas", mesaService.listarMesas());
        return "mesas/mesas";
    }

    @GetMapping("/nuevaMesa")
    public String nuevaMesa(Model model) {
        model.addAttribute("mesa", new Mesa());
        return "mesas/nuevaMesa";
    }

    @PostMapping("/guardarMesa")
    public String guardarMesa(@ModelAttribute("Mesa") Mesa mesa){
        mesaService.guardarMesa(mesa);
        return "redirect:/mesas/listarMesas";
    }

    @GetMapping("/actualizarMesa/{id_mesa}")
    public String actualizarMesa(@PathVariable("id_mesa") Integer id_mesa, Model model) {
        model.addAttribute("mesa", mesaService.obtenerMesaPorId(id_mesa));
        return "mesas/actualizarMesa";
    }

    @GetMapping("/eliminarMesa/{id_mesa}")
    public String eliminarMesa(@PathVariable("id_mesa") Integer id_mesa){
        mesaService.eliminarMesa(id_mesa);
        return "redirect:/mesas/listarMesas";
    }
}
