package com.example.efinal1_api_pw_p6_da.repository;

import java.util.List;

import com.example.efinal1_api_pw_p6_da.repository.modelo.Vehiculo;

public interface IVehiculoRepository {

    void insertar(Vehiculo vehiculo);

    Vehiculo seleccionarPorPlaca(String placa);

    List<Vehiculo> seleccionarTodos();

    void eliminar(Integer id);
    
}
