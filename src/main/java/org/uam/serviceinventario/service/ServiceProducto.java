package org.uam.serviceinventario.service;

import jakarta.transaction.Transactional;
import jdk.jfr.TransitionTo;
import org.hibernate.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.uam.serviceinventario.dto.ProductoDTO;
import org.uam.serviceinventario.mapper.ProductoMapper;
import org.uam.serviceinventario.model.Producto;
import org.uam.serviceinventario.repository.ProductoRepo;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ServiceProducto {

    private final ProductoRepo repo;
    private final ProductoMapper mapper;

    public ServiceProducto(ProductoRepo repo, ProductoMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public ProductoDTO findById(UUID id) {
        return repo.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(()-> new RuntimeException("Producto no encontrado"));
    }

    public List<ProductoDTO> findAll() {
        return repo.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
    @Transactional
    public ProductoDTO save(ProductoDTO productoDTO) {
        Producto producto = mapper.toEntity(productoDTO);
        producto = repo.save(producto);
        repo.flush();
        return mapper.toDTO(producto);
    }

    @Transactional
    public ProductoDTO update(ProductoDTO productoDTO) {
        repo.findById(productoDTO.generic().uuid()).orElseThrow(()-> new RuntimeException("No existe el registro con el id: "
                + productoDTO.generic().uuid()));
        Producto producto = mapper.toEntity(productoDTO);
        producto = repo.save(producto);
        repo.flush();
        return mapper.toDTO(producto);
    }
}
