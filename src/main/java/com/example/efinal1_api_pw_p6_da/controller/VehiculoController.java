package com.example.efinal1_api_pw_p6_da.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.efinal1_api_pw_p6_da.service.IVehiculoService;
import com.example.efinal1_api_pw_p6_da.service.to.VehiculoTO;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("vehiculos")
@CrossOrigin
public class VehiculoController {

    @Autowired
    private IVehiculoService vehiculoService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VehiculoTO> guardar(@RequestBody VehiculoTO vehiculoTO) {

        this.vehiculoService.guardar(vehiculoTO);

        return ResponseEntity.status(201).body(vehiculoTO);

    }

    @DeleteMapping(path="/{id}",produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> borrar(@RequestParam Integer id){
        this.vehiculoService.borrar(id);
        String msj = "Eliminado";
        return ResponseEntity.ok(msj);
    }

    @GetMapping(path = "/{placa}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VehiculoTO> buscarPorPlaca(@RequestParam String placa) {
        VehiculoTO vehiculoTO = this.vehiculoService.buscarPorPlaca(placa);

        return ResponseEntity.ok(vehiculoTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<VehiculoTO> obtenerVehiculos() {
        List<VehiculoTO> vehiculoTOs = vehiculoService.buscarTodos();
        for (VehiculoTO vehiculoTO : vehiculoTOs) {
            Link link = linkTo(methodOn(VehiculoController.class).buscarPorPlaca(vehiculoTO.getPlaca()))
                    .withRel("Vehiculos");

            vehiculoTO.add(link);
        }

        return vehiculoTOs;
    }

    

}
