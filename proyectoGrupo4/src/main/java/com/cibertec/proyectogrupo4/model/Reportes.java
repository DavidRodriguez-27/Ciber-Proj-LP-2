package com.cibertec.proyectogrupo4.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "tb_reportes")
@Data
@Getter
@Setter
public class Reportes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_reporte")
    private Integer id_reporte;

    @Column(name="tipo_reporte", length = 50, nullable = false)
    private String tipo_reporte;
    @Column(name="fecha_reporte", nullable = false)
    @Temporal(value=TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_reporte;

}
