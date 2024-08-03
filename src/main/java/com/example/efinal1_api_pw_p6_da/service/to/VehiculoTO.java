package com.example.efinal1_api_pw_p6_da.service.to;

import org.springframework.hateoas.RepresentationModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoTO  extends RepresentationModel<VehiculoTO>{

     private Integer id;

    private String placa;

    private String marca;

    private String modelo;

    private String color;

    private Double precio;
    
}
