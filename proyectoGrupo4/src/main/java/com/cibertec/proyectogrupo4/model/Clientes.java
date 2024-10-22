package com.cibertec.proyectogrupo4.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_clientes")
@Data
@Getter
@Setter
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cliente")
    private Integer id_cliente;

    @Column(name="nombres", length = 50, nullable = false)
    private String nombres;
    @Column(name="telefono", length = 50, nullable = false)
    private String telefono;
    @Column(name="dni", length = 50, nullable = false)
    private Integer dni;

}
