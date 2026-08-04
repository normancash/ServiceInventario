package org.uam.serviceinventario.service;

import jakarta.transaction.Transactional;
import jdk.jfr.TransitionTo;
import org.hibernate.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.uam.serviceinventario.dto.ProductoDTO;
import org.uam.serviceinventario.model.Producto;
import org.uam.serviceinventario.repository.ProductoRepo;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ServiceProducto {

    private final ProductoRepo repo;
    private final ModelMapper mapper;

    public ServiceProducto(ProductoRepo repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public ProductoDTO findById(UUID id) {
        return repo.findById(id)
                .map(producto -> mapper.map(producto, ProductoDTO.class))
                .orElseThrow(()-> new RuntimeException("Producto no encontrado"));
    }

    public List<ProductoDTO> findAll() {
        return repo.findAll()
                .stream()
                .map(producto -> mapper.map(producto, ProductoDTO.class))
                .collect(Collectors.toList());
    }
    @Transactional
    public ProductoDTO save(ProductoDTO productoDTO) {
        Producto producto = mapper.map(productoDTO, Producto.class);
        producto = repo.save(producto);
        repo.flush();
        return mapper.map(producto,ProductoDTO.class);
    }

    @Transactional
    public ProductoDTO update(ProductoDTO productoDTO) {
        repo.findById(productoDTO.getUuid()).orElseThrow(()-> new RuntimeException("No existe el registro con el id: " + productoDTO.getUuid()));
        Producto producto = mapper.map(productoDTO, Producto.class);
        producto = repo.save(producto);
        repo.flush();
        return mapper.map(producto,ProductoDTO.class);
    }
}
