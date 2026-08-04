package org.uam.serviceinventario.controller;

import org.springframework.web.bind.annotation.*;
import org.uam.serviceinventario.dto.ProductoDTO;
import org.uam.serviceinventario.service.ServiceProducto;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ControllerProducto {

    private final ServiceProducto service;

    public ControllerProducto(ServiceProducto service) {
        this.service = service;
    }


    @GetMapping("/all")
    public List<ProductoDTO> getAllProductos() {
        return service.findAll();
    }

    @PostMapping("/save")
    public ProductoDTO saveProducto(@RequestBody ProductoDTO productoDTO) {
        return service.save(productoDTO);
    }

    @PutMapping("/update")
    public ProductoDTO updateProducto(@RequestBody ProductoDTO productoDTO) {
        return service.update(productoDTO);
    }
}
