package com.cibertec.proyectogrupo4.controller;

import com.cibertec.proyectogrupo4.model.Platos;
import com.cibertec.proyectogrupo4.service.PlatosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/platos")
@RequiredArgsConstructor
public class PlatosController {

    private final PlatosService platosService;

    @GetMapping("/platos")
    public String verPaginaPlatos(Model model){
        model.addAttribute("listaPlatos", platosService.listarPlatos());
        return "platos/platos";
    }

    @GetMapping("/nuevoPlato")
    public String nuevoPlato(Model model){
        model.addAttribute("platos", new Platos());
        return "platos/nuevoPlato";
    }

    @PostMapping("/guardarPlato")
    public String guardarPlato(@ModelAttribute("platos") Platos plato){
        platosService.guardarPlato(plato);
        return "redirect:/platos/platos";
    }



}

