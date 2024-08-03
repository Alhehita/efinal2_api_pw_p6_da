package com.example.efinal1_api_pw_p6_da.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.efinal1_api_pw_p6_da.repository.IVehiculoRepository;
import com.example.efinal1_api_pw_p6_da.repository.modelo.Vehiculo;
import com.example.efinal1_api_pw_p6_da.service.to.VehiculoTO;

@Service
public class VehiculoServiceImpl implements IVehiculoService{

    @Autowired
    private IVehiculoRepository vehiculoRepository;

    @Override
    public void guardar(VehiculoTO vehiculoTO) {
        this.vehiculoRepository.insertar(this.convertirTO(vehiculoTO));
    }

    @Override
    public VehiculoTO buscarPorPlaca(String placa) {
        
        return this.convertir(this.vehiculoRepository.seleccionarPorPlaca(placa));
    }

    @Override
    public List<VehiculoTO> buscarTodos() {

        return this.convertirListaTO(this.vehiculoRepository.seleccionarTodos());
    }

    private VehiculoTO convertir(Vehiculo vehiculo){
        if(vehiculo == null){
            return null;
        }
        return new VehiculoTO(
            vehiculo.getId(),
            vehiculo.getPlaca(),
            vehiculo.getMarca(),
            vehiculo.getModelo(),
            vehiculo.getColor(),
            vehiculo.getPrecio()
        );
    }

    private Vehiculo convertirTO(VehiculoTO vehiculoTO){
        Vehiculo vehiculo = new Vehiculo();

        vehiculoTO.setId(vehiculo.getId());
        vehiculoTO.setPlaca(vehiculo.getPlaca());
        vehiculoTO.setMarca(vehiculo.getMarca());
        vehiculoTO.setModelo(vehiculo.getModelo());
        vehiculoTO.setColor(vehiculo.getColor());
        vehiculoTO.setPrecio(vehiculo.getPrecio());

        return vehiculo;
    }

    private List<VehiculoTO> convertirListaTO(List<Vehiculo> vehiculos) {
        List<VehiculoTO> vehiculoTOs = new ArrayList<>();
        for (Vehiculo vehiculo : vehiculos) {
            vehiculoTOs.add(convertir(vehiculo));
        }
        return vehiculoTOs;
    }

    @Override
    public void borrar(Integer id) {
        this.vehiculoRepository.eliminar(id);
    }


    
}
