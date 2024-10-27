package com.cibertec.proyectogrupo4.controller;

import com.cibertec.proyectogrupo4.model.Almacen;
import com.cibertec.proyectogrupo4.service.AlmacenService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/almacenes")
@RequiredArgsConstructor
public class AlmacenController {

    private final AlmacenService almacenService;

    @GetMapping("/listarAlmacenes")
    public String verPaginaInicio(Model model){
        model.addAttribute("listaAlmacenes", almacenService.listarAlmacenes());
        return "almacenes/almacenes";
    }

    @GetMapping("/nuevoAlmacen")
    public String nuevoAlmacen(Model model){
        model.addAttribute("almacen", new Almacen());
        return "almacenes/nuevoAlmacen";
    }

    @PostMapping("/guardarAlmacen")
    public String guardarAlmacen(@ModelAttribute("almacen") Almacen almacen){
        almacenService.guardarAlmacen(almacen);
        return "redirect:/almacenes/listarAlmacenes";
    }

    @GetMapping("/actualizarAlmacen/{id}")
    public String actualizarAlmacen(@PathVariable("id") Integer id, Model model){
        model.addAttribute("almacen", almacenService.obtenerAlmacenPorId(id));
        return "almacenes/actualizarAlmacen";
    }

    @GetMapping("/eliminarAlmacen/{id}")
    public String eliminarAlmacen(@PathVariable("id") Integer id){
        almacenService.eliminarAlmacen(id);
        return "redirect:/almacenes/listarAlmacenes";
    }
}
