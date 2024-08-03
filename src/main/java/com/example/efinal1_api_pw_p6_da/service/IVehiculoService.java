package com.example.efinal1_api_pw_p6_da.service;

import java.util.List;

import com.example.efinal1_api_pw_p6_da.service.to.VehiculoTO;


public interface IVehiculoService {

    void guardar(VehiculoTO vehiculoTO);

    VehiculoTO buscarPorPlaca(String placa);

    List<VehiculoTO> buscarTodos();

    void borrar(Integer id);
    
}
