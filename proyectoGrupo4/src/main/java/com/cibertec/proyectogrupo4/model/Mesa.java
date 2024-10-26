package com.cibertec.proyectogrupo4.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_mesas")
@Data
@Getter
@Setter
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_mesa")
    private Integer id_mesa;

    @Column(name="numeroMesa", length = 100, nullable = false)
    private Integer numeroMesa;
    @Column(name="cantPax", length = 100, nullable = false)
    private Integer cantPax;

}
