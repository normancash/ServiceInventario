package org.uam.serviceinventario.controller;

import org.springframework.web.bind.annotation.*;
import org.uam.serviceinventario.dto.MunicipioDTO;
import org.uam.serviceinventario.service.MunicipioService;

import java.util.List;

@RestController
@RequestMapping("/municipio")
public class ControllerMunicipio {

    private final MunicipioService service;

    public ControllerMunicipio(MunicipioService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<MunicipioDTO> listar(){
        return service.findAll();
    }

    @PostMapping("/save")
    public MunicipioDTO save(@RequestBody MunicipioDTO dto){
        return service.save(dto);
    }
}
