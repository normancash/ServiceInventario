package org.uam.serviceinventario.service;

import org.springframework.stereotype.Service;
import org.uam.serviceinventario.dto.DepartamentoDTO;
import org.uam.serviceinventario.mapper.DepartamentoMapper;
import org.uam.serviceinventario.model.Departamento;
import org.uam.serviceinventario.repository.DepartamentoRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartamentoService {

    private final DepartamentoRepo repo;
    private final DepartamentoMapper mapper;


    public DepartamentoService(DepartamentoRepo repo, DepartamentoMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public List<DepartamentoDTO> findAll() {
         return repo.findAll().stream()
                 .map(mapper::toDto)
                 .collect(Collectors.toList());
    }

    public DepartamentoDTO save(DepartamentoDTO dto) {
        Departamento entity = mapper.toEntity(dto);
        return mapper.toDto(repo.save(entity));
    }
}
