package com.cibertec.proyectogrupo4.model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_proveedor")
@Data
@Getter
@Setter
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_proveedor")
    private Integer id;

    @Column(name = "razonSocial", length = 100, nullable = false)
    private String razonSocial;

    @Column(name = "ruc")
    private String ruc;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "categoriaProducto")
    private String categoriaProducto;

    @Column(name = "formaPago")
    private String formaPago;

}
