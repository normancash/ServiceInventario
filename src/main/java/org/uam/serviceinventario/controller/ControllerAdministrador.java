package org.uam.serviceinventario.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.uam.serviceinventario.dto.AdministradorDTO;
import org.uam.serviceinventario.dto.AdministradorDTOM;
import org.uam.serviceinventario.model.Administrador;
import org.uam.serviceinventario.service.ServiceAdministrador;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class ControllerAdministrador {

    private final ServiceAdministrador service;

    public ControllerAdministrador(ServiceAdministrador service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<AdministradorDTOM> listarAdministradores(){
        return service.findAll();
    }

    @PostMapping("/create")
    public AdministradorDTO crearAdministrador(@RequestBody @Valid AdministradorDTO administradorDTO){
        return service.save(administradorDTO);
    }

    @PutMapping("/update")
    public AdministradorDTO actualizarAdministrador(@RequestBody AdministradorDTO administradorDTO){
        if (administradorDTO.uuid() == null){
            throw new RuntimeException("No existe el id para actualizar");
        }
        return service.save(administradorDTO);
    }


}
