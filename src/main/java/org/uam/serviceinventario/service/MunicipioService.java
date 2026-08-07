package org.uam.serviceinventario.service;

import org.springframework.stereotype.Service;
import org.uam.serviceinventario.dto.MunicipioDTO;
import org.uam.serviceinventario.mapper.MunicipioMapper;
import org.uam.serviceinventario.model.Departamento;
import org.uam.serviceinventario.model.Municipio;
import org.uam.serviceinventario.repository.DepartamentoRepo;
import org.uam.serviceinventario.repository.MunicipioRepo;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MunicipioService {

    private final MunicipioRepo repo;
    private final MunicipioMapper mapper;
    private final DepartamentoRepo departamentoRepo;

    public MunicipioService(MunicipioRepo repo
            , MunicipioMapper mapper, DepartamentoRepo departamentoRepo) {
        this.repo = repo;
        this.mapper = mapper;
        this.departamentoRepo = departamentoRepo;
    }

    public List<MunicipioDTO> findAll() {
        return repo.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public MunicipioDTO save(MunicipioDTO dto) {
        Departamento departamento = departamentoRepo
                .findById(UUID.fromString(dto.idDepartamento()))
                .orElseThrow(()->new RuntimeException("No se encontro " +
                        "el departamento con el id:" +  dto.idDepartamento()));
        Municipio municipio = mapper.toEntity(dto);
        municipio.setDepartamento(departamento);
        return mapper.toDTO(repo.save(municipio));
    }
}
