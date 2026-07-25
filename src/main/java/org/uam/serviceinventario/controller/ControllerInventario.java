package org.uam.serviceinventario.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.uam.serviceinventario.model.Inventario;
import org.uam.serviceinventario.service.ServiceInventario;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/inventario")
public class ControllerInventario {

    private final ServiceInventario service;


    public ControllerInventario(ServiceInventario service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<Inventario> findAll() {
        return service.findAll();
    }

    @PostMapping("/save")
    public Inventario save(@RequestBody Inventario inventario) {
        return service.save(inventario);
    }

    @PostMapping(value = "/importar",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public List<Inventario> importar(@RequestParam("file") MultipartFile file) throws IOException {
        return service.importar(file);
    }
}
