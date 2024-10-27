package com.cibertec.proyectogrupo4.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "tb_almacen")
@Data
@Getter
@Setter
public class Almacen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_almacen")
    private Integer id;

    @Column(name="descripcion", length = 50, nullable = false)
    private String descripcion;
    @Column(name="cantidad", nullable = false)
    private String cantidad;
    @Column(name="Proveedor", length = 50, nullable = false)
    private Integer proveedor;

    @Column(name="fecha_ingreso", nullable = false)
    @Temporal(value=TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaIngreso;


    @Column(name="precio", scale = 2, nullable = false)
    private BigDecimal precio;


}
