package com.example.efinal1_api_pw_p6_da.repository.modelo;

import java.io.Serial;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehiculo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehiculo {

    @Id
    @Column(name = "vehi_id")
    @SequenceGenerator(name = "seq_vehiculo", sequenceName = "seq_vehiculo", allocationSize = 1)
    @GeneratedValue(generator = "seq_vehiculo", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "vehi_placa")
    private String placa;

    @Column(name = "vehi_marca")
    private String marca;

    @Column(name = "vehi_modelo")
    private String modelo;

    @Column(name = "vehi_color")
    private String color;

    @Column(name = "vehi_precio")
    private Double precio;

}
