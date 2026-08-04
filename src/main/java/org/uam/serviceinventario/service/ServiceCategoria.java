package org.uam.serviceinventario.service;

import org.springframework.stereotype.Service;
import org.uam.serviceinventario.dto.CategoriaDTO;
import org.uam.serviceinventario.model.Categoria;
import org.uam.serviceinventario.repository.CategoriaRepo;

import java.util.List;

@Service
public class ServiceCategoria {

    private final CategoriaRepo repo;

    public ServiceCategoria(CategoriaRepo repo) {
        this.repo = repo;
    }


    public List<CategoriaDTO> findAll() {
        return null;
        //repo.findAll();
    }
}
