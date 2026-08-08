package org.uam.serviceinventario.controller;

import org.springframework.web.bind.annotation.*;
import org.uam.serviceinventario.dto.DepartamentoDTO;
import org.uam.serviceinventario.service.DepartamentoService;

import java.util.List;

@RestController
@RequestMapping("/departamento")
public class ControllerDepartamento {

    private final DepartamentoService service;

    public ControllerDepartamento(DepartamentoService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<DepartamentoDTO> findAll() {
        return service.findAll();
    }

    @PostMapping("/create")
    public DepartamentoDTO create(@RequestBody DepartamentoDTO dto) {
        return service.save(dto);
    }
}
