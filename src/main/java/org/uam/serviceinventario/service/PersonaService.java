package org.uam.serviceinventario.service;

import jakarta.persistence.EntityNotFoundException;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;
import org.uam.serviceinventario.dto.PersonaDTO;
import org.uam.serviceinventario.mapper.PersonaMapper;
import org.uam.serviceinventario.model.Persona;
import org.uam.serviceinventario.repository.PersonaRepo;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PersonaService {

    private final PersonaMapper mapper;
    private final PersonaRepo repo;


    public PersonaService(PersonaMapper mapper, PersonaRepo repo) {
        this.mapper = mapper;
        this.repo = repo;
    }

    public List<PersonaDTO> findAll() {
        return mapper.toListDTO(repo
                .findAll());
    }

    public PersonaDTO save(PersonaDTO dto) {
        Persona persona = mapper.toEntity(dto);
        return mapper.toDTO(repo.save(persona));
    }

    public PersonaDTO update(PersonaDTO dto) {
         Persona persona = findById(dto.id());
         mapper.update(dto, persona);
         return mapper.toDTO(repo.save(persona));
    }

    private Persona findById(UUID id) {
        return repo.findById(id).orElseThrow(
                ()->new RuntimeException("Persona no encontrado"));
    }
}
