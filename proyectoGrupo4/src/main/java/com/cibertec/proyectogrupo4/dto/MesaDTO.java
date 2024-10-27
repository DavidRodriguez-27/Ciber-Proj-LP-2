package com.cibertec.proyectogrupo4.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class MesaDTO {
    private Integer id_mesa;
    private Integer numeroMesa;
    private Integer cantPax;
    private String estado;
}
