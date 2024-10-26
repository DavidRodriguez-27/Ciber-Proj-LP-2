package com.cibertec.proyectogrupo4.controller;


import com.cibertec.proyectogrupo4.model.Proveedor;
import com.cibertec.proyectogrupo4.service.ProveedorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/proveedores")
@AllArgsConstructor
public class ProveedorController {

    private final ProveedorService proveedorService;

    @GetMapping("/listarProveedores")
    public String verPaginaInicio(Model model) {
        model.addAttribute("listaProveedores", proveedorService.listarProveedores());
        return "proveedores/proveedores";
    }

    @GetMapping("/nuevoProveedor")
    public String nuevoProveedor(Model model) {
        model.addAttribute("proveedor", new Proveedor());
        return "proveedores/nuevoProveedor";
    }

    @PostMapping("/guardarProveedor")
    public String guardarProveedor(@ModelAttribute("proveedor") Proveedor proveedor){
        proveedorService.guardarProveedor(proveedor);
        return "redirect:/proveedores/listarProveedores";
    }

    @GetMapping("/actualizarProveedor/{id}")
    public String actualizarProveedor(@PathVariable("id") Integer id, Model model){
        model.addAttribute("proveedor", proveedorService.obtenerProveedorPorId(id));
        return "proveedores/actualizarProveedor";
    }

    @GetMapping("/eliminarProveedor/{id}")
    public String eliminarProveedor(@PathVariable("id") Integer id){
        proveedorService.eliminarProveedor(id);
        return "redirect:/proveedores/listarProveedores";
    }

    @GetMapping("/buscarProveedor")
    public String buscarProveedor( Model model,
                                      @RequestParam(value="categoriaProducto", required = false) String categoriaProducto,
                                      @RequestParam(value="ruc", required = false)  String ruc){
        List<Proveedor> lista= proveedorService.listarProveedoresPorCategoriaProductoRuc(categoriaProducto, ruc);
        model.addAttribute("listaProveedores", lista);
        model.addAttribute("categoriaProducto", categoriaProducto);
        model.addAttribute("ruc", ruc);
        return "proveedores/proveedores";
    }
}
