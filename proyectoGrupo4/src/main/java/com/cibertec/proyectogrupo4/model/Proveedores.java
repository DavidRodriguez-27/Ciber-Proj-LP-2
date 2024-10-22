package com.cibertec.proyectogrupo4.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "tb_proveedores")
@Data
@Getter
@Setter
public class Proveedores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_proveedor")
    private Integer id_proveedor;

    @Column(name="razon_social", length = 50, nullable = false)
    private String razon_social;
    @Column(name="ruc", length = 50, nullable = false)
    private Integer ruc;
    @Column(name="telefono", length = 50, nullable = false)
    private Integer telefono;
    @Column(name="direccion", length = 50, nullable = false)
    private String direccion;
    @Column(name="categoria_producto", scale = 2, nullable = false)
    private String categoria_producto;
    @Column(name="tipo_pago", length = 50, nullable = false)
    private String tipo_pago;

}
