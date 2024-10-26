package com.cibertec.proyectogrupo4.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tb_usuario")
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_usuario")
    private Integer id;

    @Column(name = "nombre_usuario", length = 50, nullable = false)
    private String nombreUsuario;

    @Column(name = "contrasena", length = 50, nullable = false)
    private String contrasena;

    @Column(name = "estado", columnDefinition = "int(1) default 1")
    private Integer estado;

}
