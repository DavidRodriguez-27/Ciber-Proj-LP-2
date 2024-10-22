package com.cibertec.proyectogrupo4.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_empleado")
@Data
@Getter
@Setter
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_empleado")
    private Integer id_cliente;

    @Column(name="cargo", length = 50, nullable = false)
    private String cargo;
    @Column(name="nombres", length = 50, nullable = false)
    private String nombres;
    @Column(name="direccion", length = 50, nullable = false)
    private String direccion;
    @Column(name="turno", length = 50, nullable = false)
    private String turno;
    @Column(name="salario", scale = 2, nullable = false)
    private BigDecimal salario;

}
