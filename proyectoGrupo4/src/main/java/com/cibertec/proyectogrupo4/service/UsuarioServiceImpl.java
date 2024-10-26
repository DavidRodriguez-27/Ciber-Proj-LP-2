package com.cibertec.proyectogrupo4.service;

import com.cibertec.proyectogrupo4.model.Usuario;
import com.cibertec.proyectogrupo4.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService{
    private final UsuarioRepository usuarioRepository;
    @Override
    public Usuario obtenerUsuario(String nombreUsuario, String contrasena) {
        return usuarioRepository.findByNombreUsuarioAndContrasena(nombreUsuario, contrasena);
    }
}
