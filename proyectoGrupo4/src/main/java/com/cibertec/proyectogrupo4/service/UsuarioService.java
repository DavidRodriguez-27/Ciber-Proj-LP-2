package com.cibertec.proyectogrupo4.service;

import com.cibertec.proyectogrupo4.model.Usuario;

public interface UsuarioService {
    Usuario obtenerUsuario(String nombreUsuario, String contrasena);
}
