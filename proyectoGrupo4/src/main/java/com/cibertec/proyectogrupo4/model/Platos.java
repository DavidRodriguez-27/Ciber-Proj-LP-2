package com.cibertec.proyectogrupo4.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "tb_platos")
@Data
@Getter
@Setter
public class Platos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_plato")
    private Integer id_plato;

    @Column(name="nombre_plato", length = 50, nullable = false)
    private String nombre_plato;
    @Column(name="descripcion", length = 50, nullable = false)
    private String descripcion;
    @Column(name="categoria", length = 50, nullable = false)
    private String categoria;
    @Column(name="precio", scale = 2, nullable = false)
    private BigDecimal precio;
    @Column(name="disponibilidad", length = 50, nullable = false)
    private String disponibilidad;


}
